package com.ihusker.elements.data.location;

import com.ihusker.elements.data.location.BlockData;
import org.bukkit.Location;
import org.bukkit.block.Block;

public class LocationData {

    private final BlockData blockData;
    private final float yaw, pitch;

    public LocationData(Location location) {
        this.blockData = new BlockData(location.getBlock());
        this.yaw = location.getYaw();
        this.pitch = location.getPitch();
    }

    public Location serialize() {
        Block block = blockData.serialize();
        if(block == null) return null;
        Location location = block.getLocation();
        location.setYaw(yaw);
        location.setPitch(pitch);
        return location;
    }
}
