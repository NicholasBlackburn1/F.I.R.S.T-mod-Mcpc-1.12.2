package com.nickb.frcmod.Enitity.Robot;

import java.util.Set;

import javax.annotation.Nullable;

import com.nickb.frcmod.main;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
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
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class entityRobot extends EntityAnimal {

    public static final ResourceLocation LOOT = new ResourceLocation(main.modId + "entity/dean");
    private static final DataParameter<Boolean> SADDLED;
    private static final DataParameter<Integer> BOOST_TIME;
    private static final Set<Item> TEMPTATION_ITEMS;
    private boolean boosting;
    private int boostTime;
    private int totalBoostTime;
    
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
        // Here we set various attributes for our mob. Like maximum health, armor,
        // speed, ...
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(5.50D);
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
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] { robot.class }));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityVillager.class, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
    }

    public boolean getSaddled() {
        return (Boolean) this.dataManager.get(SADDLED);
    }

    public void setSaddled(boolean p_setSaddled_1_) {
        if (p_setSaddled_1_) {
            this.dataManager.set(SADDLED, true);
        } else {
            this.dataManager.set(SADDLED, false);
        }

    }

    public boolean processInteract(EntityPlayer p_processInteract_1_, EnumHand p_processInteract_2_) {
        if (!super.processInteract(p_processInteract_1_, p_processInteract_2_)) {
            ItemStack lvt_3_1_ = p_processInteract_1_.getHeldItem(p_processInteract_2_);
            if (lvt_3_1_.getItem() == Items.NAME_TAG) {
                lvt_3_1_.interactWithEntity(p_processInteract_1_, this, p_processInteract_2_);
                return true;
            } else if (this.getSaddled() && !this.isBeingRidden()) {
                if (!this.world.isRemote) {
                    p_processInteract_1_.startRiding(this);
                }

                return true;
            } else if (lvt_3_1_.getItem() == Items.SADDLE) {
                lvt_3_1_.interactWithEntity(p_processInteract_1_, this, p_processInteract_2_);
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }


    @Nullable
    public Entity getControllingPassenger() {
        return this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
    }

    public boolean canBeSteered() {
        Entity lvt_1_1_ = this.getControllingPassenger();
        if (!(lvt_1_1_ instanceof EntityPlayer)) {
            return false;
        } else {
            EntityPlayer lvt_2_1_ = (EntityPlayer) lvt_1_1_;
            return lvt_2_1_.getHeldItemMainhand().getItem() == Items.CARROT_ON_A_STICK
                    || lvt_2_1_.getHeldItemOffhand().getItem() == Items.CARROT_ON_A_STICK;
        }
    }

    public void travel(float p_travel_1_, float p_travel_2_, float p_travel_3_) {
        Entity lvt_4_1_ = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
        if (this.isBeingRidden() && this.canBeSteered()) {
            this.rotationYaw = lvt_4_1_.rotationYaw;
            this.prevRotationYaw = this.rotationYaw;
            this.rotationPitch = lvt_4_1_.rotationPitch * 0.5F;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.renderYawOffset = this.rotationYaw;
            this.rotationYawHead = this.rotationYaw;
            this.stepHeight = 1.0F;
            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
            if (this.boosting && this.boostTime++ > this.totalBoostTime) {
                this.boosting = false;
            }

            if (this.canPassengerSteer()) {
                float lvt_5_1_ = (float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
                        .getAttributeValue() * 0.225F;
                if (this.boosting) {
                    lvt_5_1_ += lvt_5_1_ * 1.15F
                            * MathHelper.sin((float) this.boostTime / (float) this.totalBoostTime * 3.1415927F);
                }

                this.setAIMoveSpeed(lvt_5_1_);
                super.travel(0.0F, 0.0F, 1.0F);
            } else {
                this.motionX = 0.0D;
                this.motionY = 0.0D;
                this.motionZ = 0.0D;
            }

            this.prevLimbSwingAmount = this.limbSwingAmount;
            double lvt_5_2_ = this.posX - this.prevPosX;
            double lvt_7_1_ = this.posZ - this.prevPosZ;
            float lvt_9_1_ = MathHelper.sqrt(lvt_5_2_ * lvt_5_2_ + lvt_7_1_ * lvt_7_1_) * 4.0F;
            if (lvt_9_1_ > 1.0F) {
                lvt_9_1_ = 1.0F;
            }

            this.limbSwingAmount += (lvt_9_1_ - this.limbSwingAmount) * 0.4F;
            this.limbSwing += this.limbSwingAmount;
        } else {
            this.stepHeight = 0.5F;
            this.jumpMovementFactor = 0.02F;
            super.travel(p_travel_1_, p_travel_2_, p_travel_3_);
        }
    }

    public boolean boost() {
        if (this.boost()) {
            return false;
        } else {
            this.boosting = true;
            this.boostTime = 0;
            this.totalBoostTime = this.getRNG().nextInt(841) + 140;
            this.getDataManager().set(BOOST_TIME, this.totalBoostTime);
            return true;
        }
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return LOOT;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 5;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable arg0) {
        return null;
    }
  
}