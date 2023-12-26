package me.kbejj.core.menu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public class Button extends Icon{
    public Button(ItemStack itemStack, Predicate<Player> action) {
        super(itemStack, action);
    }
}
