package com.nickb.frcmod.items;

import com.nickb.frcmod.main;

import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {

	protected String name;

	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}

	public void registerItemModel() {
		main.proxy.registerItemRenderer(this, 0, name);
	}
		@Override
	public ItemBase setCreativeTab(CreativeTabs tab) {
		setCreativeTab(main.CREATIVE_TABS);
		return this;
	}

}