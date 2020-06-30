package com.ihusker.elements.utilities.command;

import org.bukkit.command.CommandExecutor;

public interface Command {

    String name();
    CommandExecutor commandExecutor();
}

