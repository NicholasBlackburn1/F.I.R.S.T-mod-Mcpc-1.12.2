package com.nickb.frcmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.IForgeRegistry;

public class Registerblocks {
    public static Blockore RobotBuilder = new Blockore("RobotBuilder").setCreativeTab(CreativeTabs.MATERIALS);

	public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(RobotBuilder);
	}

	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
            RobotBuilder.createItemBlock()
    );
	}

	public static void registerModels() {
        RobotBuilder.registerItemModel(Item.getItemFromBlock(RobotBuilder));

	}
}