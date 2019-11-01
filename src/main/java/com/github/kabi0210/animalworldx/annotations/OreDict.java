package com.github.kabi0210.animalworldx.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记需要注册矿物词典的Block和Item
 * 只有在拥有 {@link com.github.kabi0210.animalworldx.annotations.Registry} 注解的类里的字段上使用本注解才会生效
 *
 * @author KSGFK create in 2019/10/22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface OreDict {
    String key();
}
