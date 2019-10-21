// Cubik Studio 2.9.480 Beta JAVA exporter
// Designed by Tongliangcheng with Cubik Studio - https://cubik.studio
package com.github.kabi0210.animalworldx.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPetBox001 extends ModelBase {

    //fields
    public ModelRenderer e1;// Head01
    public ModelRenderer e2;// Main_b
    public ModelRenderer e3;// Main_L
    public ModelRenderer e4;// Under
    public ModelRenderer e5;// Tongue01
    public ModelRenderer e6;// Tongue02
    public ModelRenderer e7;// Main_L2
    public ModelRenderer e8;// Main_f
    public ModelRenderer e9;// eye01
    public ModelRenderer e10;// eye02

    public ModelPetBox001() {
        textureWidth = 64;
        textureHeight = 64;

        e1 = new ModelRenderer(this, 0, 54);
        e1.setRotationPoint(-5F, 31F, -4F);
        e1.addBox(0F, -2F, 0F, 8, 2, 8);
        e1.setTextureSize(64, 64);
        e1.mirror = false;
        setRotation(e1, 0F, 0F, 0F);
        e2 = new ModelRenderer(this, 0, 27);
        e2.setRotationPoint(2F, 24F, -4F);
        e2.addBox(0F, -7F, 0F, 1, 7, 8);
        e2.setTextureSize(64, 64);
        e2.mirror = false;
        setRotation(e2, 0F, 0F, 0F);
        e3 = new ModelRenderer(this, 18, 34);
        e3.setRotationPoint(-4F, 24F, -4F);
        e3.addBox(0F, -7F, 0F, 6, 7, 1);
        e3.setTextureSize(64, 64);
        e3.mirror = false;
        setRotation(e3, 0F, 0F, 0F);
        e4 = new ModelRenderer(this, 0, 42);
        e4.setRotationPoint(-4F, 24F, -3F);
        e4.addBox(0F, -5.5F, 0F, 6, 6, 6);
        e4.setTextureSize(64, 64);
        e4.mirror = false;
        setRotation(e4, 0F, 0F, 0F);
        e5 = new ModelRenderer(this, 18, 27);
        e5.setRotationPoint(-8F, 30.5F, -1F);
        e5.addBox(0F, -1F, 0F, 4, 1, 2);
        e5.setTextureSize(64, 64);
        e5.mirror = false;
        setRotation(e5, 0F, 0F, 0F);
        e6 = new ModelRenderer(this, 18, 30);
        e6.setRotationPoint(-4F, 29F, -1F);
        e6.addBox(0F, -2F, 0F, 4, 2, 2);
        e6.setTextureSize(64, 64);
        e6.mirror = false;
        setRotation(e6, 0F, 0F, 0F);
        e7 = new ModelRenderer(this, 18, 34);
        e7.setRotationPoint(-4F, 24F, 3F);
        e7.addBox(0F, -7F, 0F, 6, 7, 1);
        e7.setTextureSize(64, 64);
        e7.mirror = false;
        setRotation(e7, 0F, 0F, 0F);
        e8 = new ModelRenderer(this, 0, 27);
        e8.setRotationPoint(-5F, 24F, -4F);
        e8.addBox(0F, -7F, 0F, 1, 7, 8);
        e8.setTextureSize(64, 64);
        e8.mirror = false;
        setRotation(e8, 0F, 0F, 0F);
        e9 = new ModelRenderer(this, 24, 51);
        e9.setRotationPoint(-2F, 31.5F, -2F);
        e9.addBox(0F, -1.5F, 0F, 1, 2, 1);
        e9.setTextureSize(64, 64);
        e9.mirror = false;
        setRotation(e9, 0F, 0F, 0F);
        e10 = new ModelRenderer(this, 24, 51);
        e10.setRotationPoint(-2F, 31.5F, 1F);
        e10.addBox(0F, -1.5F, 0F, 1, 2, 1);
        e10.setTextureSize(64, 64);
        e10.mirror = false;
        setRotation(e10, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        e1.render(f5);
        e2.render(f5);
        e3.render(f5);
        e4.render(f5);
        e5.render(f5);
        e6.render(f5);
        e7.render(f5);
        e8.render(f5);
        e9.render(f5);
        e10.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;

    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}