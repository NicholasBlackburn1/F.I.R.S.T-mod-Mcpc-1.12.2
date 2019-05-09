package com.nickb.frcmod.Enitity;

import javax.annotation.Nonnull;

import com.nickb.frcmod.main;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDean extends RenderLiving<Deanmod> {

    public ResourceLocation mobTexture = new ResourceLocation(main.modId+":"+"entity/dean.png");

    public static final Factory FACTORY = new Factory();

    public RenderDean(RenderManager rendermanagerIn) {
        // We use the vanilla zombie model here and we simply
        // retexture it. Of course you can make your own model
        super(rendermanagerIn, new ModelZombie(), 0.5F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull Deanmod entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<Deanmod> {

        @Override
        public Render<? super Deanmod> createRenderFor(RenderManager manager) {
            return new RenderDean(manager);
        }

    }

}
