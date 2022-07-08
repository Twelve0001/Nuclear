package me.twelve.nuclear.client.feature.module;

import me.twelve.nuclear.client.feature.module.modules.movement.BHop;
import me.twelve.nuclear.client.feature.module.modules.movement.ElytraFly;
import me.twelve.nuclear.client.feature.module.modules.movement.Freeze;
import me.twelve.nuclear.client.feature.module.modules.render.GodHimself;
import me.twelve.nuclear.client.feature.module.modules.render.TheAlmightyCube;
import me.twelve.nuclear.client.feature.module.modules.world.NoFall;

import net.minecraft.util.Util;
import java.util.ArrayList;
import java.util.List;

public class ModuleRegistry {

    private static final List<Module> modules = Util.make(new ArrayList<>(), ModuleRegistry::initModules);

    private static void initModules(List<Module> modules) {

        //the registry
        modules.add(new Freeze());
        modules.add(new TheAlmightyCube());
        modules.add(new GodHimself());
        modules.add(new BHop());
        modules.add(new ElytraFly());
        modules.add(new NoFall());
    }

    public static List<Module> getModules() {

        return modules;
    }

}
