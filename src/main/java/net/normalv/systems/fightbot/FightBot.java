package net.normalv.systems.fightbot;

import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.normalv.BlockGod;
import net.normalv.util.interfaces.Util;

import java.util.ArrayList;
import java.util.List;

public class FightBot implements Util {
    public static final List<Item> swordItems = new ArrayList<>();
    private boolean isEnabled = false;

    public void onTick() {
        if(!BlockGod.isInGame()) return;
    }

    private void enable(){
        BlockGod.textManager.sendTextClientSide(Text.literal("FightBot enabled"));
        isEnabled = true;
    }

    private void disable() {
        BlockGod.textManager.sendTextClientSide(Text.literal("FightBot disabled"));
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
