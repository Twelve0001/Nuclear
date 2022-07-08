package me.twelve.nuclear.client.feature.module.modules.movement;

import me.twelve.nuclear.client.NuclearMain;
import me.twelve.nuclear.client.feature.module.Module;
import me.twelve.nuclear.client.mixin.ILivingEntityMixin;
import me.x150.renderer.renderer.Renderer3d;
import me.x150.renderer.renderer.color.Color;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;

public class BHop extends Module {
    public BHop() {

        super("BHop", "fortnite", ModuleType.TEST);
    }

        @Override
        public void Enable() {

            ((ILivingEntityMixin) NuclearMain.client.player).setJumpingCooldown(0);
            }

        @Override
        public void Disable() {

        }

        @Override
        public void Tick() {

            if (NuclearMain.client.player == null || NuclearMain.client.getNetworkHandler() == null) {
                return;
            }

            Vec3d velocity = NuclearMain.client.player.getRotationVector().multiply(0.00185);
            NuclearMain.client.player.addVelocity(velocity.x, -0.04, velocity.z);

            if(NuclearMain.client.options.jumpKey.isPressed()) {
                if (NuclearMain.client.player.isOnGround()) {

                    NuclearMain.client.player.jump();
                }
            }
        }

        @Override
        public void onWorldRender (MatrixStack stack) {

            Vec3d playerPosition = NuclearMain.client.player.getPos();
            Vec3d targetPosition = playerPosition.add(-0.5, -0.01, -0.5);

            Renderer3d.startRenderingThroughWalls();
            Renderer3d.renderBlockWithEdges(targetPosition, new Vec3d(1, 0.001, 1), Color.GREEN, Color.RED).drawAllWithoutVbo(stack);
            Renderer3d.stopRenderingThroughWalls();

        }

        @Override
        public void onHudRender () {

        }
}
