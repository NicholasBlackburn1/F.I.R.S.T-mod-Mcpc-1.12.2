package com.nickb.frcmod.blocks;

import static net.minecraft.item.Item.getItemFromBlock;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.IForgeRegistry;

public class Registerblocks {
    public static Blockore RobotBuilder = new Blockore("RobotBuilder").setCreativeTab(CreativeTabs.MATERIALS);

    public static void register(IForgeRegistry<Block> registry) {
        registry.register(RobotBuilder);
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.register(RobotBuilder.createItemBlock());
    }

    public static void registerModels() {
        RobotBuilder.registerItemModel(getItemFromBlock(RobotBuilder));
	    }   

}