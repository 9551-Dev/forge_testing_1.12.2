package com.example.examplemod.common.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class TestEggEntity extends EntityEgg {
    public TestEggEntity(World level, EntityPlayer player) {
        super(level,player);
    }

    @Override
    protected void onImpact(RayTraceResult rayTraceResult) {

        BlockPos hit = null;
        EntityLivingBase player = this.getThrower();

        if(rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK) {
            hit = rayTraceResult.getBlockPos();
        } else if(rayTraceResult.typeOfHit == RayTraceResult.Type.ENTITY) {
            hit = rayTraceResult.entityHit.getPosition();
        }

        if (hit != null) {
            this.world.createExplosion(player,hit.getX(), hit.getY(), hit.getZ(), 5, true);
            this.setDead();
        }
    }
}