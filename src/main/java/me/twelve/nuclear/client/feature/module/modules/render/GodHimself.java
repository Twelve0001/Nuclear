package me.twelve.nuclear.client.feature.module.modules.render;

import me.twelve.nuclear.client.feature.module.Module;
import me.x150.renderer.renderer.Renderer2d;
import me.x150.renderer.renderer.Renderer3d;
import me.x150.renderer.renderer.color.Color;
import net.minecraft.client.util.math.MatrixStack;

public class GodHimself extends Module {
    public GodHimself() {

        super("GodHimself", "im testing your mom a second time", ModuleType.TEST);
    }

    @Override
    public void Enable() {

    }

    @Override
    public void Disable() {

    }

    @Override
    public void Tick() {

    }

    @Override
    public void onWorldRender(MatrixStack stack) {

    }

    @Override
    public void onHudRender() {

        Renderer2d.renderRoundedQuad(Renderer3d.getEmptyMatrixStack(), new Color(20, 20,20), 5, 5, 100, 100, 5 ,20);
    }
}
