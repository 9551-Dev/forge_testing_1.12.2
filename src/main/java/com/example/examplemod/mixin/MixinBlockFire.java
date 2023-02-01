package com.example.examplemod.mixin;

import net.minecraft.block.BlockFire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Random;

@Mixin(BlockFire.class)
public class MixinBlockFire {
    @Inject(method="updateTick",at=@At("HEAD"))
    public void updateTick(World level, BlockPos pos, IBlockState state, Random random, CallbackInfo ci) {
        List<Entity> ents = level.getEntitiesWithinAABB(EntityPlayer.class,new AxisAlignedBB(pos));
        for (Entity ent : ents) {
            if (ent instanceof EntityItem) {
                EntityItem item = (EntityItem) ent;
                BlockPos iPos = item.getPosition();
                //BlockPos iPos = ent.getPosition();
                level.createExplosion(null,iPos.getX(), iPos.getY(), iPos.getZ(), 5, true);
            }
        }
    }

    @Inject(method="tickRate",at=@At("TAIL"),cancellable = true)
    public void tickRate(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(1);
    }
}
