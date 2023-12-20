package me.kbejj.core.utils;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ItemBuilder {

    private final ItemStack itemStack;
    private final ItemMeta meta;

    public ItemBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.meta = itemStack.getItemMeta();
    }

    public ItemBuilder(Material material) {
        this.itemStack = new ItemStack(material);
        this.meta = this.itemStack.getItemMeta();
    }

    public ItemBuilder amount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder name(String name) {
        meta.setDisplayName(StringUtil.translate(name));
        return this;
    }

    public ItemBuilder lore(String...lore) {
        return lore(Arrays.asList(lore));
    }

    public ItemBuilder lore(List<String> lore) {
        meta.setLore(lore.stream().map(StringUtil::translate).collect(Collectors.toList()));
        return this;
    }

    public ItemBuilder enchant(List<String> list) {
        for(String string : list) {
            String[] data = string.split(";");
            Enchantment enchantment = EnchantmentWrapper.getByKey(NamespacedKey.minecraft(data[0].toUpperCase()));
            this.meta.addEnchant(enchantment, Integer.parseInt(data[1]), true);
        }
        return this;
    }

    public ItemBuilder enchant(String string) {
        String[] data = string.split(";");
        Enchantment enchantment = EnchantmentWrapper.getByKey(NamespacedKey.minecraft(data[0]));
        return enchant(enchantment, Integer.parseInt(data[1]));
    }

    public ItemBuilder enchant(Enchantment enchantment, int level) {
        this.meta.addEnchant(enchantment, level, true);
        return this;
    }

    public ItemBuilder glow(boolean glow) {
        return glow ? glow() : this;
    }

    public ItemBuilder glow() {
        return enchant(Enchantment.DURABILITY, 1);
    }

    public ItemStack build() {
        this.itemStack.setItemMeta(meta);
        return this.itemStack;
    }
}
