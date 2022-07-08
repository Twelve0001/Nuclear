package me.twelve.nuclear.client.mixin;

import me.twelve.nuclear.client.feature.module.ModuleRegistry;
import me.twelve.nuclear.client.feature.module.Module;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @Inject(method = "tick", at = @At("TAIL"))
    void postTick(CallbackInfo ci) {
        for (Module module : ModuleRegistry.getModules()) {
            if (module.isEnabled()) module.Tick();
        }

    }

}
