package com.nickb.frcmod.proxy;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Proxy;

import com.nickb.frcmod.main;
import com.nickb.frcmod.Enitity.RegisterEntity;
import com.nickb.frcmod.items.RegisterItems;

import net.minecraft.item.Item;
import net.minecraft.network.play.server.SPacketCombatEvent.Event;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
@Mod.EventBusSubscriber
public class Commonproxy{
     Proxy proxy;

    public void preInit(FMLPreInitializationEvent event){
          System.out.println(main.name + " is loading!");
		      RegisterEntity.init();
     }
    public void Init(FMLInitializationEvent event){
        System.out.println(main.name + " is loaded!");
        RegisterEntity.initModels();
       
     }
    public void postInit(FMLPostInitializationEvent event){
       
    }
    public void registerItemRenderer(Item item, int meta, String id) {
       

    }
    @SubscribeEvent
	public String localize(String unlocalized, Object... args) {
		return I18n.translateToLocalFormatted(unlocalized, args);
    }
 
}