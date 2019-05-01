package com.nickb.frcmod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class RegisterItem {
    public static Itembase roborio = new Itembase("Roborio").setCreativeTab(CreativeTabs.MATERIALS);
    public static Itembase tallonsrx = new Itembase("Tallonsex").setCreativeTab(CreativeTabs.MATERIALS);
     
    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                roborio , tallonsrx
        );
    }
    
    public static void registerModels() {
       roborio.registerItemModel();
       tallonsrx.registerItemModel();
       
    }
}