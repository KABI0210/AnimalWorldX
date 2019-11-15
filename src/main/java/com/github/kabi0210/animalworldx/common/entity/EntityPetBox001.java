package com.github.kabi0210.animalworldx.common.entity;

import com.github.kabi0210.animalworldx.api.ILevelProvider;
import com.github.kabi0210.animalworldx.api.LevelData;
import com.github.kabi0210.animalworldx.common.init.AWItems;
import com.github.kabi0210.animalworldx.common.init.AWSound;
import com.google.common.base.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO:跳跃、自动获取
 */
public abstract class EntityPetBox001 extends EntityGolem implements ILevelProvider {
    private static final Map<String, Level> levelMap = new HashMap<>();
    private static Item blockwood1 = Item.getItemFromBlock(Block.getBlockById(5));
    private static int block4 = blockwood1.getMetadata(4);

    protected String levelName;
    protected Level level;
    private int attackTimer;

    public EntityPetBox001(World world) {
        super(world);
        this.setSize(level.width, level.height);
    }

    //ILevelProvider
    @Override
    public void registerLevel(@Nonnull String levelName, @Nullable LevelData data) {
        levelMap.put(levelName, (Level) data);
    }

    //ILevelProvider
    @Nullable
    @Override
    public LevelData getLevelData(@Nonnull String levelName) {
        return levelMap.get(levelName);
    }

    @Nullable
    @Override
    public LevelData getLevel() {
        return level;
    }

    public static Map<String, Level> getLevelMap() {
        return levelMap;
    }

    protected byte setLv() {
        byte lv = 1;
        return lv;
    }

//    protected void judgeSound(byte lv1) {
//        if (lv1 > 0 && lv1 <= 3) {
//            pet_attack_volume = 0.2F;
//        } else if (lv1 <= 6) {
//            pet_attack_volume = 0.6F;
//        } else if (lv1 <= 9) {
//            pet_attack_volume = 1.0F;
//        } else {
//            pet_attack_volume = 0.1F;
//            System.out.println("警告：宠物攻击音效等级越界");
//        }
//    }

    //    protected void judgeSize(byte lv1) {
//        if (lv1 == 1) {
//            pet_width = 0.8F;
//            pet_height = 0.8F;
//        } else if (lv1 == 2) {
//            pet_width = 0.9F;
//            pet_height = 0.9F;
//        } else if (lv1 == 3) {
//            pet_width = 1.0F;
//            pet_height = 1.0F;
//        } else if (lv1 == 4) {
//            pet_width = 1.1F;
//            pet_height = 1.1F;
//        } else if (lv1 == 5) {
//            pet_width = 1.2F;
//            pet_height = 1.2F;
//        } else if (lv1 == 6) {
//            pet_width = 1.3F;
//            pet_height = 1.3F;
//        } else if (lv1 == 7 || lv1 == 8 || lv1 == 9) {
//            pet_width = 1.5F;
//            pet_height = 1.5F;
//        } else {
//            pet_width = 0.8F;
//            pet_height = 0.8F;
//            System.out.println("警告：宠物体型等级越界");
//        }
//    }

    @SuppressWarnings("unchecked")
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.6D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPetBox001.class, 10, false, true, (Predicate<EntityPetBox001>) e -> e != null && IMob.VISIBLE_MOB_SELECTOR.apply(e)));
    }

    @Override
    protected void entityInit() {
        super.entityInit();
//        this.dataManager.register(PLAYER_CREATED, (byte) 0);
    }

    /*任务*/
    @Override
    protected void updateAITasks() {

    }

//    protected void judgeExp(byte exp1) {
//        if (exp1 == 1) {
//            box01_health = 15.0D;
//            box01_speed = 0.45D;
//            box01_Resistance = 0.3D;
//            box01_range = 8.0D;
//        } else if (exp1 == 2) {
//            box01_health = 20.0D;
//            box01_speed = 0.45D;
//            box01_Resistance = 0.4D;
//            box01_range = 16.0D;
//        } else if (exp1 == 3) {
//            box01_health = 25.0D;
//            box01_speed = 0.45D;
//            box01_Resistance = 0.5D;
//            box01_range = 24.0D;
//        } else if (exp1 == 4) {
//            box01_health = 35.0D;
//            box01_speed = 0.35D;
//            box01_Resistance = 0.6D;
//            box01_range = 32.0D;
//        } else if (exp1 == 5) {
//            box01_health = 45.0D;
//            box01_speed = 0.35D;
//            box01_Resistance = 0.7D;
//            box01_range = 32.0D;
//        } else if (exp1 == 6) {
//            box01_health = 55.0D;
//            box01_speed = 0.35D;
//            box01_Resistance = 0.7D;
//            box01_range = 32.0D;
//        } else if (exp1 == 7) {
//            box01_health = 65.0D;
//            box01_speed = 0.3D;
//            box01_Resistance = 0.8D;
//            box01_range = 48.0D;
//        } else if (exp1 == 8) {
//            box01_health = 75.0D;
//            box01_speed = 0.3D;
//            box01_Resistance = 0.9D;
//            box01_range = 48.0D;
//        } else if (exp1 == 9) {
//            box01_health = 85.0D;
//            box01_speed = 0.3D;
//            box01_Resistance = 0.95D;
//            box01_range = 48.0D;
//        } else {
//            box01_health = 1.0D;
//            box01_speed = 0.1D;
//            box01_Resistance = 0.1D;
//            box01_range = 1.0D;
//            System.out.println("警告：宠物等级越界");
//        }
//    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        setSpecialLevel();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(level.health);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(level.speed);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(level.resistance);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(level.range);
    }//生物属性

    /**
     * 在这里设置
     */
    protected abstract void setSpecialLevel();

    @Override
    protected void collideWithEntity(Entity entityIn) {
        if (entityIn instanceof EntityCreeper && this.getRNG().nextInt(20) == 0) {
            this.setAttackTarget((EntityLivingBase) entityIn);
        }
        super.collideWithEntity(entityIn);
    }//实体冲突,此处需添加一个宠物主人正在攻击的目标。

    @Override
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
            return cls == EntityCreeper.class ? true : true;
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
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        this.attackTimer = 10;
        this.world.setEntityState(this, (byte) 4);
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) (2.0F + setLv() * 2 + this.rand.nextInt(3)));//伤害值

        if (flag) {
            entityIn.motionY += 0.2000000059604645D;//击飞
            this.applyEnchantments(this, entityIn);
        }
