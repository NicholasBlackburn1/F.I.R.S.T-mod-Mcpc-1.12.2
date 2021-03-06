package com.nickb.frcmod;

import com.nickb.frcmod.Tabs.Tabs;
import com.nickb.frcmod.blocks.Registerblocks;
import com.nickb.frcmod.items.RegisterItems;
import com.nickb.frcmod.proxy.Commonproxy;
import com.nickb.frcmod.Enitity.RegisterEntity;
import com.nickb.frcmod.Events.Robobuilderevent;
import com.nickb.frcmod.Tabs.*;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = main.modId, name = main.name, version = main.version)
public class main {

	public static final String modId = "frc";
	public static final String name = "F.I.R.S.T Robotics mod";
	public static final String version = "1.0.0";

	@SidedProxy(serverSide = "com.nickb.frcmod.proxy.Serverproxy", clientSide = "com.nickb.frcmod.proxy.Clientproxy")
	public static Commonproxy proxy;

	@Mod.Instance(modId)
	public static main instance;
	public static final Tabs CREATIVE_TABS = new Tabs();

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	System.out.println(name + " is loading!");
		proxy.preInit(event);

	}

	//
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	// Post Forge Init
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
		@SubscribeEvent
		public static void Login(PlayerLoggedInEvent event) {
			Robobuilderevent.onJoin(event);
		}
	}
