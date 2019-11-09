package com.github.kabi0210.animalworldx.common.entity;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.common.init.AWSound;
import com.github.ksgfk.dawnfoundation.api.annotations.EntityRegistry;
import com.google.common.base.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@EntityRegistry(modId = AnimalWorldX.MOD_ID,
        hasCustomFunction = false,
        name = "pet_box_001",
        id = 233,
        eggColor1 = 0,
        eggColor2 = 0)
public class EntityPetBox001 extends EntityGolem {


    public EntityPetBox001(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 0.8F);
    }


    protected static final DataParameter<Byte> PLAYER_CREATED = EntityDataManager.<Byte>createKey(EntityIronGolem.class, DataSerializers.BYTE);
    /**
     * deincrements, and a distance-to-home check is done at 0
     */
    private int homeCheckTimer;
    @Nullable

    private int attackTimer;
    private int holdRoseTick;

    public double box01_health, box01_speed, box01_Resistance;
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
        this.tasks.addTask(3, new EntityAIMoveThroughVillage(this, 0.6D, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.6D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityLiving.class, 10, false, true, new Predicate<EntityLiving>() {
            public boolean apply(@Nullable EntityLiving p_apply_1_) {
                return p_apply_1_ != null && IMob.VISIBLE_MOB_SELECTOR.apply(p_apply_1_) && !(p_apply_1_ instanceof EntityCreeper);
            }
        }));
    }

    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(PLAYER_CREATED, Byte.valueOf((byte) 0));
    }

    /*任务*/
    protected void updateAITasks() {

    }
    protected byte setExp(){
        byte exp=9;
       return exp;
    }

    protected  void judgeExp(byte exp1){
        if(exp1==1){
            box01_health=15.0D;
            box01_speed=0.45D;
            box01_Resistance=0.3D;
        }else if(exp1==2){
            box01_health=20.0D;
            box01_speed=0.45D;
            box01_Resistance=0.4D;
        }else if(exp1==3){
            box01_health=25.0D;
            box01_speed=0.45D;
            box01_Resistance=0.5D;
        }else if(exp1==4){
            box01_health=35.0D;
            box01_speed=0.35D;
            box01_Resistance=0.6D;
        }else if(exp1==5){
            box01_health=45.0D;
            box01_speed=0.35D;
            box01_Resistance=0.7D;
        }else if(exp1==6){
            box01_health=55.0D;
            box01_speed=0.35D;
            box01_Resistance=0.7D;
        }else if(exp1==7){
            box01_health=65.0D;
            box01_speed=0.3D;
            box01_Resistance=0.8D;
        }else if(exp1==8){
            box01_health=75.0D;
            box01_speed=0.3D;
            box01_Resistance=0.9D;
        }else if(exp1==9){
            box01_health=85.0D;
            box01_speed=0.3D;
            box01_Resistance=0.95;
        }
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


        judgeExp(setExp());
            System.out.println("a:"+ box01_health+"b:"+box01_speed+"c:"+box01_Resistance);

            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(box01_health);
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(box01_speed);
            this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(box01_Resistance);
            System.out.println("a:"+ box01_health+"b:"+box01_speed+"c:"+box01_Resistance);
          System.out.println("lllllll:"+setExp());

    }//生物属性

    /**
     * Decrements the entity's air supply when underwater
     */
    protected int decreaseAirSupply(int air) {
        return air;
    }

    protected void collideWithEntity(Entity entityIn) {
        if (entityIn instanceof IMob && !(entityIn instanceof EntityCreeper) && this.getRNG().nextInt(20) == 0) {
            this.setAttackTarget((EntityLivingBase) entityIn);
        }

        super.collideWithEntity(entityIn);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.attackTimer > 0) {
            --this.attackTimer;
        }

        if (this.holdRoseTick > 0) {
            --this.holdRoseTick;
        }

        if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(5) == 0) {
            int i = MathHelper.floor(this.posX);
            int j = MathHelper.floor(this.posY - 0.20000000298023224D);
            int k = MathHelper.floor(this.posZ);
            IBlockState iblockstate = this.world.getBlockState(new BlockPos(i, j, k));

            if (iblockstate.getMaterial() != Material.AIR) {
                this.world.spawnParticle(EnumParticleTypes.BLOCK_CRACK, this.posX + ((double) this.rand.nextFloat() - 0.5D) * (double) this.width, this.getEntityBoundingBox().minY + 0.1D, this.posZ + ((double) this.rand.nextFloat() - 0.5D) * (double) this.width, 4.0D * ((double) this.rand.nextFloat() - 0.5D), 0.5D, ((double) this.rand.nextFloat() - 0.5D) * 4.0D, Block.getStateId(iblockstate));
            }
        }
    }

    /**
     * Returns true if this entity can attack entities of the specified class.
     */
    public boolean canAttackClass(Class<? extends EntityLivingBase> cls) {
        if (this.isPlayerCreated() && EntityPlayer.class.isAssignableFrom(cls)) {
            return false;
        } else {
            return cls == EntityCreeper.class ? false : super.canAttackClass(cls);
        }
    }

    public static void registerFixesIronGolem(DataFixer fixer) {
        EntityLiving.registerFixesMob(fixer, EntityIronGolem.class);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setBoolean("PlayerCreated", this.isPlayerCreated());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setPlayerCreated(compound.getBoolean("PlayerCreated"));
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        this.attackTimer = 10;
        this.world.setEntityState(this, (byte) 4);
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) (7 + this.rand.nextInt(15)));

        if (flag) {
            entityIn.motionY += 0.4000000059604645D;
            this.applyEnchantments(this, entityIn);
        }

        this.playSound(SoundEvents.ENTITY_IRONGOLEM_ATTACK, 1.0F, 1.0F);
        return flag;
    }

    /**
     * Handler for {@link World#setEntityState}
     */
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 4) {
            this.attackTimer = 10;
            this.playSound(SoundEvents.ENTITY_IRONGOLEM_ATTACK, 1.0F, 1.0F);
        } else if (id == 11) {
            this.holdRoseTick = 400;
        } else if (id == 34) {
            this.holdRoseTick = 0;
        } else {
            super.handleStatusUpdate(id);
        }
    }



    @SideOnly(Side.CLIENT)
    public int getAttackTimer() {
        return this.attackTimer;
    }

    public void setHoldingRose(boolean p_70851_1_) {
        if (p_70851_1_) {
            this.holdRoseTick = 400;
            this.world.setEntityState(this, (byte) 11);
        } else {
            this.holdRoseTick = 0;
            this.world.setEntityState(this, (byte) 34);
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return AWSound.BOX01_HURT_SOUND;
    }//受伤音效

    protected SoundEvent getDeathSound() {
        return AWSound.BOX01_DEATH_SOUND;
    }//死亡音效

    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(AWSound.BOX01_HURT_STEP, 1.0F, 1.0F);
    }//行走音效

    @Nullable
    protected ResourceLocation getLootTable() {
       return null;
    }//掉落物

    public int getHoldRoseTick() {
        return this.holdRoseTick;
    }

    public boolean isPlayerCreated() {
        return (((Byte) this.dataManager.get(PLAYER_CREATED)).byteValue() & 1) != 0;
    }

    public void setPlayerCreated(boolean playerCreated) {
        byte b0 = ((Byte) this.dataManager.get(PLAYER_CREATED)).byteValue();

        if (playerCreated) {
            this.dataManager.set(PLAYER_CREATED, Byte.valueOf((byte) (b0 | 1)));
        } else {
            this.dataManager.set(PLAYER_CREATED, Byte.valueOf((byte) (b0 & -2)));
        }
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource cause) {


        super.onDeath(cause);
    }

}