//        judgeSound(setLv());
        this.playSound(AWSound.BOX01_ATTACK_SOUND, level.attack_volume, 1.0F);
        return flag;
    }

    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 4) {
            this.attackTimer = 10;
//            judgeSound(setLv());
            this.playSound(AWSound.BOX01_ATTACK_SOUND, level.attack_volume, 1.0F);
        } else if (id == 11) {
        } else if (id == 34) {
        } else {
            super.handleStatusUpdate(id);
        }
    }

    @SideOnly(Side.CLIENT)
    public int getAttackTimer() {
        return this.attackTimer;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return AWSound.BOX01_HURT_SOUND;
    }//受伤音效

    @Override
    protected SoundEvent getDeathSound() {
        return AWSound.BOX01_DEATH_SOUND;
    }//死亡音效

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(AWSound.BOX01_STEP_SOUND, 1.0F, 1.0F);
    }//行走音效

    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return null;
    }//掉落物

    //以下为驯服代码(待测试)
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        Item kabi1 = itemstack.getItem();
        Block kabi = Block.getBlockFromItem(kabi1);
        if (kabi instanceof BlockPlanks)//是否为木材
        {
//            judgeExp(setLv());
            if (getHealth() < (float) level.health)//是否需要进食
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
            } else {
                //此处向客户端输出一句“宠物已填饱肚子了哦”（祈祷有人解决）
                //插入动画
            }
        } else if (itemstack.getItem() == AWItems.MagicBookOfPortal) {

        }
        return true;
    }

    //不可能是自然生成...
//    public void setPlayerCreated(boolean playerCreated) {
//        byte b0 = this.dataManager.get(PLAYER_CREATED);
//        if (playerCreated) {
//            this.dataManager.set(PLAYER_CREATED, (byte) (b0 | 1));
//        } else {
//            this.dataManager.set(PLAYER_CREATED, (byte) (b0 & -2));
//        }
//    }

    @Override
    public void onDeath(@Nonnull DamageSource cause) {
        super.onDeath(cause);
    }

    public static class Level implements LevelData {
        private float attack_volume;
        private float width;
        private float height;
        private double health;
        private double speed;
        private double resistance;
        private double range;

        public Level() {
        }

        public Level(float attack_volume, float width, float height, double health, double speed, double resistance, double range) {
            this.attack_volume = attack_volume;
            this.width = width;
            this.height = height;
            this.health = health;
            this.speed = speed;
            this.resistance = resistance;
            this.range = range;
        }

        public float getAttackVolume() {
            return attack_volume;
        }

        public float getWidth() {
            return width;
        }

        public float getHeight() {
            return height;
        }

        public double getHealth() {
            return health;
        }

        public double getSpeed() {
            return speed;
        }

        public double getResistance() {
            return resistance;
        }

        public double getRange() {
            return range;
        }

        public static Builder create() {
            return new Builder();
        }

        public static class Builder {
            private Level level;

            private Builder() {
                level = new Level();
            }

            public Builder setAttackVolume(float attackVolume) {
                level.attack_volume = attackVolume;
                return this;
            }

            public Builder setWidth(float width) {
                level.width = width;
                return this;
            }

            public Builder setHeight(float height) {
                level.height = height;
                return this;
            }

            public Builder setHealth(double health) {
                level.health = health;
                return this;
            }

            public Builder setSpeed(double speed) {
                level.speed = speed;
                return this;
            }

            public Builder setResistance(double resistance) {
                level.resistance = resistance;
                return this;
            }

            public Builder setRange(double range) {
                level.range = range;
                return this;
            }

            public Level build() {
                return level;
            }
        }
    }
}
