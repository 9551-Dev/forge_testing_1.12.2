package com.example.examplemod.mixin;

import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import org.spongepowered.asm.mixin.*;

import java.util.Objects;

@SuppressWarnings("ALL")
@Mixin(ItemEnderPearl.class)
public class MixinItemEnderPearl implements IBehaviorDispenseItem {

    @Override
    public ItemStack dispense(IBlockSource iBlockSource, ItemStack itemStack) {
        Objects.requireNonNull(iBlockSource.getWorld().getMinecraftServer()).sendMessage(new TextComponentString("yooo"));
        return null;
    }
}
