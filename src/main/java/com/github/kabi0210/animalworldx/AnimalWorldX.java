package com.github.kabi0210.animalworldx;

import com.github.kabi0210.animalworldx.annotations.RegisterManager;
import com.github.kabi0210.animalworldx.common.CommonProxy;
import com.github.kabi0210.animalworldx.common.init.AWItems;
import com.github.kabi0210.animalworldx.utility.AnimalWorldXUpdate;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = AnimalWorldX.MOD_ID,
        name = AnimalWorldX.MOD_NAME,
        version = AnimalWorldX.VERSION,
        updateJSON = AnimalWorldX.UPDATEJSON
)
public enum AnimalWorldX {
    INSTANCE;

    public static final String MOD_ID = "animalworldx";
    public static final String MOD_NAME = "AnimalWorldX";
    public static final String VERSION = "@version@";
    public static final String CLIENT = "com.github.kabi0210.animalworldx.client.ClientProxy";
    public static final String COMMON = "com.github.kabi0210.animalworldx.common.CommonProxy";
    public static final String UPDATE = "https://api.github.com/repos/KABI0210/AnimalWorldX/releases";
    public static final String UPDATEJSON = "https://github.com/KABI0210/AnimalWorldX/blob/master/update.json";

    @SidedProxy(clientSide = AnimalWorldX.CLIENT, serverSide = AnimalWorldX.COMMON, modId = AnimalWorldX.MOD_ID)
    public static CommonProxy proxy;

    private static Logger logger = LogManager.getLogger(MOD_ID);

    private AnimalWorldXUpdate update;

    public final CreativeTabs mainTab = new CreativeTabs(MOD_ID + ".main") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(AWItems.test);
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) throws IllegalAccessException, ClassNotFoundException {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void gameStart(FMLLoadCompleteEvent event) {
        update = new AnimalWorldXUpdate();
        new Thread(update).start();
        RegisterManager.clean();
    }

    @Mod.InstanceFactory
    public static AnimalWorldX getInstance() {
        return INSTANCE;
    }

    public static Logger getLogger() {
        return logger;
    }

    public AnimalWorldXUpdate getUpdate() {
        return update;
    }
}
