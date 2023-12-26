package me.kbejj.core.managers;

import me.kbejj.core.Core;
import me.kbejj.core.utils.FileUtil;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class MessageManager {

    private final Map<String, Map<String, String>> messages;

    public MessageManager(JavaPlugin plugin) {
        this.messages = new HashMap<>();
        loadMessages(Core.getPlugin());
        loadMessages(plugin);
    }

    public MessageManager() {
        this.messages = new HashMap<>();
        loadMessages(Core.getPlugin());
    }

    public void loadMessages(JavaPlugin plugin) {
        FileConfiguration config = FileUtil.getConfig(plugin, "messages.yml");
        for(String parentKey : config.getKeys(false)) {
            Map<String, String> childMessages = new HashMap<>();
            for(String key : config.getConfigurationSection(parentKey).getKeys(false)) {
                childMessages.put(key, config.getString(parentKey + "." + key));
            }
            messages.put(parentKey, childMessages);
        }
    }

    public String get(String path) {
        String[] data = path.split("\\.");
        return messages.get(data[0]).get(data[1]);
    }
}
