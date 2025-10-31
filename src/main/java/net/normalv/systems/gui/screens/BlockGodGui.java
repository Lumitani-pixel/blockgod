package net.normalv.systems.gui.screens;

import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.KeyInput;
import net.minecraft.text.Text;
import net.normalv.BlockFighter;
import net.normalv.util.interfaces.Util;

import java.awt.*;

public class BlockGodGui extends Screen implements Util {
    private static BlockGodGui instance;
    private static boolean isAssigningKey = false;

    static {
        instance = new BlockGodGui();
    }

    protected BlockGodGui() {
        super(Text.literal("Block God GUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        context.drawCenteredTextWithShadow(mc.textRenderer, BlockFighter.MOD_NAME, width/2, 20, Color.WHITE.hashCode());
        super.render(context, mouseX, mouseY, deltaTicks);
    }

    @Override
    public boolean keyPressed(KeyInput input) {
        if(isAssigningKey) {
            BlockFighter.textManager.sendTextClientSide(Text.literal("Assigned new key for gui : ").append(Text.literal(input.toString())));
            return true;
        } else if(BlockFighter.guiBinding.matchesKey(input)) {
            close();
            return true;
        }
        return super.keyPressed(input);
    }

    @Override
    public boolean mouseClicked(Click click, boolean doubled) {
        return super.mouseClicked(click, doubled);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    public static BlockGodGui getInstance() {
        if(instance==null) instance = new BlockGodGui();
        return instance;
    }

    public static boolean isAssigningKey() {
        return isAssigningKey;
    }

     public static void setAssigningKey(boolean assigningKey) {
        isAssigningKey = assigningKey;
    }
}
