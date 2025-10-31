package net.normalv.systems.managers;

import net.normalv.BlockFighter;
import net.normalv.systems.tools.Tool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ToolManager extends Manager{
    private static final List<Tool> tools = new ArrayList<>();

    public void init() {
        if(!tools.isEmpty()) tools.sort(Comparator.comparing(Tool::getName));
    }

    public Tool getToolByName(String name) {
        for(Tool tool : tools) {
            if(!tool.getName().equalsIgnoreCase(name)) continue;
            return tool;
        }
        return null;
    }

    public <T extends Tool> T getToolByClass(Class<T> clazz) {
        for(Tool tool : tools) {
            if(!clazz.isInstance(tool)) continue;
            return (T) tool;
        }
        return null;
    }

    public List<Tool> getToolsByCategory(Tool.Category category) {
        List<Tool> toolsInCategory = new ArrayList<>();
        for(Tool tool : tools) {
            if(tool.getCategory()!=category) continue;
            toolsInCategory.add(tool);
        }
        return toolsInCategory;
    }

    public void toolTick() {
        if(!BlockFighter.isInGame()) return;
        for(Tool tool : tools) tool.onTick();
    }
}
