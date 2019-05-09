package com.nickb.frcmod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class RegisterItems {
	public static ItemBase ingotCopper = new ItemBase("ingot_copper");
	public static ItemBase wire = new ItemBase("wire");
	public static ItemBase roborio = new ItemBase("roborio");
	public static ItemBase tallonsrx = new ItemBase("tallon_srx");
	public static ItemBase weels = new ItemBase("weels");
	public static ItemBase pdp = new ItemBase("pdp");


	
   // public static ItemBase roborio = new ItemBase("roborio").setCreativeTab(CreativeTabs.COMBAT);

public static void register(IForgeRegistry<Item> registry) {
	registry.registerAll(
			ingotCopper , wire , roborio , tallonsrx , weels , pdp
	);
}

public static void registerModels() {
  
	ingotCopper.registerItemModel();
	//wire.registerItemModel();
	roborio.registerItemModel();
	tallonsrx.registerItemModel();
	weels.registerItemModel();
	//pdp.registerItemModel();

    }
}
