package com.nickb.frcmod.items;

import com.nickb.frcmod.main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Itembase extends Item {
    protected String name;

	public Itembase(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	public void registerItemModel() {
	    main.proxy.registerItemRenderer(this, 0, name);
	}
	
	@Override
	public Itembase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}