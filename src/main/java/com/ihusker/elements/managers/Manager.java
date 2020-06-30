package com.ihusker.elements.managers;

import org.bukkit.plugin.Plugin;

public interface Manager {

    void serialize(Plugin plugin);
    void deserialize(Plugin plugin);
}
