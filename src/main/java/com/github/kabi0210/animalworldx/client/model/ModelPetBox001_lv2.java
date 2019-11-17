package com.github.kabi0210.animalworldx.client.model;// Cubik Studio 2.9.480 Beta JAVA exporter
// Designed by Tongliangcheng with Cubik Studio - https://cubik.studio

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPetBox001_lv2 extends ModelBase {

    //fields
    public ModelRenderer e1;
    public ModelRenderer e2;
    public ModelRenderer e3;
    public ModelRenderer e4;
    public ModelRenderer e5;
    public ModelRenderer e6;
    public ModelRenderer e7;
    public ModelRenderer e8;
    public ModelRenderer e9;
    public ModelRenderer e10;
    public ModelRenderer e11;
    public ModelRenderer e12;
    public ModelRenderer e13;

    public ModelPetBox001_lv2() {
        textureWidth = 64;
        textureHeight = 64;

        setModel();
    }
    private void setModel()
    {

        e1 = new ModelRenderer(this, 0, 46);
        e1.setRotationPoint(-5F, 24F, -5F);
        e1.addBox(0F, -8F, 0F, 10, 8, 10);
        e1.setTextureSize(64, 64);
        e1.mirror = false;
        setRotation(e1, 0F, 0F, 0F);
        e2 = new ModelRenderer(this, 0, 33);
        e2.setRotationPoint(-5F, 35.5F, -5F);
        e2.addBox(0F, -3F, 0F, 10, 3, 10);
        e2.setTextureSize(64, 64);
        e2.mirror = false;
        setRotation(e2, 0F, 0F, 0F);
        e3 = new ModelRenderer(this, 40, 39);
        e3.setRotationPoint(-6.5F, 24F, -8F);
        e3.addBox(0F, -4F, 0F, 5, 4, 3);
        e3.setTextureSize(64, 64);
        e3.mirror = false;
        setRotation(e3, 0F, 0F, 0F);
        e4 = new ModelRenderer(this, 40, 39);
        e4.setRotationPoint(-6.5F, 24F, 4.2F);
        e4.addBox(0F, -4F, 0F, 5, 4, 3);
        e4.setTextureSize(64, 64);
        e4.mirror = false;
        setRotation(e4, 0F, 0F, 0F);
        e5 = new ModelRenderer(this, 40, 34);
        e5.setRotationPoint(-1.5F, 24F, -7F);
        e5.addBox(0F, -3F, 0F, 2, 3, 2);
        e5.setTextureSize(64, 64);
        e5.mirror = false;
        setRotation(e5, 0F, 0F, 0F);
        e6 = new ModelRenderer(this, 40, 34);
        e6.setRotationPoint(-1.5F, 24F, 5F);
        e6.addBox(0F, -3F, 0F, 2, 3, 2);
        e6.setTextureSize(64, 64);
        e6.mirror = false;
        setRotation(e6, 0F, 0F, 0F);
        e7 = new ModelRenderer(this, 0, 24);
        e7.setRotationPoint(-6F, 26F, -2.5F);
        e7.addBox(0F, -4F, 0F, 1, 4, 5);
        e7.setTextureSize(64, 64);
        e7.mirror = false;
        setRotation(e7, 0F, 0F, 0F);
        e8 = new ModelRenderer(this, 40, 52);
        e8.setRotationPoint(5F, 24F, -3F);
        e8.addBox(0F, -6F, 0F, 3, 6, 6);
        e8.setTextureSize(64, 64);
        e8.mirror = false;
        setRotation(e8, 0F, 0F, 0F);
        e9 = new ModelRenderer(this, 58, 61);
        e9.setRotationPoint(-2.5F, 33F, 1F);
        e9.addBox(0F, -1F, 0F, 1, 1, 2);
        e9.setTextureSize(64, 64);
        e9.mirror = false;
        setRotation(e9, 0F, 0F, 0F);
        e10 = new ModelRenderer(this, 58, 58);
        e10.setRotationPoint(-2.5F, 34F, 2F);
        e10.addBox(0F, -1F, 0F, 1, 1, 2);
        e10.setTextureSize(64, 64);
        e10.mirror = false;
        setRotation(e10, 0F, 0F, 0F);
        e11 = new ModelRenderer(this, 58, 55);
        e11.setRotationPoint(-2.5F, 33F, -3F);
        e11.addBox(0F, -1F, 0F, 1, 1, 2);
        e11.setTextureSize(64, 64);
        e11.mirror = false;
        setRotation(e11, 0F, 0F, 0F);
        e12 = new ModelRenderer(this, 58, 52);
        e12.setRotationPoint(-2.5F, 34F, -4F);
        e12.addBox(0F, -1F, 0F, 1, 1, 2);
        e12.setTextureSize(64, 64);
        e12.mirror = false;
        setRotation(e12, 0F, 0F, 0F);
        e13 = new ModelRenderer(this, 40, 47);
        e13.setRotationPoint(-6.5F, 32F, -2F);
        e13.addBox(0F, -0.5F, 0F, 6, 1, 4);
        e13.setTextureSize(64, 64);
        e13.mirror = false;
        setRotation(e13, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
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
        e11.render(f5);
        e12.render(f5);
        e13.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
     
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.e3.rotateAngleY=3.15F;
        this.e4.rotateAngleY=3.15F;
    }
 
}