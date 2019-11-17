package com.github.kabi0210.animalworldx.client.render;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.client.model.ModelPetBox001_lv2;
import com.github.kabi0210.animalworldx.common.entity.EntityPetBox001_lv2;
import com.github.ksgfk.dawnfoundation.api.annotations.EntityRenderer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

@EntityRenderer(entityClass = EntityPetBox001_lv2.class)
public class RenderPetBox001_lv2 extends RenderLiving<EntityPetBox001_lv2> {
    private static final ResourceLocation local = new ResourceLocation(AnimalWorldX.MOD_ID, "textures/entity/pet_box_001_lv2.png");

    public RenderPetBox001_lv2(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelPetBox001_lv2(), 0.5f);
    }

    @Override
    public void doRender(EntityPetBox001_lv2 entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        bindEntityTexture(entity);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityPetBox001_lv2 entity) {
        return local;
    }
}
