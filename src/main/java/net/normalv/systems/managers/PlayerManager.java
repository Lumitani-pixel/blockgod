package net.normalv.systems.managers;

import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.slot.SlotActionType;
import net.normalv.util.player.FindItemResult;

public class PlayerManager extends Manager{
    private static float minHealth = 5.0f;
    private ItemStack bestSword;

    public FindItemResult findItem(Item item) {
        for(int i = 0; i<46; i++) {
            ItemStack itemStack = mc.player.getInventory().getStack(i);
            if(itemStack.getItem()==item) {
                return new FindItemResult(i, itemStack.getCount(), item);
            }
        }
        return null;
    }

    public boolean moveItem(int itemSlot, int targetSlot) {
        mc.interactionManager.clickSlot(mc.player.currentScreenHandler.syncId, itemSlot, 0, SlotActionType.PICKUP, mc.player);
        mc.interactionManager.clickSlot(mc.player.currentScreenHandler.syncId, targetSlot, 0, SlotActionType.PICKUP, mc.player);
        if(mc.player.getInventory().getStack(targetSlot).isEmpty()) return true;
        mc.interactionManager.clickSlot(mc.player.currentScreenHandler.syncId, itemSlot, 0, SlotActionType.PICKUP, mc.player);
        return true;
    }

    public double getAttackDamage(ItemStack stack) {
        AttributeModifiersComponent modifiers = stack.get(DataComponentTypes.ATTRIBUTE_MODIFIERS);
        if (modifiers==null) return 0.0;

        return modifiers.applyOperations(0.0, EquipmentSlot.MAINHAND);
    }

    public float getMiningSpeed(ItemStack stack, BlockState state) {
        return stack.getMiningSpeedMultiplier(state);
    }

    public static boolean isSuitableFor(ItemStack stack, BlockState state) {
        if (stack == null || stack.isEmpty()) return false;
        return stack.isSuitableFor(state);
    }

    public boolean shouldHeal() {
        return mc.player.getHealth()<=minHealth;
    }

    public void setMinHealth(float newMin) {
        minHealth = newMin;
    }
}
