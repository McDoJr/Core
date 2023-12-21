package me.kbejj.core.menu;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public abstract class PaginatedMenu extends Menu {

    protected int page = 0;
    protected ItemStack next;
    protected ItemStack previous;

    protected int nextButtonSlot = 53;
    protected int previousButtonSlot = 45;

    protected enum ButtonSlotPosition {
        OUTER, INNER, CUSTOM
    }
    public PaginatedMenu(Player player) {
        super(player);
        this.next = creator.material(Material.PAPER).name("&eNext").lore("&7Go to next page").build();
        this.previous = creator.material(Material.PAPER).name("&ePrevious").lore("&7Go to previous page").build();
    }

    protected void useOuterButtonSlots() {
        useDefaultButtonSlots(ButtonSlotPosition.OUTER);
    }

    protected void useInnerButtonSlots() {
        useDefaultButtonSlots(ButtonSlotPosition.INNER);
    }

    private void useDefaultButtonSlots(ButtonSlotPosition buttonSlotsPosition) {
        boolean outerButtonSlots = buttonSlotsPosition == ButtonSlotPosition.OUTER;
        this.nextButtonSlot = size() - (outerButtonSlots ? 1 : 4);
        this.previousButtonSlot = size() - (outerButtonSlots ? 9 : 6);
        this.backButtonSlot = previousButtonSlot;
        this.closeButtonSlot = size() - 5;
    }

    protected void setCloseButton() {
        inventory.setItem(closeButtonSlot, close);
    }

    protected void useDefaultPagination(List<ItemStack> list) {
        useDefaultPagination(list, size() - 9);
    }

    protected void useDefaultPagination(List<ItemStack> list, int pageSize) {
        useDefaultPagination(list, pageSize, null);
    }

    protected void useDefaultPagination(List<ItemStack> list, int[] pattern) {
        useDefaultPagination(list, pattern.length, pattern);
    }

    protected void useDefaultPagination(List<ItemStack> list, int pageSize, int[] pattern) {
        int size = list.size();
        if(size > pageSize) {
            inventory.setItem(previousButtonSlot, page > 0 ? previous : back);
            if(page < size / pageSize) {
                inventory.setItem(nextButtonSlot, next);
            }
        }
        int index = 0;
        for(int i = page * pageSize; i < pageSize + (page * pageSize); i++) {
            if(i >= size) {
                break;
            }
            if(pattern == null) {
                inventory.addItem(list.get(i));
            }else {
                inventory.setItem(pattern[index], list.get(i));
            }
            index++;
        }
    }

    @Override
    public void handleOpen(InventoryOpenEvent e) {}

    @Override
    public void handleClose(InventoryCloseEvent e) {}
}
