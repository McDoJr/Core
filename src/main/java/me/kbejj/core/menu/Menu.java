package me.kbejj.core.menu;

import me.kbejj.core.utils.ItemBuilder;
import me.kbejj.core.utils.StringUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public abstract class Menu implements InventoryHolder {

    protected Player player;
    protected Inventory inventory;
    protected ItemBuilder creator;
    protected ItemStack close;
    protected ItemStack back;

    public Menu(Player player) {
        this.player = player;
        this.creator = new ItemBuilder();
        this.close = creator.material(Material.PAPER).name("&cClose").lore("&7Click to close inventory!").build();
        this.back = creator.material(Material.PAPER).name("&eBack").lore("&7Click to go back!").build();
    }

    public abstract String title();
    public abstract int size();

    public abstract void setContents();
    public abstract void handleClick(InventoryClickEvent e);
    public abstract void handleOpen(InventoryOpenEvent e);
    public abstract void handleClose(InventoryCloseEvent e);
    public abstract void overrideButtons();
    public void open() {
        this.inventory = Bukkit.createInventory(this, size(), StringUtil.translate(title()));
        overrideButtons();
        setContents();
        player.openInventory(this.inventory);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
