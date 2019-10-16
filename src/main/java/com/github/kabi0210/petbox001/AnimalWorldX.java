package com.github.kabi0210.petbox001;

import com.github.kabi0210.petbox001.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;


@Mod(modid=AnimalWorldX.MOD_ID,name=AnimalWorldX.MOD_NAME,version=AnimalWorldX.VERSION)

public enum AnimalWorldX {
    INSTANCE;
    public static final String MOD_ID="animalworldx";
    public static final String MOD_NAME="animalworldx";
    public static final String VERSION="@version@";

    @SidedProxy(clientSide=AnimalWorldX.CLIENT,serverSide=AnimalWorldX.COMMON,modId=AnimalWorldX.MOD_ID)
        public static CommonProxy proxy;
        public static final String COMMON="com.github.kabi0210.petbox001.common.CommonProxy";
        public static final String CLIENT="com.github.kabi0210.petbox001.client.ClientProxy";

    @Mod.InstanceFactory
    public static AnimalWorldX getInstance() {
        return INSTANCE;
    }


}
