package me.twelve.nuclear.client.feature.module.modules.render;

import me.twelve.nuclear.client.NuclearMain;
import me.twelve.nuclear.client.feature.module.Module;
import me.x150.renderer.renderer.Renderer3d;
import me.x150.renderer.renderer.color.Color;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;

public class TheAlmightyCube extends Module {
    public TheAlmightyCube() {

        super("TheAlmightyCube", "im testing your mom rn", ModuleType.TEST);
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

        Vec3d playerPosition = NuclearMain.client.player.getPos();
        Vec3d targetPosition = playerPosition.add(0, 2, 0);

        Renderer3d.startRenderingThroughWalls();
        Renderer3d.renderBlockWithEdges(targetPosition, new Vec3d(1, 1, 1), Color.GREEN, Color.RED).drawAllWithoutVbo(stack);
        Renderer3d.stopRenderingThroughWalls();
    }

    @Override
    public void onHudRender() {

    }
}
