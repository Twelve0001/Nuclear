package me.twelve.nuclear.client.feature.command;

import me.twelve.nuclear.client.feature.command.commands.Echo;
import me.twelve.nuclear.client.feature.command.commands.Toggle;
import net.minecraft.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandRegistry {

    private static final List<Command> commands = Util.make(new ArrayList<>(), CommandRegistry::initCommands);

    private static void initCommands(List<Command> commands) {

        //the registry
        commands.add(new Echo());
        commands.add(new Toggle());
    }

    public static List<Command> getCommands() {

        return commands;
    }

    public static Command getByAlias(String command) {

        for (Command command1 : getCommands()) {
            if (Arrays.stream(command1.triggers).anyMatch(s -> s.equalsIgnoreCase(command))) {

                return command1;
            }
        }

        return null;
    }

}
