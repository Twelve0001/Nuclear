package me.twelve.nuclear.client;

import me.twelve.nuclear.client.event.EventHandler;
import me.x150.renderer.event.Events;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NuclearMain implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("Nuclear");
    public static final String PREFIX = ".";
    public static MinecraftClient client = MinecraftClient.getInstance();

    @Override
    public void onInitialize() {

        Events.registerEventHandlerClass(new EventHandler());
    }

}