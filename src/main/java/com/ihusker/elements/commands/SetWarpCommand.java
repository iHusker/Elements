package com.ihusker.elements.commands;

import com.ihusker.elements.managers.WarpManager;
import com.ihusker.elements.utilities.command.AbstractCommand;
import com.ihusker.elements.utilities.command.Command;
import org.bukkit.entity.Player;

public class SetWarpCommand extends AbstractCommand implements Command {

    private final WarpManager warpManager;

    public SetWarpCommand(WarpManager warpManager) {
        super("setwarp");
        this.warpManager = warpManager;
    }

    @Override
    public void execute(Player player, String[] args) {
        warpManager.set(args[0], player.getLocation());
        player.sendMessage("You have set a new warp: " + args[0]);
    }
}
