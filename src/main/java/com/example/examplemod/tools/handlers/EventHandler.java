package com.example.examplemod.tools.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber
public class EventHandler {
    @SubscribeEvent
    static void onLivingEntityUseItemFinish(LivingEntityUseItemEvent.Finish event) {
        ItemStack finished_item = event.getItem();

        PotionType type = PotionUtils.getPotionFromItem(finished_item);
        EntityLivingBase player = event.getEntityLiving();

        List<PotionEffect> effects = type.getEffects();
        for (PotionEffect i : effects) {
            if (i.getEffectName().equals("effect.moveSlowdown")) {
                int amp = i.getAmplifier();
                player.addPotionEffect(new PotionEffect(Objects.requireNonNull(Potion.getPotionById(1)),i.getDuration(),amp));
                player.removePotionEffect(i.getPotion());
            }
        }
    }

    @SubscribeEvent
    static void onPlayerDestroyItem(PlayerDestroyItemEvent event) {
        ItemStack origin = event.getOriginal();

        event.getEntityLiving().sendMessage(new TextComponentString("destroyed item"));

        if (origin.getItem() == Item.getItemFromBlock(Blocks.TNT)) {
            event.getEntityLiving().sendMessage(new TextComponentString("destroyed tnt"));
        }
    }

    @SubscribeEvent
    static void onLivingDeath(LivingDeathEvent event) {
        event.getEntityLiving().sendMessage(new TextComponentString("wow death"));
        Entity ent = event.getEntity();

        if (ent instanceof EntityItem) {
            EntityItem item = (EntityItem) ent;
            if ((item.getItem().getItem() == Item.getItemFromBlock(Blocks.TNT) && event.getSource().isFireDamage())) {
                event.getEntityLiving().sendMessage(new TextComponentString("burned tnt"));
            }
        }
    }


}
