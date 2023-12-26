package me.kbejj.core.utils;

import me.kbejj.core.Core;
import org.bukkit.Bukkit;

public class TimeUtil {

    private static final Core plugin = Core.getPlugin();

    public static void run(Runnable runnable) {
        runnable.run();
    }

    public static void delay(Runnable runnable) {
        delay(runnable, 10);
    }

    public static void delay(Runnable runnable, long delay) {
        Bukkit.getScheduler().runTaskLater(plugin, runnable, delay);
    }
}
