package com.ihusker.elements.data.general;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemData {

    private String displayName;
    private List<String> lore;
    private Material material;
    private Map<Enchantment, Integer> enchantments;
    private int amount;

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setEnchantments(Map<Enchantment, Integer> enchantments) {
        this.enchantments = enchantments;
    }

    public ItemStack build(boolean levelRestriction) {
        ItemStack itemStack = new ItemStack(material == null ? Material.STONE : material);
        itemStack.setAmount(amount == 0 ? 1 : amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        if(itemMeta == null) return itemStack;
        itemMeta.setDisplayName(displayName == null ? "" : displayName);
        itemMeta.setLore(lore == null ? new ArrayList<>() : lore);
        if(enchantments != null) enchantments.forEach((key, value) -> itemMeta.addEnchant(key, value, levelRestriction));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
