package com.nickb.frcmod.Enitity.Robot;

import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Sets;
import com.nickb.frcmod.main;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.functions.SetNBT;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class entityRobot extends EntityAnimal {

    public static final ResourceLocation LOOT = new ResourceLocation(main.modId + "entity/dean");
    public static final DataParameter<Boolean> SADDLED;
    public static final DataParameter<Integer> BOOST_TIME;
    public static final Set<Item> TEMPTATION_ITEMS;
    public boolean boosting;
    public int boostTime;
    public int totalBoostTime;
    
    public entityRobot(World worldIn) {
        super(worldIn);
        setSize(0.6F, 1.95F);
        
    }

   protected void initEntityAI() {
    this.tasks.addTask(0, new EntityAISwimming(this));
    this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
    this.tasks.addTask(4, new EntityAITempt(this, 1.2D, Items.CARROT_ON_A_STICK, false));
    this.tasks.addTask(4, new EntityAITempt(this, 1.2D, false, TEMPTATION_ITEMS));
    this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
    this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 1.0D));
    this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
    this.tasks.addTask(8, new EntityAILookIdle(this));
 }

 protected void applyEntityAttributes() {
    super.applyEntityAttributes();
    this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
    this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
 }

 @Nullable
 public Entity getControllingPassenger() {
    return this.getPassengers().isEmpty() ? null : (Entity)this.getPassengers().get(0);
 }

 public boolean canBeSteered() {
    Entity lvt_1_1_ = this.getControllingPassenger();
    if (!(lvt_1_1_ instanceof EntityPlayer)) {
       return false;
    } else {
       EntityPlayer lvt_2_1_ = (EntityPlayer)lvt_1_1_;
       return lvt_2_1_.getHeldItemMainhand().getItem() == Items.CARROT_ON_A_STICK || lvt_2_1_.getHeldItemOffhand().getItem() == Items.CARROT_ON_A_STICK;
    }
 }

 public void notifyDataManagerChange(DataParameter<?> p_notifyDataManagerChange_1_) {
    if (BOOST_TIME.equals(p_notifyDataManagerChange_1_) && this.world.isRemote) {
       this.boosting = true;
       this.boostTime = 0;
       this.totalBoostTime = (Integer)this.dataManager.get(BOOST_TIME);
    }

    super.notifyDataManagerChange(p_notifyDataManagerChange_1_);
 }

 protected void entityInit() {
    super.entityInit();
    this.dataManager.register(SADDLED, false);
    this.dataManager.register(BOOST_TIME, 0);
 }

 public static void registerFixesPig(DataFixer p_registerFixesPig_0_) {
    EntityLiving.registerFixesMob(p_registerFixesPig_0_, entityRobot.class);
 }

 public void writeEntityToNBT(NBTTagCompound p_writeEntityToNBT_1_) {
    super.writeEntityToNBT(p_writeEntityToNBT_1_);
    p_writeEntityToNBT_1_.setBoolean("Saddle", this.getSaddled());
 }

 public void readEntityFromNBT(NBTTagCompound p_readEntityFromNBT_1_) {
    super.readEntityFromNBT(p_readEntityFromNBT_1_);
    this.setSaddled(p_readEntityFromNBT_1_.getBoolean("Saddle"));
 }

 protected SoundEvent getAmbientSound() {
    return SoundEvents.ENTITY_ENDERMEN_DEATH;
 }

 protected SoundEvent getHurtSound(DamageSource p_getHurtSound_1_) {
    return SoundEvents.ENTITY_HORSE_ANGRY;
 }

 protected SoundEvent getDeathSound() {
    return SoundEvents.ENTITY_PIG_DEATH;
 }

 protected void playStepSound(BlockPos p_playStepSound_1_, Block p_playStepSound_2_) {
    this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
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

 public void onDeath(DamageSource p_onDeath_1_) {
    super.onDeath(p_onDeath_1_);
    if (!this.world.isRemote) {
       if (this.getSaddled()) {
          this.dropItem(Items.SADDLE, 1);
       }

    }
 }

 @Nullable
 protected ResourceLocation getLootTable() {
    return LootTableList.ENTITIES_PIG;
 }

 public boolean getSaddled() {
    return (Boolean)this.dataManager.get(SADDLED);
 }

 public void setSaddled(boolean p_setSaddled_1_) {
    if (p_setSaddled_1_) {
       this.dataManager.set(SADDLED, true);
    } else {
       this.dataManager.set(SADDLED, false);
    }

 }

 public void onStruckByLightning(EntityLightningBolt p_onStruckByLightning_1_) {
    if (!this.world.isRemote && !this.isDead) {
       EntityPigZombie lvt_2_1_ = new EntityPigZombie(this.world);
       lvt_2_1_.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
       lvt_2_1_.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
       lvt_2_1_.setNoAI(this.isAIDisabled());
       if (this.hasCustomName()) {
          lvt_2_1_.setCustomNameTag(this.getCustomNameTag());
          lvt_2_1_.setAlwaysRenderNameTag(this.getAlwaysRenderNameTag());
       }

       this.world.spawnEntity(lvt_2_1_);
       this.setDead();
    }
 }

 public void travel(float p_travel_1_, float p_travel_2_, float p_travel_3_) {
    Entity lvt_4_1_ = this.getPassengers().isEmpty() ? null : (Entity)this.getPassengers().get(0);
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
          float lvt_5_1_ = (float)this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 0.225F;
          if (this.boosting) {
             lvt_5_1_ += lvt_5_1_ * 1.15F * MathHelper.sin((float)this.boostTime / (float)this.totalBoostTime * 3.1415927F);
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
    if (this.boosting) {
       return false;
    } else {
       this.boosting = true;
       this.boostTime = 0;
       this.totalBoostTime = this.getRNG().nextInt(841) + 140;
       this.getDataManager().set(BOOST_TIME, this.totalBoostTime);
       return true;
    }
 }

 public entityRobot createChild(EntityAgeable p_createChild_1_) {
    return new entityRobot(this.world);
 }

 public boolean isBreedingItem(ItemStack p_isBreedingItem_1_) {
    return TEMPTATION_ITEMS.contains(p_isBreedingItem_1_.getItem());
 }

 static {
    SADDLED = EntityDataManager.createKey(entityRobot.class, DataSerializers.BOOLEAN);
    BOOST_TIME = EntityDataManager.createKey(entityRobot.class, DataSerializers.VARINT);
    TEMPTATION_ITEMS = Sets.newHashSet(new Item[]{Items.CARROT, Items.POTATO, Items.BEETROOT});
 }
}

