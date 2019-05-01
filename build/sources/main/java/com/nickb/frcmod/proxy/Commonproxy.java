package com.nickb.frcmod.proxy;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Proxy;

import com.nickb.frcmod.main;
import com.nickb.frcmod.items.RegisterItems;

import net.minecraft.item.Item;
import net.minecraft.network.play.server.SPacketCombatEvent.Event;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class Commonproxy{
     Proxy proxy;
     
    public void registerItemRenderer(Item item, int meta, String id) {
       

    }
}