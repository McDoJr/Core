package me.kbejj.core.messages;

import me.kbejj.core.Core;
import me.kbejj.core.managers.MessageManager;
import me.kbejj.core.utils.SoundUtil;
import me.kbejj.core.utils.StringUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Message {

    private final Player player;
    private static final MessageManager messageManager = Core.getPlugin().getMessageManager();

    public Message(Player player) {
        this.player = player;
    }

    public static void message(CommandSender sender, String path) {
        StringUtil.message(sender, messageManager.get(path));
    }

    public Message send(String path) {
        StringUtil.message(player, messageManager.get(path));
        return this;
    }

    public void pling() {
        SoundUtil.pling(player);
    }

    public void no() {
        SoundUtil.villagerNo(player);
    }

    public void yes() {
        SoundUtil.villagerYes(player);
    }

    public void exp() {
        SoundUtil.exp(player);
    }
}
