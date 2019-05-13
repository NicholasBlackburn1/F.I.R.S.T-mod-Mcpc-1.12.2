package com.nickb.frcmod.Enitity.Robot;

import javax.annotation.Nonnull;

import com.nickb.frcmod.main;
import com.nickb.frcmod.Enitity.Robot.*;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRobot extends RenderLiving<entityRobot> {
    public static float shadowOpaque = 1;
    public ResourceLocation mobTexture = new ResourceLocation(main.modId+":"+"entity/robot.png");

    public static final Factory FACTORY = new Factory();

    public RenderRobot(RenderManager rendermanagerIn) {
        // We use the vanilla zombie model here and we simply
        // retexture it. Of course you can make your own model
        super(rendermanagerIn, new robot(), 0.5F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull entityRobot Entity) {
        return mobTexture;
    }

    public static class Factory implements IRenderFactory<entityRobot> {

        @Override
        public Render<? super entityRobot> createRenderFor(RenderManager manager) {
            return new RenderRobot(manager);
        }

    }

    
}