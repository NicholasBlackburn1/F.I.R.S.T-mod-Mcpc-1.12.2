package com.nickb.frcmod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class RegisterItem {
    public static Itembase roboaxe = new Itembase("Roboaxe").setCreativeTab(CreativeTabs.MATERIALS);
    public static Itembase robosword = new Itembase("Robosword").setCreativeTab(CreativeTabs.MATERIALS);
     
    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
               roboaxe  , robosword
        );
    }
    
    public static void registerModels() {
       roboaxe.registerItemModel();
       robosword.registerItemModel();
       
    }
}