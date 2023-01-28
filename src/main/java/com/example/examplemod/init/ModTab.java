package com.example.examplemod.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModTab extends CreativeTabs {
    public ModTab(String name) {
        super(name);
    }

    @Override
    public ItemStack getTabIconItem() {
        return ModItems.TESTITEM.getDefaultInstance();
    }
}
