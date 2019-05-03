package com.nickb.frcmod.blocks;

import com.nickb.frcmod.main;

import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Blockore extends Blockbase {

	public Blockore(String name) {
		super(Material.ROCK, name);
	
		setHardness(3f);
		setResistance(5f);
	}
	@Override
	public Blockore setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(main.CREATIVE_TABS);
		return this;
	}

}