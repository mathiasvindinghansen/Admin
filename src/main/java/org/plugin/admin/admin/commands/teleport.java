package org.plugin.admin.admin.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

import org.plugin.admin.admin.helpers.MessageHelper;
import org.plugin.admin.admin.modules.CommandModule;

public class teleport extends CommandModule {
    public teleport() {
        super("teleport", 1, 2);
    }

    @Override
    public void run(CommandSender commandSender, String[] args) {
        if (commandSender instanceof final Player player) {
            if (args.length == 1) {
                final Player target = Bukkit.getPlayer(args[0]);

                if (target != null) {
                    player.teleport(target);

                    MessageHelper.sendDefinedMessage(commandSender, "commands.teleport", player.getName(), target.getName());
                } else {
                    MessageHelper.sendDefinedMessage(commandSender, "errors.invalid_player", args[0]);
                }
            } else if (args.length == 2) {
                final Player target1 = Bukkit.getPlayer(args[0]);
                final Player target2 = Bukkit.getPlayer(args[1]);

                if (target1 != null && target2 != null) {
                    target1.teleport(target2);

                    MessageHelper.sendDefinedMessage(commandSender, "commands.teleport", target1.getName(), target2.getName());
                } else {
                    MessageHelper.sendDefinedMessage(commandSender, "errors.invalid_player_wildcard");
                }
            }
        }
    }
}