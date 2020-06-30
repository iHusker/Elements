package com.ihusker.elements.commands;

import com.ihusker.elements.managers.WarpManager;
import com.ihusker.elements.utilities.command.AbstractCommand;
import com.ihusker.elements.utilities.command.Command;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class WarpCommand extends AbstractCommand implements Command {

    private final WarpManager warpManager;

    protected WarpCommand(WarpManager warpManager) {
        super("warp");
        this.warpManager = warpManager;
    }

    @Override
    public void execute(Player player, String[] args) {
        Location location = warpManager.getWarp(args[0]);
        if(location == null) {
            player.sendMessage("The warp " + args[0] + " does not seem to exist.");
        } else {
            player.teleport(location);
            player.sendMessage("You have been teleported to " + args[0]);
        }
    }
}
