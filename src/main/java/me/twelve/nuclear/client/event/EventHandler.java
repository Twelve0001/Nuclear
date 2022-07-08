package me.twelve.nuclear.client.event;

import me.twelve.nuclear.client.feature.module.ModuleRegistry;
import me.twelve.nuclear.client.feature.module.Module;
import me.x150.renderer.event.EventListener;
import me.x150.renderer.event.EventType;
import me.x150.renderer.event.Shift;
import me.x150.renderer.event.events.RenderEvent;
import me.x150.renderer.renderer.MSAAFramebuffer;

public class EventHandler {
    @EventListener(type = EventType.WORLD_RENDER, shift = Shift.POST)
    void handleWorldRender(RenderEvent event) {

        MSAAFramebuffer.use(MSAAFramebuffer.MAX_SAMPLES, () -> {

            for (Module module : ModuleRegistry.getModules()) {
                if (module.isEnabled()) {
                    module.onWorldRender(event.getStack());
                }
            }
        });

    }

    @EventListener(type = EventType.HUD_RENDER, shift = Shift.POST)
    void handleHudRender(RenderEvent event) {

        MSAAFramebuffer.use(MSAAFramebuffer.MAX_SAMPLES, () -> {

            for (Module module : ModuleRegistry.getModules()) {
                if (module.isEnabled()) {
                    module.onHudRender();
                }
            }
        });

    }

}
