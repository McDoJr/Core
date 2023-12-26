package me.kbejj.core.menu;

import me.kbejj.core.managers.ButtonsManager;
import me.kbejj.core.utils.ItemBuilder;
import me.kbejj.core.utils.StringUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public abstract class CustomMenu implements InventoryHolder {

    protected Inventory inventory;
    protected Player player;
    protected Map<Integer, Icon> icons;
    protected ButtonsManager buttonsManager;
    protected ItemBuilder itemBuilder;

    private final String title;
    private final int rows;

    public CustomMenu(JavaPlugin plugin, Player player, String title, int rows, ButtonsManager buttonsManager) {
        this.player = player;
        this.title = StringUtil.translate(title);
        this.rows = rows * 9;
        this.icons = new HashMap<>();
        this.buttonsManager = buttonsManager;
        this.itemBuilder = new ItemBuilder(plugin);
    }

    public abstract void setContents();

    private void closeButton() {
        setIcon(49, new Button(
                buttonsManager.getButton("close"),
                player -> {
                    player.closeInventory();
                    return false;
                }
        ));
    }

    protected void setIcon(int slot, Icon icon) {
        this.icons.put(slot, icon);
    }

    public void open() {
        this.inventory = Bukkit.createInventory(this, rows, title);
        closeButton();
        setContents();
        this.player.openInventory(getInventory());
    }

    public void click(int slot) {
        final Icon icon = this.icons.get(slot);

        if(icon != null && icon.click(player)) {
            open();
        }
    }

    public abstract void click(InventoryClickEvent e);


    @Override
    public Inventory getInventory() {
        return this.inventory;
    }
}
