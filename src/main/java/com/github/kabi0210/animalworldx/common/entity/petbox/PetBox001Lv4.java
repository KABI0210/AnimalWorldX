package com.github.kabi0210.animalworldx.common.entity.petbox;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.common.entity.EntityPetBox001_lv2;
import com.github.ksgfk.dawnfoundation.api.annotations.EntityRegistry;
import net.minecraft.world.World;

/**
 * @author KSGFK create in 2019/11/15
 */
@EntityRegistry(modId = AnimalWorldX.MOD_ID,
        hasCustomFunction = false,
        name = "pet_box_001_lv4",
        id = 234,
        eggColor1 = 255 | 215 << 8,
        eggColor2 = 139 | 69 << 8 | 19 << 16)
public class PetBox001Lv4 extends EntityPetBox001_lv2 {
    public PetBox001Lv4(World worldIn) {
        super(worldIn);
    }


}