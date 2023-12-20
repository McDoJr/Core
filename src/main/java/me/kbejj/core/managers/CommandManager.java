package me.kbejj.core.managers;

import me.kbejj.core.commands.Subcommand;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandManager {

    private final List<Subcommand> subcommands;

    public CommandManager(Subcommand...subcommands) {
        this.subcommands = new ArrayList<>(Arrays.asList(subcommands));
    }

    public List<String> getAccessibleSubcommandsAsString(CommandSender sender) {
        return this.getAccessibleSubcommands(sender).stream()
                .map(subcommand -> subcommand.info().command())
                .collect(Collectors.toList());
    }

    public List<Subcommand> getAccessibleSubcommands(CommandSender sender) {
        return this.subcommands.stream()
                .filter(subcommand -> sender.hasPermission(subcommand.info().permission()))
                .collect(Collectors.toList());
    }

    public Subcommand getSubcommand(String command) {
        return this.subcommands.stream()
                .filter(subcommand -> subcommand.info().command().startsWith(command.toLowerCase()))
                .findFirst().orElse(null);
    }
}
