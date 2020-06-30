package com.ihusker.elements.commands.warps;

import com.ihusker.elements.managers.WarpManager;
import com.ihusker.elements.utilities.command.AbstractCommand;
import com.ihusker.elements.utilities.command.Command;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.StringJoiner;

public class WarpsCommand extends AbstractCommand implements Command {

    private final WarpManager warpManager;

    public WarpsCommand(WarpManager warpManager) {
        super("warps");
        this.warpManager = warpManager;
    }

    @Override
    public void execute(Player player, String[] args) {
        StringJoiner stringJoiner = new StringJoiner(",");
        new ArrayList<>(warpManager.getWarps().keySet()).forEach(stringJoiner::add);
        player.sendMessage("Warps: " + stringJoiner.toString());
    }
}
