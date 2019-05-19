package com.nickb.frcmod.Events;

import net.minecraft.client.Minecraft;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Riderobot {
    @SubscribeEvent
    public void onInteract(EntityInteract event)
{
	if(event.getTarget() instanceof EntityChicken)
	{
		Minecraft.getMinecraft().player.startRiding(EntityChicken)
    }
}
}