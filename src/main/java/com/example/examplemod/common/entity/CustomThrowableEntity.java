package com.example.examplemod.common.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.world.World;

public abstract class CustomThrowableEntity extends EntityThrowable {
    public CustomThrowableEntity(World level, EntityPlayer player) {
        super(level,player);
    }
}
