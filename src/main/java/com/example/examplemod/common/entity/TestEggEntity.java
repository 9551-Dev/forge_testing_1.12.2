package com.example.examplemod.common.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class TestEggEntity extends CustomThrowableEntity {
    public TestEggEntity(World level, EntityPlayer player) {
        super(level,player);
    }

    @Override
    protected void onImpact(RayTraceResult rayTraceResult) {
        BlockPos hit = rayTraceResult.getBlockPos();

        this.world.createExplosion(this.getThrower(), hit.getX(), hit.getY(), hit.getZ(), 5, true);
        this.setDead();
    }
}