package com.example.examplemod.common.item.behavior;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.init.ModItems;
import com.example.examplemod.tools.IHasModel;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GunPowderItemBehavior extends ItemFood implements IHasModel {
    public GunPowderItemBehavior(String name) {
        super(0,1,false);
        this.setUnlocalizedName(name);
        this.setRegistryName(ExampleMod.MODID,name);
        this.setCreativeTab(ExampleMod.tutorial_tab);

        ModItems.items.add(this);
    }

    @SideOnly(Side.CLIENT)
    public void register() {
        ExampleMod.proxy.registerItemRenderer(this,0,"inventory");
    }
}