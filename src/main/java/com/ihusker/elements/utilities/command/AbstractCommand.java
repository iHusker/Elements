package com.ihusker.elements.utilities.command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractCommand implements CommandExecutor, Command {

    private final String name;

    protected AbstractCommand(String name) {
        this.name = name;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull org.bukkit.command.Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if(player.hasPermission("elements." + name)) {
                execute(player, strings);
            } else {
                player.sendMessage("You do not have permissions");
            }
        }
        return true;
    }

    public abstract void execute(Player player, String[] args);

    @Override
    public String name() {
        return name;
    }

    @Override
    public CommandExecutor commandExecutor() {
        return this;
    }
}

