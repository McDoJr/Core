package me.kbejj.core.utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundUtil {

    public static void pling(Player player) {
        createSound(player, Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
    }

    public static void exp(Player player) {
        createSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
    }

    public static void villagerYes(Player player) {
        createSound(player, Sound.ENTITY_VILLAGER_YES, 1, 1);
    }

    public static void villagerNo(Player player) {
        createSound(player, Sound.ENTITY_VILLAGER_NO, 1, 1);
    }

    private static void createSound(Player player, Sound sound, float volume, float pitch) {
        player.getWorld().playSound(player, sound, volume, pitch);
    }
}
