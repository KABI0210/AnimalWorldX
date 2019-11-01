package com.github.kabi0210.animalworldx.annotations;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.discovery.ASMDataTable;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/**
 * @author KSGFK create in 2019/10/21
 */
public class RegisterManager {
    private static RegisterManager instance = new RegisterManager();

    private List<BiConsumer<Field, Object>> registerBehavior = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private List<Block> blocks = new ArrayList<>();
    private List<Pair<Field, Object>> oreDictElements = new ArrayList<>();
    private List<Class<? extends Entity>> entities = new ArrayList<>();
    private List<Class<?>> entityRenderers = new ArrayList<>();

    private RegisterManager() {
        registerBehavior.add(((field, o) -> {
            if (o instanceof Item) {
                items.add((Item) o);
            } else if (o instanceof Block) {
                blocks.add((Block) o);
            } else {
                AnimalWorldX.getLogger().warn("Type {} is not supported auto register,ignore", o.getClass().getName());
            }
        }));
        registerBehavior.add(((field, o) -> {
            if (field.isAnnotationPresent(OreDict.class)) {
                oreDictElements.add(ImmutablePair.of(field, o));
            }
        }));
    }

    public void processRegistries(ASMDataTable asmDataTable) throws IllegalAccessException, ClassNotFoundException {
        normalRegistries(asmDataTable);
        entitiesRegistries(asmDataTable);
    }

    private void normalRegistries(ASMDataTable asmDataTable) throws ClassNotFoundException, IllegalAccessException {
        for (ASMDataTable.ASMData asmData : asmDataTable.getAll(Registry.class.getName())) {
            Class<?> clz = Class.forName(asmData.getClassName());
            for (Field registry : clz.getFields()) {
                Object registryInstance = registry.get(null);
                registerBehavior.forEach((callback) -> callback.accept(registry, registryInstance));
            }
        }
    }

    private void entitiesRegistries(ASMDataTable asmDataTable) throws ClassNotFoundException, ClassCastException {
        for (ASMDataTable.ASMData asmData : asmDataTable.getAll(EntityRegistry.class.getName())) {
            Class<?> clz = Class.forName(asmData.getClassName());
            Class<? extends Entity> e = clz.asSubclass(Entity.class);
            entities.add(e);
        }
        for (ASMDataTable.ASMData asmData : asmDataTable.getAll(EntityRenderer.class.getName())) {
            Class<?> clz = Class.forName(asmData.getClassName());
            entityRenderers.add(clz);
        }
    }

    public void registerItems(RegistryEvent.Register<Item> event) {
        items.forEach(item -> event.getRegistry().register(item));
        blocks.stream()
                .map(block -> {
                    ItemBlock i = new ItemBlock(block);
                    i.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
                    return i;
                })
                .collect(Collectors.toList())
                .forEach(itemBlock -> event.getRegistry().register(itemBlock));
    }

    public void registerItemModel(ModelRegistryEvent event) {
        items.forEach(item -> ModelLoader.setCustomModelResourceLocation(item,
                0,
                new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory")));
    }

    public void registerBlocks(RegistryEvent.Register<Block> event) {
        blocks.forEach(block -> event.getRegistry().register(block));
    }

    public void registerBlockModel(ModelRegistryEvent event) {
        blocks.forEach(block -> ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                0,
                new ModelResourceLocation(Objects.requireNonNull(block.getRegistryName()), "inventory")));
    }

    public void registerOreDict() {
        for (Pair<Field, Object> p : oreDictElements) {
            OreDict oreDict = p.getLeft().getAnnotation(OreDict.class);
            Object o = p.getRight();
            if (o instanceof Item) {
                OreDictionary.registerOre(oreDict.key(), (Item) o);
            } else if (o instanceof Block) {
                OreDictionary.registerOre(oreDict.key(), (Block) o);
            } else {
                AnimalWorldX.getLogger().warn("Type {} is not supported register ore dict,ignore", o.getClass().getName());
            }
        }
    }

    public void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        entities.stream()
                .map(entityClass -> {
                    EntityRegistry anno = entityClass.getAnnotation(EntityRegistry.class);
                    EntityEntryBuilder<Entity> builder = EntityEntryBuilder.create()
                            .entity(entityClass)
                            .id(new ResourceLocation(AnimalWorldX.MOD_ID, anno.name()), anno.id())
                            .name(AnimalWorldX.MOD_ID + "." + anno.name())
                            .tracker(anno.updateRange(), anno.updateFrequency(), anno.isSendVelocityUpdates());
                    if (anno.eggColor1() != -1 && anno.eggColor2() != -1) {
                        builder.egg(anno.eggColor1(), anno.eggColor2());
                    }
                    if (anno.canNaturalGenerate()) {
                        List<Biome> biomes = Arrays.stream(anno.biomes())
                                .map((biomeName -> {
                                    Biome biome = Biome.REGISTRY.getObject(new ResourceLocation(biomeName));
                                    if (biome == null) {
                                        throw new NullPointerException("Can't find biome " + biomeName);
                                    }
                                    return biome;
                                }))
                                .collect(Collectors.toList());
                        builder.spawn(anno.creatureType(), anno.weight(), anno.min(), anno.max(), biomes);
                    }
                    return builder.build();
                })
                .collect(Collectors.toList())
                .forEach(entityEntry -> event.getRegistry().register(entityEntry));
    }

    @SuppressWarnings("unchecked")
    public void bindEntityModel(ModelRegistryEvent event) {
        entityRenderers.forEach(renderer -> {
            EntityRenderer annotation = renderer.getAnnotation(EntityRenderer.class);
            RenderingRegistry.registerEntityRenderingHandler(annotation.entityClass(), manager -> {
                try {
                    return (Render<? super Entity>) renderer.getConstructor(RenderManager.class).newInstance(manager);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    throw new IllegalArgumentException("Can't construct renderer:" + renderer.getName(), e);
                }
            });
        });
    }

    public static RegisterManager getInstance() {
        return instance;
    }

    public static void clean() {
        instance = null;
    }
}
