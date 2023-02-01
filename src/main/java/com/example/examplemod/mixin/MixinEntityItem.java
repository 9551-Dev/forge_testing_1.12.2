package com.example.examplemod.mixin;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityItem.class)
public class MixinEntityItem {

    @Inject(method="dealFireDamage",at=@At("HEAD"))
    public void dealFireDamage(int p_dealFireDamage_1_, CallbackInfo ci) {
        EntityItem item = (EntityItem)(Object) this;

        World level = item.getEntityWorld();
        if (item.getItem().getItem() == Item.getItemFromBlock(Blocks.TNT)) {
            BlockPos pos = item.getPosition();

            int explosion_power = (int)(Math.pow(item.getItem().getCount(),(1/1.2)));

            level.createExplosion(null,pos.getX(), pos.getY(), pos.getZ(), explosion_power, true);
        }
    }
}
