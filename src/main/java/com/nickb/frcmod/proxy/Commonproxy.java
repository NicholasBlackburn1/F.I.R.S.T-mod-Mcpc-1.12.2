package com.nickb.frcmod.proxy;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Proxy;

import com.nickb.frcmod.main;
import com.nickb.frcmod.blocks.*;
import com.nickb.frcmod.items.RegisterItems;

import net.minecraft.item.Item;
import net.minecraft.network.play.server.SPacketCombatEvent.Event;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class Commonproxy{
     Proxy proxy;
     @Override
    public void preInit(FMLPreInitializationEvent event) {
          System.out.println(name + " is loading!");
		      RegisterEntity.init();
     }
     
     @Override
    public void Init(FMLInitializationEvent event) {
          RegisterEntity.initModels();
     }

     @Override
    public void postInit(FMLPostInitializationEvent event) {
     
     }
    public void registerItemRenderer(Item item, int meta, String id) {
       

    }
    @Mod.EventBusSubscriber
	public static class RegistrationHandler {
		// Register Item's --> models / texture
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			RegisterItems.register(event.getRegistry());
			Registerblocks.registerItemBlocks(event.getRegistry());
		}
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
		  Registerblocks.register(event.getRegistry());
		}
		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent event) {
				
			Registerblocks.registerModels();
			RegisterItems.registerModels();


	  public String localize(String unlocalized, Object... args) {
		return I18n.translateToLocalFormatted(unlocalized, args);
      }
    }
}