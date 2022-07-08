package me.twelve.nuclear.client.mixin;

import me.twelve.nuclear.client.NuclearMain;
import me.twelve.nuclear.client.feature.command.Command;
import me.twelve.nuclear.client.feature.command.CommandRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Arrays;

@Mixin(ChatScreen.class)
public class ChatScreenMixin {
    @Redirect(method = "sendMessage", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;sendChatMessage(Ljava/lang/String;Lnet/minecraft/text/Text;)V"))
    void redirectSendChatMessage(ClientPlayerEntity instance, String message, Text preview) {

        //command handler

        if (message.startsWith(NuclearMain.PREFIX)) {

            String trimmedMessage = message.substring(NuclearMain.PREFIX.length());
            if (trimmedMessage.isEmpty() || trimmedMessage.isBlank()) return;

            String[] messageSplit = trimmedMessage.trim().split(" +");
            String command = messageSplit[0];
            String[] args = Arrays.copyOfRange(messageSplit, 1, messageSplit.length);

            Command toRun = CommandRegistry.getByAlias(command);
            if (toRun == null) {

                MinecraftClient.getInstance().player.sendMessage(Text.of("Command not found."));
            } else {

                toRun.execute(args);
            }

        } else {
            instance.sendChatMessage(message, preview);
        }

    }
}

