package com.nickb.frcmod.Enitity.Robot;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class robot extends ModelBase {
	private final ModelRenderer unknown_bone;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;

	public robot() {
		textureWidth = 16;
		textureHeight = 16;

		unknown_bone = new ModelRenderer(this);
		unknown_bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		unknown_bone.cubeList.add(new ModelBox(unknown_bone, 0, 0, 5.0F, -5.0F, -8.0F, 1, 3, 16, 0.0F, false));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone, 1.5708F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -6.0F, -8.0F, 2.0F, 11, 1, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -6.0F, 7.0F, 2.0F, 11, 1, 4, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 24.0F, 0.0F);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, -7.0F, -5.0F, -8.0F, 1, 3, 16, 0.0F, true));
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, -7.0F, -2.0F, 3.0F, 1, 3, 4, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, -7.0F, -2.0F, -8.0F, 1, 3, 4, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, 5.0F, -2.0F, -8.0F, 1, 3, 4, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, 5.0F, -2.0F, 4.0F, 1, 3, 4, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, -6.0F, -3.0F, -7.0F, 11, 1, 14, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, -1.0F, -5.0F, -10.0F, 1, 1, 3, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, -5.0F, -5.0F, -12.0F, 9, 1, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entityRobot, float f, float f1, float f2, float f3, float f4, float f5) {
		unknown_bone.render(f5);
		bone.render(f5);
		bone2.render(f5);
		bone3.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}