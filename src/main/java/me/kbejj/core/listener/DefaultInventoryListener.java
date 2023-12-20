package me.kbejj.core.listener;

import me.kbejj.core.menu.Menu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class DefaultInventoryListener implements Listener {

    public DefaultInventoryListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(! (e.getView().getTopInventory().getHolder() instanceof Menu)) {
            return;
        }
        Inventory inventory = e.getClickedInventory();
        if(inventory == null) {
            return;
        }
        if(e.getCurrentItem() == null) {
            return;
        }
        InventoryHolder holder = inventory.getHolder();
        if(holder instanceof Menu) {
            ((Menu) holder).handleClick(e);
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        InventoryHolder holder = e.getInventory().getHolder();
        if(holder instanceof Menu) {
            ((Menu) holder).handleClose(e);
        }
    }

    @EventHandler
    public void onOpen(InventoryOpenEvent e) {
        InventoryHolder holder = e.getInventory().getHolder();
        if(holder instanceof Menu) {
            ((Menu) holder).handleOpen(e);
        }
    }
}
