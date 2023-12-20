package me.kbejj.core.menu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public abstract class Menu implements InventoryHolder {

    protected Player player;
    protected Inventory inventory;
    protected int page = 0;
    

}
