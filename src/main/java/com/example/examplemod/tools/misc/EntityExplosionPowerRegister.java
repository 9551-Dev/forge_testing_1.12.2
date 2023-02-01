package com.example.examplemod.tools.misc;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.HashMap;

public class EntityExplosionPowerRegister {
    private final HashMap<Item, EntityExplosionPower> explosion_powers;

    public EntityExplosionPowerRegister() {
        this.explosion_powers = new HashMap<>();

        this.register_all_entities();
    }

    public void register_all_entities() {
        this.explosion_powers.put(Item.getItemFromBlock(Blocks.TNT),new EntityExplosionPower(1.2F));
        this.explosion_powers.put(Items.GUNPOWDER,                  new EntityExplosionPower(2.5F));
    }

    public HashMap<Item, EntityExplosionPower> get_list() {
        return explosion_powers;
    }
}
