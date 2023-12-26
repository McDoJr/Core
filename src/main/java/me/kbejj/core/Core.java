package me.kbejj.core;

import me.kbejj.core.managers.MessageManager;
import me.kbejj.core.messages.Message;
import org.bukkit.plugin.java.JavaPlugin;

public final class Core extends JavaPlugin {

    private static Core plugin;
    private MessageManager messageManager;

    @Override
    public void onEnable() {
        plugin = this;
        this.messageManager = new MessageManager();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Core getPlugin() {
        return plugin;
    }

    public MessageManager getMessageManager() {
        return messageManager;
    }
}
