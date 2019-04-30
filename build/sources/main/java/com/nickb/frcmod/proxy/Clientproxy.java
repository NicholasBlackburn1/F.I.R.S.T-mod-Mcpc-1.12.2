package com.nickb.frcmod.proxy;

import com.nickb.frcmod.main;
import com.nickb.frcmod.proxy.*;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public abstract class Clientproxy implements IProxy{
    @Override 
    public void preInit(FMLPreInitializationEvent event) {
	
	}

	@Override
	public void init(FMLInitializationEvent event) {
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {

	}



}