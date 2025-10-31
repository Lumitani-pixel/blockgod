package net.normalv.systems.fightbot;

import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.normalv.BlockFighter;
import net.normalv.util.interfaces.Util;

import java.util.ArrayList;
import java.util.List;

public class FightBot implements Util {
    public static final List<Item> swordItems = new ArrayList<>();
    private boolean isEnabled = false;

    public void onTick() {
        if(!BlockFighter.isInGame()) return;
    }

    private void enable(){
        BlockFighter.textManager.sendTextClientSide(Text.literal("FightBot enabled"));
        isEnabled = true;
    }

    private void disable() {
        BlockFighter.textManager.sendTextClientSide(Text.literal("FightBot disabled"));
        isEnabled = false;
    }

    public void toggle() {
        if(!isEnabled) enable();
        else disable();
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}
