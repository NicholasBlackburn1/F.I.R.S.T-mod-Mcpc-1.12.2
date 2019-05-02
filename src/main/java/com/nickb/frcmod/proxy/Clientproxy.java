package com.nickb.frcmod.proxy;

import com.nickb.frcmod.main;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Clientproxy extends Commonproxy{
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
	ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(main.modId + ":" + id, "inventory"));

  }
}