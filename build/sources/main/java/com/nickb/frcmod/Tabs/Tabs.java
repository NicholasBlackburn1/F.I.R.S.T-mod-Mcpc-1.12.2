package com.nickb.frcmod.Tabs;

import com.nickb.frcmod.main;
import com.nickb.frcmod.blocks.Registerblocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Tabs extends CreativeTabs {

	public Tabs() {
		super(main.modId);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Registerblocks.RobotBuilder);
	}

}
