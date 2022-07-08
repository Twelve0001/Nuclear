package me.twelve.nuclear.client.feature.module;

import net.minecraft.client.util.math.MatrixStack;

public abstract class Module {

    public final String name, description;
    public final ModuleType type;
    protected boolean enabled = false;

    public Module(String name, String description, ModuleType type) {

        this.name = name;
        this.description = description;
        this.type = type;

    }

    public final boolean isEnabled() { return enabled; }

    public final void setEnabled(boolean enabled) {

        if (this.enabled == enabled) {

            return;
        }
        this.enabled = enabled;
        if (this.enabled) {

            Enable();
        } else {

            Disable();
        }
    }

    public abstract void Enable();

    public abstract void Disable();

    public abstract void Tick();

    public abstract void onWorldRender(MatrixStack stack);

    public abstract void onHudRender();

    public enum ModuleType {

        TEST("Testing");

        final String name;

        ModuleType(String name) {

            this.name = name;
        }

        public String getName() {

            return name;
        }
    }
}