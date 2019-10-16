package com.github.kabi0210.petbox001.client.renderer;

import com.github.kabi0210.petbox001.client.model.ModelPetBox001;
import com.github.kabi0210.petbox001.common.entity.EntityPetBox001;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderPetBox001 extends RenderLiving<EntityPetBox001>
{
    private static final ResourceLocation local = new ResourceLocation("textures/entity/pet_box_001.png");
    public RenderPetBox001(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelPetBox001(),0.5f);
    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityPetBox001 entity) {
        return local;
    }
}
