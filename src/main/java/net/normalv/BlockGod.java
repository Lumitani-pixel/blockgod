package net.normalv;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import net.normalv.systems.managers.*;
import net.normalv.util.interfaces.Util;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockGod implements ModInitializer, ClientModInitializer, Util {
	public static final String MOD_ID = "blockgod";
    public static final String MOD_NAME = "["+ BlockGod.MOD_ID.toUpperCase()+"]";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final KeyBinding.Category CATEGORY = KeyBinding.Category.create(Identifier.of(BlockGod.MOD_ID, "binds"));

    public static KeyBinding guiBinding;
    public static KeyBinding toggleBinding;

    public static TextManager textManager;
    public static PlayerManager playerManager;
    public static TargetManager targetManager;
    public static WorldManager worldManager;
    public static ToolManager toolManager;
    public static EventManager eventManager;

	@Override
	public void onInitialize() {
		LOGGER.info("Welcome to "+MOD_ID+" a not so friendly bot!");

        textManager = new TextManager();
        playerManager = new PlayerManager();
        targetManager = new TargetManager();
        worldManager = new WorldManager();
        toolManager = new ToolManager();
        eventManager = new EventManager();
	}

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

    public static boolean isInGame() {
        return mc.world!=null && mc.player != null;
    }
}