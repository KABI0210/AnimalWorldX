package com.github.kabi0210.animalworldx.common.entity;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.ksgfk.dawnfoundation.api.annotations.EntityRegistry;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

@EntityRegistry(modId = AnimalWorldX.MOD_ID,
        name = "pet_box_001",
        id = 233,
        eggColor1 = 0,
        eggColor2 = 0,
        canNaturalGenerate = false)
public class EntityPetBox001 extends EntityLiving {
    public EntityPetBox001(World worldIn) {
        super(worldIn);
    }
}
