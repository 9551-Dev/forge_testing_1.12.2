package com.example.examplemod.mixin;

import com.example.examplemod.tools.misc.EntityExplosionPower;
import com.example.examplemod.tools.misc.EntityExplosionPowerRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;

@Mixin(EntityItem.class)
public class MixinEntityItem {
    private final HashMap<Item, EntityExplosionPower> explosion_powers = new EntityExplosionPowerRegister().get_list();

    @Inject(method="dealFireDamage",at=@At("HEAD"))
    public void dealFireDamage(int p_dealFireDamage_1_, CallbackInfo ci) {
        EntityItem itemEntity = (EntityItem)(Object) this;

        World level = itemEntity.getEntityWorld();
        Item item = itemEntity.getItem().getItem();
        if (this.explosion_powers.containsKey(item)) {
            BlockPos pos = itemEntity.getPosition();

            int explosion_power = (int)(Math.pow(itemEntity.getItem().getCount(),(1/this.explosion_powers.get(item).getExplosionPowerFunction())));

            level.createExplosion(null,pos.getX(), pos.getY(), pos.getZ(), explosion_power, true);
        }
    }
}
