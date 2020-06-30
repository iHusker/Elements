package com.ihusker.elements.data.location;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;

public class BlockData {

    private final String world;
    private final int x, y, z;

    public BlockData(Block block) {
        this.x = block.getX();
        this.y = block.getY();
        this.z = block.getZ();
        this.world = block.getWorld().getName();
    }

    public Block serialize() {
        World world = Bukkit.getWorld(this.world);
        if(world == null) return null;
        return world.getBlockAt(x, y, z);
    }
}
