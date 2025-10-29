package net.normalv.systems.managers;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.normalv.BlockGod;
import net.normalv.systems.tools.Tool;

public class TextManager extends Manager{

    public Text getToggleMsg(Tool tool, boolean enabled) {
        return Text.literal(BlockGod.MOD_NAME+" ").formatted(Formatting.DARK_GREEN)
                .append(Text.literal(tool.getName()+" ").formatted(Formatting.BLUE))
                .append(Text.literal(": ").formatted(Formatting.WHITE))
                .append(enabled ? Text.literal("On").formatted(Formatting.GREEN) : Text.literal("Off").formatted(Formatting.RED)
                );
    }

    public Text getInfoMsg(Tool tool, String info) {
        return Text.literal(BlockGod.MOD_NAME+" ").formatted(Formatting.DARK_GREEN)
                .append(Text.literal(tool.getName()+" ").formatted(Formatting.BLUE))
                .append(Text.literal(info).formatted(Formatting.WHITE)
                );
    }

    public void sendTextClientSide(Text text) {
        assert mc.player != null;
        mc.player.sendMessage(
                text,
                false
        );
    }

    public void sendTextServerSide(Text text) {
        mc.getNetworkHandler().sendChatMessage(text.getLiteralString());
    }
}
