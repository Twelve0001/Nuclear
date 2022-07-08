package me.twelve.nuclear.client.feature.module.modules.movement;

import me.twelve.nuclear.client.feature.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class Freeze extends Module {
    public Freeze() {

        super("Freeze", "Freezes your player.", ModuleType.TEST);
    }

    @Override
    public void Enable() {

    }

    @Override
    public void Disable() {

    }

    @Override
    public void Tick() {

        MinecraftClient.getInstance().player.setVelocity(0, 0, 0);
    }

    @Override
    public void onWorldRender(MatrixStack stack) {

    }

    @Override
    public void onHudRender() {

    }
}
