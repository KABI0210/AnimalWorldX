package com.github.kabi0210.animalworldx.common.entity;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.client.model.ModelPetBox001;
import com.github.kabi0210.animalworldx.common.init.AWItems;
import com.github.kabi0210.animalworldx.common.init.AWSound;
import com.github.ksgfk.dawnfoundation.api.annotations.EntityRegistry;
import com.google.common.base.Predicate;
import javafx.scene.input.KeyCode;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
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
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Arrays;

@EntityRegistry(modId = AnimalWorldX.MOD_ID,
        hasCustomFunction = false,
        name = "pet_box_001",
        id = 233,
        eggColor1 = 0,
        eggColor2 = 0)
public class EntityPetBox001 extends EntityGolem {
   int t =0;
    protected float pet_width,pet_height,pet_attack_volume;

    Item blockwood1= Item.getItemFromBlock(Block.getBlockById(5));
    int block4=blockwood1.getMetadata(4);



    //跳跃
    //自动获取





    protected byte setLv(){

        byte lv=1;
        return lv;
    }
    protected  void judgeSound(byte lv1){
        if(lv1>0&&lv1<=3){
            pet_attack_volume=0.2F;
        }else if(lv1<=6){
            pet_attack_volume=0.6F;
        }else if(lv1<=9){
            pet_attack_volume=1.0F;
        }else{
            pet_attack_volume=0.1F;
            System.out.println("警告：宠物攻击音效等级越界");
        }

    }

    protected  void judgeSize(byte lv1){
        if(lv1==1){
            pet_width=0.8F;
            pet_height=0.8F;
        }else if(lv1==2){
            pet_width=0.9F;
            pet_height=0.9F;
        }else if(lv1==3){
            pet_width=1.0F;
            pet_height=1.0F;
        }else if(lv1==4){
            pet_width=1.1F;
            pet_height=1.1F;
        }else if(lv1==5){
            pet_width=1.2F;
            pet_height=1.2F;
        }else if(lv1==6){
            pet_width=1.3F;
            pet_height=1.3F;
        }else if(lv1==7||lv1==8||lv1==9){
            pet_width=1.5F;
            pet_height=1.5F;
        }else{
            pet_width=0.8F;
            pet_height=0.8F;
            System.out.println("警告：宠物体型等级越界");
        }

    }

    public EntityPetBox001(World worldIn) {
        super(worldIn);
        judgeSize(setLv());
        this.setSize(pet_width, pet_height);
    }//体积


    protected static final DataParameter<Byte> PLAYER_CREATED = EntityDataManager.<Byte>createKey(EntityIronGolem.class, DataSerializers.BYTE);
    /**
     * deincrements, and a distance-to-home check is done at 0
     */
    private int homeCheckTimer;
    @Nullable

    private int attackTimer;
    private int holdRoseTick;

    public double box01_health, box01_speed, box01_Resistance,box01_range;
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.6D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityLiving.class, 10, false, true, new Predicate<EntityLiving>() {
            public boolean apply(@Nullable EntityLiving p_apply_1_) {
                return p_apply_1_ != null && IMob.VISIBLE_MOB_SELECTOR.apply(p_apply_1_) ;
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


    protected  void judgeExp(byte exp1){
        if(exp1==1){
            box01_health=15.0D;
            box01_speed=0.45D;
            box01_Resistance=0.3D;
            box01_range=8.0D;
        }else if(exp1==2){
            box01_health=20.0D;
            box01_speed=0.45D;
            box01_Resistance=0.4D;
            box01_range=16.0D;
        }else if(exp1==3){
            box01_health=25.0D;
            box01_speed=0.45D;
            box01_Resistance=0.5D;
            box01_range=24.0D;
        }else if(exp1==4){
            box01_health=35.0D;
            box01_speed=0.35D;
            box01_Resistance=0.6D;
            box01_range=32.0D;
        }else if(exp1==5){
            box01_health=45.0D;
            box01_speed=0.35D;
            box01_Resistance=0.7D;
            box01_range=32.0D;
        }else if(exp1==6){
            box01_health=55.0D;
            box01_speed=0.35D;
            box01_Resistance=0.7D;
            box01_range=32.0D;
        }else if(exp1==7){
            box01_health=65.0D;
            box01_speed=0.3D;
            box01_Resistance=0.8D;
            box01_range=48.0D;
        }else if(exp1==8){
            box01_health=75.0D;
            box01_speed=0.3D;
            box01_Resistance=0.9D;
            box01_range=48.0D;
        }else if(exp1==9){
            box01_health=85.0D;
            box01_speed=0.3D;
            box01_Resistance=0.95D;
            box01_range=48.0D;
        }else{
            box01_health=1.0D;
            box01_speed=0.1D;
            box01_Resistance=0.1D;
            box01_range=1.0D;
            System.out.println("警告：宠物等级越界");
        }
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        judgeExp(setLv());
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(box01_health);
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(box01_speed);
            this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(box01_Resistance);
            this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(box01_range);

    }//生物属性



    protected void collideWithEntity(Entity entityIn) {


            if (entityIn instanceof IMob && entityIn instanceof EntityCreeper && this.getRNG().nextInt(20) == 0) {
                this.setAttackTarget((EntityLivingBase) entityIn);
            }


            super.collideWithEntity(entityIn);


    }//实体冲突,此处需添加一个宠物主人正在攻击的目标。

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     * 经常调用，以便实体可以根据需要更新其状态。例如，僵尸和骷髅
     * *用这个来对阳光做出反应并开始燃烧。
     */
    int i=0;
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.attackTimer > 0) {
            --this.attackTimer;

        }



      //  if(true){
         /*   i++;
            if(i==10){
              //  motionY=0.3D;
               addVelocity(0.0D,0.35D,0.0D);
            }
            if(i==30){
                i=i-30;
            }*/

      // }


        /*if (this.holdRoseTick > 0) {
            --this.holdRoseTick;
        }*/

        /*if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(5) == 0) {
            int i = MathHelper.floor(this.posX);
            int j = MathHelper.floor(this.posY - 0.20000000298023224D);
            int k = MathHelper.floor(this.posZ);
            IBlockState iblockstate = this.world.getBlockState(new BlockPos(i, j, k));

            if (iblockstate.getMaterial() != Material.AIR) {
                this.world.spawnParticle(EnumParticleTypes.BLOCK_CRACK, this.posX + ((double) this.rand.nextFloat() - 0.5D) * (double) this.width, this.getEntityBoundingBox().minY + 0.1D, this.posZ + ((double) this.rand.nextFloat() - 0.5D) * (double) this.width, 4.0D * ((double) this.rand.nextFloat() - 0.5D), 0.5D, ((double) this.rand.nextFloat() - 0.5D) * 4.0D, Block.getStateId(iblockstate));
            }
        }*/
    }//状态更新,灰色部分似乎不需要.


