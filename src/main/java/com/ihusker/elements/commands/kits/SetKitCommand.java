package com.ihusker.elements.commands.kits;

import com.ihusker.elements.managers.KitManager;
import com.ihusker.elements.utilities.command.AbstractCommand;
import com.ihusker.elements.utilities.command.Command;
import org.bukkit.entity.Player;

public class SetKitCommand extends AbstractCommand implements Command {

    private final KitManager kitManager;

    public SetKitCommand(KitManager kitManager) {
        super("setkit");
        this.kitManager = kitManager;
    }

    @Override
    public void execute(Player player, String[] args) {

    }
}
