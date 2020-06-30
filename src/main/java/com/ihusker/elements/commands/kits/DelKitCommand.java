package com.ihusker.elements.commands.kits;

import com.ihusker.elements.managers.KitManager;
import com.ihusker.elements.utilities.command.AbstractCommand;
import com.ihusker.elements.utilities.command.Command;
import org.bukkit.entity.Player;

public class DelKitCommand extends AbstractCommand implements Command {

    private final KitManager kitManager;

    public DelKitCommand(KitManager kitManager) {
        super("delkit");
        this.kitManager = kitManager;
    }

    @Override
    public void execute(Player player, String[] args) {

    }
}
