package net.normalv.util.player;

import net.minecraft.item.Item;

public class FindItemResult {
    private int slot, count;
    private Item item;

    public FindItemResult(int slot, int count, Item item) {
        this.slot = slot;
        this.count = count;
        this.item = item;
    }

    public int getSlot() {
        return slot;
    }

    public int getCount() {
        return count;
    }

    public Item getItem() {
        return item;
    }
}