    /**
     * Returns true if this entity can attack entities of the specified class.
     * 如果此实体可以攻击指定类的实体，则返回true。
     */
    public boolean canAttackClass(Class<? extends EntityLivingBase> cls) {

         if (EntityPlayer.class.isAssignableFrom(cls)) {
            return false;
        } else {
             return cls == EntityCreeper.class ? true: true;
        }
    }
    //此处需添加一个宠物主人正在攻击的目标。


    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     * (抽象)将子类实体数据写入NBT的受保护帮助程序方法.
     */
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);

    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     * （抽象）从NBT读取子类实体数据的受保护帮助程序方法。
     */
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setPlayerCreated(compound.getBoolean("PlayerCreated"));
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        this.attackTimer = 10;
        this.world.setEntityState(this, (byte) 4);
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) (2.0F+setLv()*2 + this.rand.nextInt(3)));//伤害值

        if (flag) {
            entityIn.motionY += 0.2000000059604645D;//击飞
            this.applyEnchantments(this, entityIn);
        }
        judgeSound(setLv());
        this.playSound(AWSound.BOX01_ATTACK_SOUND, pet_attack_volume, 1.0F);
        return flag;
    }

    /**
     * Handler for {@link World#setEntityState}
     */
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 4) {
           this.attackTimer = 10;
            judgeSound(setLv());
            this.playSound(AWSound.BOX01_ATTACK_SOUND, pet_attack_volume, 1.0F);
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



    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return AWSound.BOX01_HURT_SOUND;
    }//受伤音效

    protected SoundEvent getDeathSound() {
        return AWSound.BOX01_DEATH_SOUND;
    }//死亡音效

    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(AWSound.BOX01_STEP_SOUND, 1.0F, 1.0F);
    }//行走音效

    @Nullable
    protected ResourceLocation getLootTable() {
       return null;
    }//掉落物


    //以下为驯服代码(待测试)


    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack itemstack = player.getHeldItem(hand);
        Item magicbook = Item.getByNameOrId("minecraft:apple");
        Item kabi1=(Item)itemstack.getItem();
        Block kabi=Block.getBlockFromItem(kabi1);
       if( kabi instanceof BlockPlanks)//是否为木材
       {
           judgeExp(setLv());
           if ( getHealth()< (float)box01_health)//是否需要进食
           {
               itemstack.getMetadata();
               if (itemstack.getItem() == blockwood1 && block4 == itemstack.getMetadata()) //金和欢树恢复10滴
               {
                   if (!player.capabilities.isCreativeMode) {
                       itemstack.shrink(1);
                   }
                   this.heal((float) 10.0f);
                  //插入药水特效。
                   //插入动画
                   return true;
               } else //其他木材恢复均为5滴
               {
                   if (!player.capabilities.isCreativeMode) {
                       itemstack.shrink(1);
                   }
                   this.heal((float) 5.0f);
                   //插入药水特效
                   //插入动画
                   return true;
               }
           }else {
               //此处向客户端输出一句“宠物已填饱肚子了哦”（祈祷有人解决）
             //插入动画
           }
       }else if(itemstack.getItem() == AWItems.MagicBookOfPortal )
       {

       }
        return true;
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
