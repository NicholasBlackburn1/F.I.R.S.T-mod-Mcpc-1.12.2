package com.nickb.frcmod.proxy;

import com.nickb.frcmod.main;
import com.nickb.frcmod.Enitity.RegisterEntity;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class Clientproxy extends Commonproxy{
    @Override
    public void Init(FMLInitializationEvent event) {
        super.Init(event);
    }
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
	  ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(main.modId + ":" + id, "inventory"));
   }
   @Override
	public String localize(String unlocalized, Object... args) {
		return I18n.format(unlocalized, args);
	}
}