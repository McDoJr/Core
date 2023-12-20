package me.kbejj.core.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class StringUtil {

    public static String translate(String paramString) {
        return ChatColor.translateAlternateColorCodes('&', paramString);
    }

    public static void message(CommandSender sender, String...messages) {
        Arrays.asList(messages).forEach(message -> {
            sender.sendMessage(translate(message));
        });
    }

    public static void logger(String paramString) {
        Bukkit.getConsoleSender().sendMessage(translate(paramString));
    }

    public static String formatItemStack(ItemStack itemStack) {
        return formatItemStack(itemStack.getType());
    }
    public static String formatItemStack(Material material) {
        return formatItemStack(material.name());
    }

    public static String formatItemStack(String string) {
        String[] datas = string.split("_");
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < datas.length; i++) {
            String data = datas[i].toUpperCase().charAt(0) + datas[i].substring(1).toLowerCase();
            builder.append(i == 0 ? data : " " + data);
        }
        return builder.toString();
    }

}
