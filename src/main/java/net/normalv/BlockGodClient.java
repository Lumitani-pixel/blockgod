package net.normalv;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class BlockGodClient implements ClientModInitializer {
    public static final KeyBinding.Category CATEGORY = KeyBinding.Category.create(Identifier.of(BlockGod.MOD_ID, "binds"));
    public static KeyBinding guiBinding;
    public static KeyBinding toggleBinding;

    @Override
    public void onInitializeClient() {
        guiBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key."+BlockGod.MOD_ID+".gui",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                CATEGORY
        ));
        toggleBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key."+BlockGod.MOD_ID+".toggle",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_COMMA,
                CATEGORY
        ));

        BlockGod.eventManager.registerEvents();
        BlockGod.toolManager.init();
    }
}
