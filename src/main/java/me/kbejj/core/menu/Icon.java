package me.kbejj.core.menu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public abstract class Icon {

    protected ItemStack itemStack;
    protected Predicate<Player> action;

    public Icon(ItemStack itemStack, Predicate<Player> action) {
        this.itemStack = itemStack;
        this.action = action;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    // Re-renders the menu if it returns true
    public boolean click(Player player) {
        return action != null && action.test(player);
    }
}
