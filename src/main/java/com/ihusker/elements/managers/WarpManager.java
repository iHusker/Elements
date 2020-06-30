package com.ihusker.elements.managers;

import com.google.gson.reflect.TypeToken;
import com.ihusker.elements.data.location.LocationData;
import com.ihusker.elements.utilities.JsonStorage;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WarpManager implements Manager{

    private Map<String, LocationData> warps;

    @Override
    public void deserialize(Plugin plugin) {
        warps = JsonStorage.read(plugin, "data/warps", new TypeToken<Map<String, LocationData>>(){}.getType());
        if(warps == null) warps = new HashMap<>();
    }


    @Override
    public void serialize(Plugin plugin) {
        JsonStorage.write(plugin, "data/warps", warps);
    }

    public void set(String name, Location location) {
        warps.put(name.toLowerCase(), new LocationData(location));
    }

    public void remove(String name) {
        warps.remove(name);
    }

    public Location getWarp(String name) {
        LocationData locationData = warps.get(name.toLowerCase());
        if(locationData == null) return null;
        return locationData.serialize();
    }

    public Map<String, LocationData> getWarps() {
        return Collections.unmodifiableMap(warps);
    }
}
