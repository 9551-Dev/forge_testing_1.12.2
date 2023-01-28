package com.example.examplemod.tools;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.init.ModItems;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
    public ItemBase(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(ExampleMod.MODID,name);
        this.setCreativeTab(ExampleMod.tutorial_tab);

        ModItems.items.add(this);
    }

    @Override
    public void register() {
        ExampleMod.proxy.registerItemRenderer(this,0,"inventory");
    }
}
