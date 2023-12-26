package me.kbejj.core.managers;

import me.kbejj.core.Core;
import me.kbejj.core.utils.FileUtil;
import me.kbejj.core.utils.HeadUtil;
import me.kbejj.core.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ButtonsManager {

    private final Map<String, ItemStack> buttons;

    public ButtonsManager() {
        this.buttons = new HashMap<>();
        this.loadButtons(Core.getPlugin());
    }

    public void loadButtons(JavaPlugin plugin) {
        FileConfiguration config = FileUtil.getConfig(plugin, "buttons.yml");
        for(String key : config.getKeys(false)) {
            ConfigurationSection section = config.getConfigurationSection(key);
            Material material = Material.getMaterial(section.getString("material").toUpperCase());
            if(material == null) {
                continue;
            }
            String displayname = section.getString("displayname");
            List<String> lore = section.getStringList("lore");
            boolean glow = section.getBoolean("glow");
            String skin = section.getString("skin");
            ItemStack itemStack = skin == null || skin.isEmpty() ? new ItemStack(material) : HeadUtil.getHeadFromUrl(skin);
            buttons.put(key, new ItemBuilder(itemStack).name(displayname).lore(lore).glow(glow).build());
        }
    }

    public ItemStack getButton(String key) {
        return buttons.get(key);
    }
}
