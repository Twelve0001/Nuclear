package me.twelve.nuclear.client.feature.module.modules.world;

import me.twelve.nuclear.client.NuclearMain;
import me.twelve.nuclear.client.feature.module.Module;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class NoFall extends Module{
    public NoFall() {

        super("NoFall", "no fall damage real", ModuleType.TEST);
    }

    @Override
    public void Enable() {

    }

    @Override
    public void Disable() {

    }

    @Override
    public void Tick() {

        if (NuclearMain.client.player == null || NuclearMain.client.getNetworkHandler() == null) {
            return;
        }
        if (NuclearMain.client.player.fallDistance > 3.0) {

                NuclearMain.client.getNetworkHandler().sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(true));
        }

    }

    @Override
    public void onWorldRender(MatrixStack stack) {

    }

    @Override
    public void onHudRender() {

    }
}
