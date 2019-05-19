package com.nickb.frcmod.proxy;

import com.nickb.frcmod.Container.TestContainer;
import com.nickb.frcmod.Enitity.TestContainerTileEntity;
import com.nickb.frcmod.Gui.Robotbuildergui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiProxy implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TestContainerTileEntity) {
            return new TestContainer(player.inventory, (TestContainerTileEntity) te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TestContainerTileEntity) {
            TestContainerTileEntity containerTileEntity = (TestContainerTileEntity) te;
            return new Robotbuildergui(containerTileEntity, new TestContainer(player.inventory, containerTileEntity));
        }
        return null;
    }
}
