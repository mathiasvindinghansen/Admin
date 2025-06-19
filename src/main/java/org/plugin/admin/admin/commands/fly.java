package org.plugin.admin.admin.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

import org.plugin.admin.admin.helpers.MessageHelper;
import org.plugin.admin.admin.modules.CommandModule;

public class fly extends CommandModule {
    public fly() {
        super("fly", 0, 1);
    }

    @Override
    public void run(CommandSender commandSender, String[] args) {
        if (commandSender instanceof final Player player) {
            Player target = player;

            if (args.length == 1) {
                target = Bukkit.getPlayer(args[0]);
            }

            if (target != null) {
                target.setAllowFlight(!target.getAllowFlight());

                MessageHelper.sendDefinedMessage(commandSender, "commands.fly", target.getAllowFlight() ? "enabled" : "disabled", target.getName());
            } else {
                MessageHelper.sendDefinedMessage(commandSender, "errors.invalid_player", args[0]);
            }
        }
    }
}