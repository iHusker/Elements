package com.ihusker.elements.managers;

import com.google.gson.reflect.TypeToken;
import com.ihusker.elements.data.general.ItemData;
import com.ihusker.elements.data.general.KitData;
import com.ihusker.elements.utilities.JsonStorage;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.*;

public class KitManager implements Manager{

    private Set<KitData> kits = new HashSet<>();

    @Override
    public void deserialize(Plugin plugin) {
        kits = JsonStorage.read(plugin, "data/kits", new TypeToken<Set<KitData>>(){}.getType());
        if(kits == null) kits = new HashSet<>();
    }

    @Override
    public void serialize(Plugin plugin) {
        JsonStorage.write(plugin, "data/kits", kits);
    }

    public void create(String name, ItemStack[] contents) {
        List<ItemData> items = new ArrayList<>();

        for (ItemStack itemStack : contents) {
            ItemData itemData = new ItemData();

            if (itemStack != null) {
                itemData.setAmount(itemStack.getAmount());
                itemData.setMaterial(itemStack.getType());
                itemData.setEnchantments(itemStack.getEnchantments());

                ItemMeta itemMeta = itemStack.getItemMeta();
                if (itemMeta != null) {
                    itemData.setDisplayName(itemMeta.getDisplayName());
                    itemData.setLore(itemMeta.getLore());
                }
                items.add(itemData);
            }
        }
        kits.add(new KitData(name, items));
    }

    public void delete(String name) {
        kits.remove(getKit(name));
    }

    public KitData getKit(String name) {
        return kits.stream().filter(kitData -> kitData.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public Set<KitData> getKits() {
        return Collections.unmodifiableSet(kits);
    }
}
