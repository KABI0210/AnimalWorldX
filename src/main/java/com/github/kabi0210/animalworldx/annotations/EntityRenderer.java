package com.github.kabi0210.animalworldx.annotations;

import net.minecraft.entity.Entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标记Entity的Renderer
 *
 * @author KSGFK create in 2019/10/31
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EntityRenderer {
    /**
     * 该渲染类对应的生物类
     */
    Class<? extends Entity> entityClass();
}
