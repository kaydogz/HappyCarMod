package com.github.kaydogz.happycarmod.client.audio;

import com.github.kaydogz.happycarmod.entity.CarEntity;
import com.github.kaydogz.happycarmod.util.HCMSoundEvents;
import net.minecraft.client.audio.TickableSound;
import net.minecraft.util.SoundCategory;

public class CarDrivingTickableSound extends TickableSound {

    private final CarEntity carEntity;

    public CarDrivingTickableSound(CarEntity carEntityIn) {
        super(HCMSoundEvents.ENTITY_CAR_DRIVING.get(), SoundCategory.NEUTRAL);
        this.carEntity = carEntityIn;
        this.repeat = true;
        this.repeatDelay = 800;
        this.volume = 1.0F;
        this.x = (float) this.carEntity.getPosX();
        this.y = (float) this.carEntity.getPosY();
        this.z = (float) this.carEntity.getPosZ();
    }

    @Override
    public void tick() {
        if (this.carEntity == null || !this.carEntity.isAlive() || this.carEntity.getPassengers().isEmpty()) {
            this.donePlaying = true;
        } else {
            this.x = (float) this.carEntity.getPosX();
            this.y = (float) this.carEntity.getPosY();
            this.z = (float) this.carEntity.getPosZ();
        }
    }

    @Override
    public boolean canBeSilent() {
        return true;
    }
}
