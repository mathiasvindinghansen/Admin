package org.plugin.admin.admin.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.GameMode;
import org.bukkit.Bukkit;

import org.plugin.admin.admin.helpers.MessageHelper;
import org.plugin.admin.admin.modules.CommandModule;

public class gamemode extends CommandModule {
    public gamemode() {
        super("gamemode", 1, 2);
    }

    @Override
    public void run(CommandSender commandSender, String[] args) {
        if (commandSender instanceof final Player player) {
            Player target = player;

            if (args.length == 2) {
                target = Bukkit.getPlayer(args[1]);
            }

            setGameMode(commandSender, target, args[0]);
        }
    }

    private void setGameMode(CommandSender commandSender, Player target, String gameMode) {
        switch (gameMode) {
            case "0", "s", "survival" -> setGameMode(commandSender, target, GameMode.SURVIVAL);
            case "1", "c", "creative" -> setGameMode(commandSender, target, GameMode.CREATIVE);
            case "2", "a", "adventure" -> setGameMode(commandSender, target, GameMode.ADVENTURE);
            case "3", "spec", "spectator" -> setGameMode(commandSender, target, GameMode.SPECTATOR);
            default -> MessageHelper.sendDefinedMessage(commandSender, "errors.invalid_parameters", this.label);
        }
    }

    private void setGameMode(CommandSender commandSender, Player target, GameMode gameMode) {
        target.setGameMode(gameMode);

        MessageHelper.sendDefinedMessage(commandSender, "commands.gamemode", target.getGameMode().toString().toLowerCase(), target.getName());
    }
}