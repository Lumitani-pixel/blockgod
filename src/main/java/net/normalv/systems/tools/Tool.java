package net.normalv.systems.tools;

import net.normalv.BlockGod;
import net.normalv.util.interfaces.Util;

public class Tool implements Util {
    private String name;
    private String description;
    private Category category;
    private boolean isEnabled;

    public Tool(String name, String description, Category category){
        this.name = name;
        this.description = description;
        this.category = category;

        isEnabled = false;
    }

    public void onToggle() {
    }

    public void onEnabled() {
    }

    public void onDisabled() {
    }

    public void onTick() {
    }

    public void toggle() {
        if(!isEnabled) enable();
        else disable();
        onToggle();
    }

    public void enable() {
        BlockGod.textManager.sendTextClientSide(BlockGod.textManager.getToggleMsg(this, true));
        onEnabled();
    }

    public void disable() {
        BlockGod.textManager.sendTextClientSide(BlockGod.textManager.getToggleMsg(this, false));
        onDisabled();
    }

    public void info(String info) {
        BlockGod.textManager.sendTextClientSide(BlockGod.textManager.getInfoMsg(this, info));
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public enum Category{
        COMBAT("Combat"),
        MOVEMENT("Movement"),
        PLAYER("Player"),
        CLIENT("Client");

        private final String name;

        Category(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}
