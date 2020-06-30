package com.ihusker.elements;

import com.ihusker.elements.commands.kits.DelKitCommand;
import com.ihusker.elements.commands.kits.KitCommand;
import com.ihusker.elements.commands.kits.KitsCommand;
import com.ihusker.elements.commands.kits.SetKitCommand;
import com.ihusker.elements.commands.warps.DelWarpCommand;
import com.ihusker.elements.commands.warps.SetWarpCommand;
import com.ihusker.elements.commands.warps.WarpCommand;
import com.ihusker.elements.commands.warps.WarpsCommand;
import com.ihusker.elements.managers.KitManager;
import com.ihusker.elements.managers.Manager;
import com.ihusker.elements.managers.WarpManager;
import com.ihusker.elements.utilities.command.Command;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class Elements extends JavaPlugin {

    private final WarpManager warpManager = new WarpManager();
    private final KitManager kitManager = new KitManager();

    @Override
    public void onEnable() {
        deserialize(warpManager, kitManager);

        registerCommand(
                //Kits
                new DelKitCommand(kitManager),
                new KitCommand(kitManager),
                new KitsCommand(kitManager),
                new SetKitCommand(kitManager),

                //Warps
                new DelWarpCommand(warpManager),
                new SetWarpCommand(warpManager),
                new WarpCommand(warpManager),
                new WarpsCommand(warpManager)
        );
    }

    @Override
    public void onDisable() {
        serialize(warpManager, kitManager);
    }

    private void deserialize(Manager... managers) {
        Arrays.asList(managers).forEach(manager -> manager.deserialize(this));
    }

    private void serialize(Manager... managers) {
        Arrays.asList(managers).forEach(manager -> manager.serialize(this));
    }

    private void registerCommand(Command... commands) {
        Arrays.asList(commands).forEach(command -> {
            PluginCommand pluginCommand = getCommand(command.name());
            if(pluginCommand != null) pluginCommand.setExecutor(command.commandExecutor());
        });
    }
}
