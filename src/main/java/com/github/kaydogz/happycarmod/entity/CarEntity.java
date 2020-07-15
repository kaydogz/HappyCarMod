package com.github.kaydogz.happycarmod.entity;

import com.github.kaydogz.happycarmod.client.ClientHandler;
import com.github.kaydogz.happycarmod.util.HCMSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.List;

public class CarEntity extends Entity {

    private static final DataParameter<Float> SPEED = EntityDataManager.createKey(CarEntity.class, DataSerializers.FLOAT);
    private static final DataParameter<Boolean> PEDAL_DOWN = EntityDataManager.createKey(CarEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Float> TURN_CHANGE = EntityDataManager.createKey(CarEntity.class, DataSerializers.FLOAT);
    private static final DataParameter<Boolean> REVERSE = EntityDataManager.createKey(CarEntity.class, DataSerializers.BOOLEAN);

    public float wheelRotation = 0.0F;

    public CarEntity(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    @Override
    protected void registerData() {
        this.dataManager.register(SPEED, 0.0F);
        this.dataManager.register(PEDAL_DOWN, false);
        this.dataManager.register(TURN_CHANGE, 0.0F);
        this.dataManager.register(REVERSE, false);
    }

    public float getSpeed() {
        return this.dataManager.get(SPEED);
    }

    public void setSpeed(float speedIn) {
        this.dataManager.set(SPEED, MathHelper.clamp(speedIn, -this.getMaxSpeed() / 2, this.getMaxSpeed()));
    }

    public void setPedalDown(boolean pedalDownIn) {
        this.dataManager.set(PEDAL_DOWN, pedalDownIn);
    }

    public boolean isPedalDown() {
        return this.dataManager.get(PEDAL_DOWN);
    }

    public boolean isReverse() {
        return this.dataManager.get(REVERSE);
    }

    public void setReverse(boolean reverseIn) {
        this.dataManager.set(REVERSE, reverseIn);
    }

    public float getTurnChange() {
        return this.dataManager.get(TURN_CHANGE);
    }

    public void setTurnChange(float turnChangeIn) {
        this.dataManager.set(TURN_CHANGE, turnChangeIn);
    }

    public float getWheelRotation() {
        return this.wheelRotation;
    }

    public void setWheelRotation(float wheelRotationIn) {
        this.wheelRotation = MathHelper.clamp(wheelRotationIn, -1.0F, 1.0F);
    }

    public void accelerateForward() {
        float speed = this.getSpeed();
        if (speed == 0.0F) {
            speed = 0.1F;
        } else if (speed > 0.0F) {
            speed *= 1.05F;
        } else {
            speed *= 0.60F;
        }
        this.setSpeed(speed);

        this.setMotion(this.getMotion().add(Vec3d.fromPitchYaw(this.rotationPitch, this.rotationYaw).scale(Math.abs(speed))));
    }

    public void accelerateBackward() {
        float speed = this.getSpeed();
        if (speed == 0.0F) {
            speed = -0.1F;
        } else if (speed < 0.0F) {
            speed *= 1.05F;
        } else {
            speed *= 0.60F;
        }
        this.setSpeed(speed);

        this.setMotion(this.getMotion().subtract(Vec3d.fromPitchYaw(this.rotationPitch, this.rotationYaw).scale(Math.abs(speed))));
    }

    public void slowDown() {
        float speed = this.getSpeed();
        if (speed > 0.0F) {
            if (speed <= 0.05F) {
                speed = 0.0F;
            } else {
                speed *= 0.60F;
            }
        } else if (speed != 0.0F) {
            if (speed >= -0.05F) {
                speed = 0.0F;
            } else {
                speed *= 0.60F;
            }
        }

        this.setSpeed(speed);
    }

    public float getMaxSpeed() {
        return 0.4F;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean processInitialInteract(PlayerEntity player, Hand hand) {
        if (super.processInitialInteract(player, hand)) return true;
        if (player.isSecondaryUseActive()) {
            return false;
        } else if (this.isBeingRidden()) {
            return true;
        } else {
            if (!this.world.isRemote) {
                player.startRiding(this);
            }

            return true;
        }
    }

    @Override
    protected void addPassenger(Entity passenger) {
        super.addPassenger(passenger);
        this.playStartSound();
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ClientHandler.playDrivingSound(this));
    }

    protected void playStartSound() {
        this.world.playSound(null, this.getPosition(), HCMSoundEvents.ENTITY_CAR_START.get(), SoundCategory.NEUTRAL, 1.0F, 1.0F);
    }

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        this.setPedalDown(false);
        this.setTurnChange(0.0F);
    }

    protected void collideWithNearbyEntities() {
        List<Entity> list = this.world.getEntitiesInAABBexcluding(this, this.getBoundingBox(), EntityPredicates.pushableBy(this));
        if (!list.isEmpty()) {
            int i = this.world.getGameRules().getInt(GameRules.MAX_ENTITY_CRAMMING);
            if (i > 0 && list.size() > i - 1 && this.rand.nextInt(4) == 0) {
                int j = 0;

                for (Entity entity : list) {
                    if (!entity.isPassenger()) {
                        ++j;
                    }
                }

                if (j > i - 1) {
                    this.attackEntityFrom(DamageSource.CRAMMING, 6.0F);
                }
            }

            for (Entity entity : list) {
                entity.applyEntityCollision(this);
            }
        }

    }

    @Override
    public void tick() {
        super.tick();

        this.prevPosX = this.getPosX();
        this.prevPosY = this.getPosY();
        this.prevPosZ = this.getPosZ();
        Vec3d vec3d = this.getMotion();
        if (!this.areEyesInFluid(FluidTags.WATER) && !this.hasNoGravity()) {
            this.setMotion(this.getMotion().add(0.0D, -0.04D, 0.0D));
        }

        if (this.world.isRemote) {
            this.noClip = false;
        } else {
            this.noClip = !this.world.hasNoCollisions(this);
            if (this.noClip) {
                this.pushOutOfBlocks(this.getPosX(), (this.getBoundingBox().minY + this.getBoundingBox().maxY) / 2.0D, this.getPosZ());
                this.setSpeed(0.0F);
            }
        }

        if (!this.onGround || horizontalMag(this.getMotion()) > (double) 1.0E-5F || (this.ticksExisted + this.getEntityId()) % 4 == 0) {
            this.move(MoverType.SELF, this.getMotion());
            float f = 0.98F;
            if (this.onGround) {
                BlockPos pos = new BlockPos(this.getPosX(), this.getPosY() - 1.0D, this.getPosZ());
                f = this.world.getBlockState(pos).getSlipperiness(this.world, pos, this) * 0.98F;
            }

            this.setMotion(this.getMotion().mul(f, 0.98D, f));
            if (this.onGround) {
                this.setMotion(this.getMotion().mul(1.0D, -0.5D, 1.0D));
            }
        }

        if (!this.areEyesInFluid(FluidTags.WATER)) {

            this.setWheelRotation(this.getWheelRotation() + this.getTurnChange());

            if (this.isPedalDown() && this.onGround) {
                if (this.isReverse()) this.accelerateBackward();
                else this.accelerateForward();
            } else {
                this.slowDown();
            }

            if (this.getSpeed() != 0.0F) {
                float rotationChange = 5.0F * this.getWheelRotation() * this.getSpeed() / this.getMaxSpeed();
                this.rotationYaw = (this.rotationYaw + rotationChange) % 360;
                for (Entity passenger : this.getPassengers()) {
                    passenger.rotationYaw = (passenger.rotationYaw + rotationChange) % 360;
                }
            }
        }

        this.isAirBorne |= this.handleWaterMovement();
        if (!this.world.isRemote) {
            double d0 = this.getMotion().subtract(vec3d).lengthSquared();
            if (d0 > 0.01D) {
                this.isAirBorne = true;
            }
        }

        this.collideWithNearbyEntities();
    }

    @Override
    public double getMountedYOffset() {
        return super.getMountedYOffset() / 0.75D * 0.10D;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
    }


    @Override
    protected void readAdditional(CompoundNBT compound) {
        if (compound.contains("WheelRotation", 99)) {
            this.setWheelRotation(compound.getFloat("WheelRotation"));
        }
    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {
        compound.putFloat("WheelRotation", this.getWheelRotation());
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
