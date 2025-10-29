package net.normalv.systems.managers;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.normalv.BlockGod;

public class EventManager extends Manager{

    public void registerEvents() {
        ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {
            BlockGod.toolManager.toolTick();
        });
    }
}
