package com.example.examplemod;

import com.example.examplemod.init.ModTab;
import com.example.examplemod.proxy.CommonProxy;
import com.example.examplemod.world.TestWorldGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "1.0";
    public static final CreativeTabs tutorial_tab = new ModTab("test");

    public static Logger log;

    @Mod.Instance
    public static ExampleMod instance;

    @SidedProxy(clientSide = "com.example.examplemod.proxy.ClientProxy", serverSide = "com.example.examplemod.proxy.commonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        log = event.getModLog();
    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new TestWorldGen(),0);
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
    }
}
