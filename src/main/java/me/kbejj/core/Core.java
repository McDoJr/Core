package me.kbejj.core;

import me.kbejj.core.managers.MessageManager;
import me.kbejj.core.messages.Message;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    private static Core plugin;

    @Override
    public void onEnable() {
        plugin = this;
        MessageManager.loadMessages(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Core getPlugin() {
        return plugin;
    }
}
