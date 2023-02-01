package com.example.examplemod.mixin;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
//import net.minecraft.util.text.TextComponentString;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityPlayer.class)
public class MixinEntityPlayer {
    @Inject(method = "dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/item/EntityItem;",at=@At(value="HEAD"))
    public void dropItem(ItemStack item, boolean drop1, boolean drop2, CallbackInfoReturnable<EntityItem> cir) {
        //EntityPlayer player = (EntityPlayer)(Object) this;
        //player.sendMessage(new TextComponentString("test"));
    }
}