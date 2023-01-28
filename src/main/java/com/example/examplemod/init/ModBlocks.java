package com.example.examplemod.init;

import com.example.examplemod.tools.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> blocks = new ArrayList<>();

    public static final Block TESTBLOCK = new BlockBase("gaeblock", Material.IRON);
}
