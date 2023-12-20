package me.kbejj.core.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

public abstract class BasicMenu extends Menu{
    public BasicMenu(Player player) {
        super(player);
    }

    @Override
    public void handleOpen(InventoryOpenEvent e) {}

    @Override
    public void handleClose(InventoryCloseEvent e) {}
}
