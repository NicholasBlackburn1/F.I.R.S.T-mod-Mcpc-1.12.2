package com.nickb.frcmod.Enitity.Robot;

import javax.annotation.Nullable;

import com.nickb.frcmod.main;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class entityRobot extends EntityMob {

public static final ResourceLocation LOOT = new ResourceLocation(main.modId+"entity/dean");

public entityRobot(World worldIn) {
super(worldIn);
setSize(0.6F, 1.95F);
}

@Override
protected void entityInit() {
super.entityInit();

}

@Override
protected void applyEntityAttributes() {
super.applyEntityAttributes();
// Here we set various attributes for our mob. Like maximum health, armor, speed, ...
this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(10.50D);
this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
}
public void setArmsRaised(boolean armsRaised) {
}

@SideOnly(Side.CLIENT)

@Override
protected void initEntityAI() {
this.tasks.addTask(0, new EntityAISwimming(this));
this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
this.tasks.addTask(8, new EntityAILookIdle(this));
this.applyEntityAI();
}

private void applyEntityAI() {
this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[]{robot.class}));
this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityVillager.class, false));
this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
}

@Override
public boolean attackEntityAsMob(Entity entityIn) {
if (super.attackEntityAsMob(entityIn)) {
    if (entityIn instanceof EntityLivingBase) {
        // This zombie gives health boost and regeneration when it attacks
        ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 200));
        ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 200));
    }
    return true;
} else {
    return false;
}
}

@Override
@Nullable
protected ResourceLocation getLootTable() {
return LOOT;
}

@Override
protected boolean isValidLightLevel() {
return true;
}

@Override
public int getMaxSpawnedInChunk() {
return 5;
    }
}
    