package com.nickb.frcmod.Enitity;

import static com.nickb.frcmod.Enitity.RenderDean.FACTORY;

import com.nickb.frcmod.main;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RegisterEntity {
    static ResourceLocation dean = new ResourceLocation(main.modId+":"+"entity/dean.png");
    public static void init() {
        // Every entity in our mod has an ID (local to this mod)
       
        int id = 1;
        EntityRegistry.registerModEntity(dean, Dean.class, "Dean_kamen", id++, main.instance, 64, 3, true, 0x996600,
                0x00ff00);

        // We want our mob to spawn in Plains and ice plains biomes. If you don't add
        // this then it will not spawn automatically
        // but you can of course still make it spawn manually
        EntityRegistry.addSpawn(Dean.class, 100, 3, 5, EnumCreatureType.MONSTER, Biomes.PLAINS, Biomes.ICE_PLAINS);

        // This is the loot table for our mob
        LootTableList.register(Dean.LOOT);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(Dean.class, RenderDean.FACTORY);
        }
}