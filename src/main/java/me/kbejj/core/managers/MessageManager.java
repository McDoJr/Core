package me.kbejj.core.managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MessageManager {

    private static final Map<String, Map<String, String>> messages = new HashMap<>();
    private static final String filename = "messages.yml";

    public static void loadMessages(JavaPlugin plugin) {
        FileConfiguration config = getConfig(plugin);
        for(String parentKey : config.getKeys(false)) {
            Map<String, String> childMessages = new HashMap<>();
            for(String key : config.getConfigurationSection(parentKey).getKeys(false)) {
                childMessages.put(key, config.getString(parentKey + "." + key));
            }
            messages.put(parentKey, childMessages);
        }
    }

    private static FileConfiguration getConfig(JavaPlugin plugin) {
        File file = new File(plugin.getDataFolder(), filename);
        if(!file.exists()) {
            plugin.saveResource(filename, true);
        }
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        InputStream stream = plugin.getResource(filename);
        if(stream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(stream));
            config.setDefaults(defaultConfig);
        }
        return config;
    }

    public static String get(String path) {
        String[] data = path.split("\\.");
        return messages.get(data[0]).get(data[1]);
    }

    public static void send(Player player) {

    }
}
