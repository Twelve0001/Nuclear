package me.twelve.nuclear.client.feature.command.commands;

import me.twelve.nuclear.client.feature.command.Command;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import java.util.Arrays;

public class Echo extends Command {
    public Echo() {

        super("Echo", "Say whatever you want", "echo", "say");
    }

    @Override
    public void execute(String[] args) {

        MinecraftClient.getInstance().player.sendMessage(Text.of("Your arguments were: " + Arrays.toString(args)));
    }
}
