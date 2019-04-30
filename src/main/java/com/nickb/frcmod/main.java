package com.nickb.frcmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = main.modId, name = main.name, version = main.version)
public class main{
    
	public static final String modId = "frc";
	public static final String name = "F.I.R.S.T Robotics mod";
	public static final String version = "1.0.0";

	@Mod.Instance(modId)
	public static main instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(name + " is loading!");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

}

}