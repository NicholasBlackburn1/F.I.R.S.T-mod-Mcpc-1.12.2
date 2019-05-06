package com.nickb.frcmod.blocks;

import com.nickb.frcmod.main;
import com.nickb.frcmod.blocks.Blockbase;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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