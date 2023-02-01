package com.example.examplemod.mixin;

import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Potion.class)
public class MixinPotion {
    @Redirect(method="registerPotions",at=@At(value="INVOKE",target="Lnet/minecraft/util/registry/RegistryNamespaced;register(ILjava/lang/Object;Ljava/lang/Object;)V",ordinal=1))
    static <K, V> void registerPotions(RegistryNamespaced<ResourceLocation, V> instance, int p_register_1_, K p_register_2_, V p_register_3_) {
        instance.register(p_register_1_,new ResourceLocation("whatever"),p_register_3_);
    }
}
