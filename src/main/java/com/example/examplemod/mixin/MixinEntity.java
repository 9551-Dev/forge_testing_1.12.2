package com.example.examplemod.mixin;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class MixinEntity {
    @Inject(method="isGlowing",at=@At("HEAD"),cancellable = true)
    public void isGlowing(CallbackInfoReturnable<Boolean> cir) {
        Entity ent = (Entity)(Object) this;
        cir.setReturnValue(ent.isInvisible());
    }
}
