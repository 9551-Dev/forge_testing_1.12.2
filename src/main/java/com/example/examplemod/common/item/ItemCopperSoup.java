package com.example.examplemod.common.item;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.init.ModItems;
import com.example.examplemod.tools.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCopperSoup extends ItemFood implements IHasModel {
    public ItemCopperSoup(String name) {
        super(8,2,false);
        this.setUnlocalizedName(name);
        this.setRegistryName(ExampleMod.MODID,name);
        this.setCreativeTab(ExampleMod.tutorial_tab);

        ModItems.items.add(this);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World level, EntityPlayer player) {

        player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA,10*20,0,false,false));
        player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS,40*20,1,false,false));
        player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE,50*20,0,false,false));

        super.onFoodEaten(stack, level, player);
    }

    @SideOnly(Side.CLIENT)
    public void register() {
        ExampleMod.proxy.registerItemRenderer(this,0,"inventory");
    }
}
