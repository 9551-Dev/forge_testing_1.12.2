package com.example.examplemod.mixin;

import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import org.spongepowered.asm.mixin.*;

@Mixin(ItemEnderPearl.class)
public class MixinItemEnderPearl implements IBehaviorDispenseItem {

    @Override
    public ItemStack dispense(IBlockSource iBlockSource, ItemStack itemStack) {
        iBlockSource.getWorld().getMinecraftServer().sendMessage(new TextComponentString("yooo"));
        return null;
    }
}
