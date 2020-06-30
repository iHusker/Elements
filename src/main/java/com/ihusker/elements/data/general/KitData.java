package com.ihusker.elements.data.general;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public class KitData {

    private final String name;
    private final List<ItemData> items;

    public KitData(String name, List<ItemData> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public ItemStack[] getContents(boolean levelRestrictions) {
        ItemStack[] itemStacks = new ItemStack[items.size()];
        for(int i = 0; i < itemStacks.length; i++) {
            ItemStack itemStack = items.get(i).build(levelRestrictions);
            if(itemStack != null) itemStacks[i] = itemStack;
        }
        return itemStacks;
    }
}
