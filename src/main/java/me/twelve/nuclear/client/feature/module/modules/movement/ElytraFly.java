package me.twelve.nuclear.client.feature.module.modules.movement;

import me.twelve.nuclear.client.NuclearMain;
import me.twelve.nuclear.client.feature.module.Module;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;

public class ElytraFly extends Module {
    public ElytraFly() {

        super("ElytraFly", "i", ModuleType.TEST);
    }

    private void stop() {

        ClientCommandC2SPacket packet = new ClientCommandC2SPacket(NuclearMain.client.player,
                ClientCommandC2SPacket.Mode.START_FALL_FLYING);
        NuclearMain.client.player.networkHandler.sendPacket(packet);
    }

    @Override
    public void Enable() {

    }

    public void Disable() {

    }

    @Override
    public void Tick() {

        if (NuclearMain.client.player == null || NuclearMain.client.getNetworkHandler() == null) {
            return;
        }

        //ItemStack chest = NuclearMain.client.player.getEquippedStack(EquipmentSlot.CHEST);
        //if (chest.getItem() == Items.ELYTRA) {
            //if (NuclearMain.client.options.sneakKey.isPressed()) {

                //Vec3d velocity = NuclearMain.client.player.getRotationVector().multiply(0.1);
                //NuclearMain.client.player.addVelocity(velocity.x, velocity.y, velocity.z);
            //}
        //}

        ItemStack chest = NuclearMain.client.player.getEquippedStack(EquipmentSlot.CHEST);
        if (chest.getItem() == Items.ELYTRA) {
            if(NuclearMain.client.player.isFallFlying()) {

            float yaw = (float) Math.toRadians(NuclearMain.client.player.getYaw());
            Vec3d speed = new Vec3d(-MathHelper.sin(yaw) * 0.038, 0, MathHelper.cos(yaw) * 0.038);

            Vec3d vec = NuclearMain.client.player.getVelocity();

            if (NuclearMain.client.options.forwardKey.isPressed())
                NuclearMain.client.player.setVelocity(vec.add(speed));

            else if (NuclearMain.client.options.backKey.isPressed())
                NuclearMain.client.player.setVelocity(vec.subtract(speed));

            Vec3d vec2 = NuclearMain.client.player.getVelocity();

            if (NuclearMain.client.options.jumpKey.isPressed())
                NuclearMain.client.player.setVelocity(vec2.x, vec2.y + 0.1, vec2.z);

            else if (NuclearMain.client.options.sneakKey.isPressed())
                NuclearMain.client.player.setVelocity(vec2.x, vec2.y - 0.14, vec2.z);

                //if (NuclearMain.client.player.isTouchingWater()) {

                    //stop();
                //}
        }
    }
}

    @Override
    public void onWorldRender (MatrixStack stack) {

    }

    @Override
    public void onHudRender () {

    }
}
