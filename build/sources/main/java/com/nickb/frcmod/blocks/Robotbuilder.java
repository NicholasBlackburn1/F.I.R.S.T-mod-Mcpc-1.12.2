package com.nickb.frcmod.blocks;

import com.nickb.frcmod.main;
import com.nickb.frcmod.Container.TestContainer;
import com.nickb.frcmod.Enitity.TestContainerTileEntity;
import com.nickb.frcmod.blocks.Blockbase;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.collection.TraversableOnce.OnceCanBuildFrom;

public class Robotbuilder extends Blockbase  implements ITileEntityProvider {

	public static PlayerEvent player;
	public static final int GUI_ID = 1;
    public Robotbuilder() {
		super(Material.ROCK, "RobotBuilder");
		super.setCreativeTab(main.CREATIVE_TABS);
		super.hasTileEntity(true);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
			return new TestContainerTileEntity();
	}
	@Override
	public void onBlockClicked(World world, BlockPos blockpos,EntityPlayer player) {
				if (world.isRemote) {
				
			TileEntity te = world.getTileEntity(blockpos);
			if (!(te instanceof TestContainerTileEntity)) {
			}
			player.openGui(main.instance, GUI_ID, world, blockpos.getX(), blockpos.getY(), blockpos.getZ());
		}
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