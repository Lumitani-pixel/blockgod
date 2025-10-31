package net.normalv.systems.managers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class TargetManager extends Manager{

    public float getHealthDifference(PlayerEntity player, Entity target) {
        return player.getHealth()-target.getEntity().getHealth();
    }
}
