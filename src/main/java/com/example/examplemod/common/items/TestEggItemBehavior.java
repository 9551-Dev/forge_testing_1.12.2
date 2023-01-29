package com.example.examplemod.common.items;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.common.entity.TestEggEntity;
import com.example.examplemod.init.ModItems;
import com.example.examplemod.tools.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TestEggItemBehavior extends ItemEgg implements IHasModel {
    public TestEggItemBehavior(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(ExampleMod.MODID,name);
        this.setCreativeTab(ExampleMod.tutorial_tab);

        ModItems.items.add(this);
    }

    @SideOnly(Side.CLIENT)
    public void register() {
        ExampleMod.proxy.registerItemRenderer(this,0,"inventory");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World p_onItemRightClick_1_, EntityPlayer p_onItemRightClick_2_, EnumHand p_onItemRightClick_3_) {
        ItemStack lvt_4_1_ = p_onItemRightClick_2_.getHeldItem(p_onItemRightClick_3_);
        if (!p_onItemRightClick_2_.capabilities.isCreativeMode) {
            lvt_4_1_.shrink(1);
        }

        p_onItemRightClick_1_.playSound((EntityPlayer)null, p_onItemRightClick_2_.posX, p_onItemRightClick_2_.posY, p_onItemRightClick_2_.posZ, SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if (!p_onItemRightClick_1_.isRemote) {
            TestEggEntity lvt_5_1_ = new TestEggEntity(p_onItemRightClick_1_, p_onItemRightClick_2_);
            lvt_5_1_.shoot(p_onItemRightClick_2_, p_onItemRightClick_2_.rotationPitch, p_onItemRightClick_2_.rotationYaw, 0.0F, 1.5F, 1.0F);
            p_onItemRightClick_1_.spawnEntity(lvt_5_1_);
        }

        p_onItemRightClick_2_.addStat(StatList.getObjectUseStats(this));
        return new ActionResult(EnumActionResult.SUCCESS, lvt_4_1_);
    }
}