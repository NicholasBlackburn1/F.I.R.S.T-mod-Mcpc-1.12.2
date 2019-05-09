package com.nickb.frcmod.blocks;

import static net.minecraft.item.Item.getItemFromBlock;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.IForgeRegistry;

public class Registerblocks {
    

       public static Robotbuilder RobotBuilder = new Robotbuilder();
       
    public static void register(IForgeRegistry<Block> iForgeRegistry) {
        iForgeRegistry.register(RobotBuilder);
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.register(RobotBuilder.createItemBlock());
    }

    public static void registerModels() {
        RobotBuilder.registerItemModel(getItemFromBlock(RobotBuilder));
	    }   

}