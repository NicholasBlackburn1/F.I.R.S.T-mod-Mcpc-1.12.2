package com.nickb.frcmod.Events;

import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.stream.JsonReader;
import com.nickb.frcmod.blocks.Robotbuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.audio.SoundList;
import net.minecraft.client.audio.SoundRegistry;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.network.ServerStatusResponse.Players;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;

public class Robobuilderevent {

    @SubscribeEvent
    public static void onJoin(PlayerLoggedInEvent event) { 
        event.player.sendMessage(new TextComponentString("§l§6F.I.R.S.T Robotics §o§2 Is Loaded"));
        
    
    }
}