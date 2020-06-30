package com.ihusker.elements;

import com.ihusker.elements.managers.WarpManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Elements extends JavaPlugin {

    private final WarpManager warpManager = new WarpManager();

    @Override
    public void onEnable() {
        warpManager.deserialize(this);
    }

    @Override
    public void onDisable() {
        warpManager.serialize(this);
    }
}
