package net.normalv.systems.managers;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.normalv.BlockGod;
import net.normalv.systems.gui.screens.BlockGodGui;

public class EventManager extends Manager{
    private boolean wasPressed = false;

    public void registerEvents() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            handleInput();
            if(BlockGod.fightBot.isEnabled()) BlockGod.fightBot.onTick();
            BlockGod.toolManager.toolTick();
        });
    }

    //TODO: Find a better way to listen to key input
    private void handleInput() {
        boolean guiPressed = BlockGod.guiBinding.isPressed();
        boolean togglePressed = BlockGod.toggleBinding.isPressed();

        // When key is first pressed
        if (!wasPressed && guiPressed) {
            mc.setScreen(BlockGodGui.getInstance());
            wasPressed = true;
        } else if (!wasPressed && togglePressed) {
            BlockGod.fightBot.toggle();
            wasPressed = true;
        }

        // When all keys are released
        if (!guiPressed && !togglePressed) {
            wasPressed = false;
        }
    }
}
