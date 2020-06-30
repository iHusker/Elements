package com.ihusker.elements;

import com.ihusker.elements.commands.DelWarpCommand;
import com.ihusker.elements.commands.SetWarpCommand;
import com.ihusker.elements.commands.WarpCommand;
import com.ihusker.elements.commands.WarpsCommand;
import com.ihusker.elements.managers.WarpManager;
import com.ihusker.elements.utilities.command.Command;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class Elements extends JavaPlugin {

    private final WarpManager warpManager = new WarpManager();

    @Override
    public void onEnable() {
        warpManager.deserialize(this);

        registerCommand(
                new DelWarpCommand(warpManager),
                new SetWarpCommand(warpManager),
                new WarpCommand(warpManager),
                new WarpsCommand(warpManager)
        );
    }

    @Override
    public void onDisable() {
        warpManager.serialize(this);
    }

    private void registerCommand(Command... commands) {
        Arrays.asList(commands).forEach(command -> {
            PluginCommand pluginCommand = getCommand(command.name());
            if(pluginCommand != null) pluginCommand.setExecutor(command.commandExecutor());
        });
    }
}
