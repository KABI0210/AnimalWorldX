package com.github.kabi0210.animalworldx.common.item;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.api.ILevelProvider;
import com.github.kabi0210.animalworldx.api.LevelData;
import com.github.kabi0210.animalworldx.common.container.AWGuiHandler;
import com.github.ksgfk.dawnfoundation.api.annotations.IModelRegistry;
import com.google.common.collect.HashBiMap;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author KSGFK create in 2019/11/2
 */
public class ItemMagicBookOfPortal extends AWBaseItem implements IModelRegistry, ILevelProvider {
    private static int id = 0;
    private static final HashBiMap<Integer, String> Int2StringBiMap = HashBiMap.create();

    public ItemMagicBookOfPortal() {
        super("magic_book_of_portal");
        setMaxStackSize(1);
        setMaxDamage(0);
    }

    @Override
    public void getSubItems(@Nonnull CreativeTabs tab, @Nonnull NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
            for (String lv : Int2StringBiMap.values()) {
                ItemStack stack = new ItemStack(this, 1, 0);
                setLevel(stack, lv);
                items.add(stack);
            }
        }
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, @Nonnull EnumHand handIn) {
        ActionResult<ItemStack> res = super.onItemRightClick(worldIn, playerIn, handIn);
        if (!worldIn.isRemote && res.getType() == EnumActionResult.PASS) {
            playerIn.openGui(AnimalWorldX.getInstance(), AWGuiHandler.MagicBook, worldIn, (int) playerIn.posX, (int) playerIn.posY, (int) playerIn.posZ);
            return new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
        }
        return res;
    }

    //ILevelProvider
    public void registerLevel(@Nonnull String levelName, @Nullable LevelData data) {
        if (Int2StringBiMap.containsValue(levelName)) {
            return;
        }
        Int2StringBiMap.put(id, levelName);
        id += 1;
    }

    @Nullable
    @Override
    public LevelData getLevelData(@Nonnull String levelName) {
        throw new UnsupportedOperationException("Magic Book hasn't level data");
    }

    @Nullable
    @Override
    public LevelData getLevel() {
        throw new UnsupportedOperationException("Magic Book hasn't level data");
    }

    @Nullable
    public String getLevel(@Nonnull ItemStack stack) {
        if (stack.getTagCompound() == null) {
            return null;
        }
        NBTTagCompound nbt = stack.getTagCompound();
        if (!nbt.hasKey("lv")) {
            return null;
        }
        return stack.getTagCompound().getString("lv");
    }

    public void setLevel(@Nonnull ItemStack stack, @Nonnull String level) {
        if (!Int2StringBiMap.containsValue(level)) {
            return;
        }
        NBTTagCompound tag;
        if (stack.getTagCompound() != null) {
            tag = stack.getTagCompound();
        } else {
            tag = new NBTTagCompound();
            stack.setTagCompound(tag);
        }
        tag.setString("lv", level);
    }

    //IModelRegister
    @Override
    public void registerModel() {
        ModelBakery.registerItemVariants(this, Int2StringBiMap.values()
                .stream()
                .map(str -> new ResourceLocation(this.getRegistryName() + "_" + str))
                .toArray(ResourceLocation[]::new));
        ModelLoader.setCustomMeshDefinition(this, mesh -> {
            String lv = getLevel(mesh);
            return new ModelResourceLocation(this.getRegistryName() + "_" + lv, "inventory");
        });
    }
}
