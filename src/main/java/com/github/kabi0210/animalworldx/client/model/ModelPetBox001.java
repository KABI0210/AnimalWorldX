// Cubik Studio 2.9.480 Beta JAVA exporter
// Designed by kabi0210 with Cubik Studio - https://cubik.studio
package com.github.kabi0210.animalworldx.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPetBox001 extends ModelBase {
    //fields
    public ModelRenderer e1;
    public ModelRenderer e2;
    public ModelRenderer e3;
    public ModelRenderer e4;
    public ModelRenderer e5;

    public ModelPetBox001() {
        textureWidth = 64;
        textureHeight = 64;

        setModel();
    }

    private void setModel() {
        e1 = new ModelRenderer(this, 0, 18);
        e1.setRotationPoint(-4F, 24F, -5F);
        e1.addBox(0F, -6F, 0F, 8, 6, 8);
        e1.setTextureSize(32, 32);
        e1.mirror = false;
        setRotation(e1, 0F, 0F, 0F);
        e2 = new ModelRenderer(this, 0, 8);
        e2.setRotationPoint(-2F, 13F, -5F);
        e2.addBox(0F, -2F, 0F, 8, 2, 8);
        e2.setTextureSize(32, 32);
        e2.mirror = false;
        setRotation(e2, 0F, 0F, 0.695F);
        e3 = new ModelRenderer(this, 0, 5);
        e3.setRotationPoint(-7F, 18F, -2F);
        e3.addBox(0F, -0.5F, 0F, 7, 1, 2);
        e3.setTextureSize(32, 32);
        e3.mirror = false;
        setRotation(e3, 0F, 0F, 0F);
        e4 = new ModelRenderer(this, 0, 2);
        e4.setRotationPoint(-1.5F, 17F, -3.5F);
        e4.addBox(0F, -1.5F, 0F, 1, 2, 1);
        e4.setTextureSize(32, 32);
        e4.mirror = false;
        setRotation(e4, 0F, 0F, 0F);
        e5 = new ModelRenderer(this, 0, 2);
        e5.setRotationPoint(-1.5F, 17F, 0.5F);
        e5.addBox(0F, -1.5F, 0F, 1, 2, 1);
        e5.setTextureSize(32, 32);
        e5.mirror = false;
        setRotation(e5, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        e1.render(f5);
        e2.render(f5);
        e3.render(f5);
        e4.render(f5);
        e5.render(f5);

        //setModel();
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.e4.rotateAngleZ=0.5f;
        this.e5.rotateAngleZ=0.5f;
    }
}