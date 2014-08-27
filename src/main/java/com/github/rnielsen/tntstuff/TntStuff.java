package com.github.rnielsen.tntstuff;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.item.Item;

@Mod(modid = TntStuff.MODID, version = TntStuff.VERSION)
public class TntStuff
{
    public static final String MODID = "tntstuffmod";
    public static final String VERSION = "1.0";

    public static Item tntWand;

    @EventHandler
    public void preInit(FMLPreInitializationEvent preInitEvent) {
        tntWand = new TNTWand();
        GameRegistry.registerItem(tntWand, "tntWand");
    }

}
