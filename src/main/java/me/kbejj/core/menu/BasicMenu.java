package me.kbejj.core.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

public abstract class BasicMenu extends Menu{
    public BasicMenu(Player player) {
        super(player);
    }

    protected void useDefaultButtonSlots(){
        this.backButtonSlot = size() - 8;
        this.closeButtonSlot = size() - 4;
    }

    @Override
    public void handleOpen(InventoryOpenEvent e) {}

    @Override
    public void handleClose(InventoryCloseEvent e) {}
}
