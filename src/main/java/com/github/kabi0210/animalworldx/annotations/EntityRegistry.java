package com.github.kabi0210.animalworldx.annotations;

import net.minecraft.entity.EnumCreatureType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标记需要注册的Entity类
 *
 * @author KSGFK create in 2019/10/31
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EntityRegistry {
    /**
     * 字符串ID
     */
    String name();

    /**
     * 用于网络的数字ID
     */
    int id();

    int updateRange() default 64;

    int updateFrequency() default 3;

    boolean isSendVelocityUpdates() default true;

    /**
     * 若使用默认参数，则不会生成怪物蛋
     */
    int eggColor1() default -1;

    /**
     * 若使用默认参数，则不会生成怪物蛋
     */
    int eggColor2() default -1;

    /**
     * 若此项返回false，则creatureType、weight、min、max、biomes参数无效
     */
    boolean canNaturalGenerate();

    EnumCreatureType creatureType() default EnumCreatureType.AMBIENT;

    int weight() default -1;

    int min() default -1;

    int max() default -1;

    String[] biomes() default "";
}
