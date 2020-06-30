package com.ihusker.elements.managers;

import com.google.gson.reflect.TypeToken;
import com.ihusker.elements.data.LocationData;
import com.ihusker.elements.utilities.JsonStorage;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WarpManager {

    private Map<String, LocationData> warps;

    public void serialize(Plugin plugin) {
        warps = JsonStorage.read(plugin, "data/warps", new TypeToken<Map<String, LocationData>>(){}.getType());
        if(warps == null) warps = new HashMap<>();
    }

    public void deserialize(Plugin plugin) {
        JsonStorage.write(plugin, "data/warps", warps);
    }

    public void add(String name, Location location) {
        warps.put(name, new LocationData(location));
    }

    public void remove(String name) {
        warps.remove(name);
    }

    public Location getWarp(String name) {
        return warps.get(name).serialize();
    }

    public Map<String, LocationData> getWarps() {
        return Collections.unmodifiableMap(warps);
    }
}
