package com.github.kabi0210.animalworldx.common.entity.petbox;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.common.entity.EntityPetBox001;
import com.github.ksgfk.dawnfoundation.api.annotations.EntityRegistry;
import net.minecraft.world.World;

/**
 * @author KSGFK create in 2019/11/15
 */
@EntityRegistry(modId = AnimalWorldX.MOD_ID,
        hasCustomFunction = false,
        name = "pet_box_001_lv1",
        id = 233,
        eggColor1 = 255 | 215 << 8,
        eggColor2 = 139 | 69 << 8 | 19 << 16)
public class PetBox001Lv1 extends EntityPetBox001 {
    public PetBox001Lv1(World worldIn) {
        super(worldIn);
    }

    @Override
    protected String setSpecialLevel() {
        return "lv1";
    }
}
