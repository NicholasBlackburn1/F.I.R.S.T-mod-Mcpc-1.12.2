package com.nickb.frcmod.blocks;

import com.nickb.frcmod.main;
import com.nickb.frcmod.Enitity.TestContainerTileEntity;
import com.nickb.frcmod.blocks.Blockbase;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Robotbuilder extends Blockbase  implements ITileEntityProvider {

	public static final int GUI_ID = 1;
	
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
		
	@Override
		public TileEntity createNewTileEntity(World worldIn, int meta) {
				return new TestContainerTileEntity();
		}

	@Override
		public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side,
								float hitX, float hitY, float hitZ) {
				// Only execute on the server
				if (world.isRemote) {
						return true;
				}
				TileEntity te = world.getTileEntity(pos);
				if (!(te instanceof TestContainerTileEntity)) {
						return false;
				}
				player.openGui(main.instance, GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
				return true;
		}
}
