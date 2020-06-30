package com.ihusker.elements.data;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;

public class ChunkData {

    private final String world;
    private final int x, z;

    public ChunkData(Chunk chunk) {
        this.world = chunk.getWorld().getName();
        this.x = chunk.getX();
        this.z = chunk.getZ();
    }

    public Chunk serialize() {
        World world = Bukkit.getWorld(this.world);
        if(world == null) return null;
        return world.getChunkAt(x, z);
    }
}
