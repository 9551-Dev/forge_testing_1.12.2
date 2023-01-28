package com.example.examplemod.init;

import com.example.examplemod.common.items.TestEggItemBehavior;
import com.example.examplemod.tools.ItemBase;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class ModItems {
    public static final ArrayList<Item> items = new ArrayList<>();

    public static final Item TESTITEM = new ItemBase("gae");
    public static final Item TESTEGGITEM = new TestEggItemBehavior("test_egg");
}
