package com.github.kabi0210.animalworldx.client.render;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.client.model.ModelPetBox001;
import com.github.kabi0210.animalworldx.common.entity.EntityPetBox001;
import com.github.ksgfk.dawnfoundation.api.annotations.EntityRenderer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

@EntityRenderer(entityClass = EntityPetBox001.class)
public class RenderPetBox001 extends RenderLiving<EntityPetBox001> {
    private static final ResourceLocation local = new ResourceLocation(AnimalWorldX.MOD_ID, "textures/entity/pet_box_001.png");

    public RenderPetBox001(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelPetBox001(), 0.5f);
    }

    @Override
    public void doRender(EntityPetBox001 entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        bindEntityTexture(entity);

    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityPetBox001 entity) {
        return local;
    }
}
