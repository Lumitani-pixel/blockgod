package net.normalv;

import net.fabricmc.api.ModInitializer;

import net.normalv.systems.managers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockGod implements ModInitializer {
	public static final String MOD_ID = "blockgod";
    public static final String MOD_NAME = "["+ BlockGod.MOD_ID.toUpperCase()+"]";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

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
}