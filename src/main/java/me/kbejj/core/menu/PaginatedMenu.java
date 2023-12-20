package me.kbejj.core.menu;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

public abstract class PaginatedMenu extends Menu {

    protected int page = 0;
    protected ItemStack next;
    protected ItemStack previous;
    public PaginatedMenu(Player player) {
        super(player);
        this.next = creator.material(Material.PAPER).name("&eNext").lore("&7Go to next page").build();
        this.previous = creator.material(Material.PAPER).name("&ePrevious").lore("&7Go to previous page").build();
    }

    @Override
    public void handleOpen(InventoryOpenEvent e) {}

    @Override
    public void handleClose(InventoryCloseEvent e) {}
}
