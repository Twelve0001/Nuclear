package me.twelve.nuclear.client.feature.command.commands;

import me.twelve.nuclear.client.feature.command.Command;
import me.twelve.nuclear.client.feature.module.ModuleRegistry;
import me.twelve.nuclear.client.feature.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class Toggle extends Command {

    public Toggle() { super("Toggle", "Toggles a module", "toggle", "enable", "disable"); }

    @Override
    public void execute(String[] args) {

        if (args.length == 0) {

            MinecraftClient.getInstance().player.sendMessage(Text.of("Provide a module name."));
            return;
        }

        String moduleName = args[0];
        for (Module module : ModuleRegistry.getModules()) {
            if(module.name.equalsIgnoreCase(moduleName)) {

                module.setEnabled(!module.isEnabled());

                MinecraftClient.getInstance().player.sendMessage(Text.of("Toggled " + module.name + "."));
                return;
            }
        }

        MinecraftClient.getInstance().player.sendMessage(Text.of("Module '" + moduleName + "' not found."));
    }
}
