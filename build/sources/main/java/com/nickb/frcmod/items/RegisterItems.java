package com.nickb.frcmod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class RegisterItems {
	public static ItemBase ingotCopper = new ItemBase("ingot_copper").setCreativeTab(CreativeTabs.MATERIALS);ase 
	
    public static ItemBase roborio = new ItemBase("roborio").setCreativeTab(CreativeTabs.COMBAT);

public static void register(IForgeRegistry<Item> registry) {
	registry.registerAll(
			ingotCopper , roborio
	);
}

public static void registerModels() {
  
	ingotCopper.registerItemModel();

    }
}
