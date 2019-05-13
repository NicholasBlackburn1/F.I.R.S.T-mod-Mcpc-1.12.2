package com.nickb.frcmod.proxy;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

import java.lang.reflect.Proxy;

import com.nickb.frcmod.main;
import com.nickb.frcmod.Enitity.RegisterEntity;
import com.nickb.frcmod.Events.Robobuilderevent;
import com.nickb.frcmod.blocks.Registerblocks;
import com.nickb.frcmod.items.RegisterItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.network.play.server.SPacketCombatEvent.Event;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
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
       
     }
    public void postInit(FMLPostInitializationEvent event){
       
    }
    public void registerItemRenderer(Item item, int meta, String id) {
       

    }
    @SubscribeEvent
	public String localize(String unlocalized, Object... args) {
		return I18n.translateToLocalFormatted(unlocalized, args);
    }
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
        RegisterEntity.initModels();
        
    }

    @SubscribeEvent
    public static void Login(PlayerLoggedInEvent event) {
        Robobuilderevent.onJoin(event);
    }
}
