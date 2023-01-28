package com.example.examplemod.tools;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.init.ModBlocks;
import com.example.examplemod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
    public BlockBase(String name, Material mat) {
        super(mat);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(ExampleMod.tutorial_tab);

        ModBlocks.blocks.add(this);
        ModItems.items.add(new ItemBlock(this).setRegistryName(name));
    }

    @Override
    public void register() {
        ExampleMod.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }
}
