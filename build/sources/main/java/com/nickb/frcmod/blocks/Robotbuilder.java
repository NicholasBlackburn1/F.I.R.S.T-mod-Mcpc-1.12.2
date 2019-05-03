package com.nickb.frcmod.blocks;

import com.nickb.frcmod.main;
import com.nickb.frcmod.blocks.Blockbase;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class Robotbuilder extends Blockbase{
    public Robotbuilder() {
		super(Material.ROCK, "RobotBuilder");
		super.setCreativeTab(main.CREATIVE_TABS);
	}
	
	@Override
	@Deprecated
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	@Deprecated
	public boolean isFullCube(IBlockState state) {
		return false;
	}

}