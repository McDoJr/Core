package me.kbejj.core.menu;

import me.kbejj.core.Core;
import me.kbejj.core.managers.ButtonsManager;
import me.kbejj.core.utils.ItemBuilder;
import me.kbejj.core.utils.StringUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class Menu implements InventoryHolder {

    protected ButtonsManager buttonsManager;
    protected Player player;
    protected Inventory inventory;
    protected ItemBuilder itemBuilder;
    protected ItemStack close;
    protected ItemStack back;

    protected int closeButtonSlot = 49;
    protected int backButtonSlot = 45;

    public Menu(Player player) {
        this.init(Core.getPlugin(), player);
    }
    public Menu(JavaPlugin plugin, Player player) {
        this.init(plugin, player);
    }

    private void init(JavaPlugin plugin, Player player){
        this.player = player;
        this.itemBuilder = new ItemBuilder(plugin);
        this.buttonsManager = new ButtonsManager();
        this.close = buttonsManager.getButton("close");
        this.back = buttonsManager.getButton("back");
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
