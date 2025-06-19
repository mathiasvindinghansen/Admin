package org.plugin.admin.admin.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.plugin.admin.admin.helpers.MessageHelper;
import org.plugin.admin.admin.modules.CommandModule;

public class fly extends CommandModule {
    public fly() {
        super("fly", 0, 0);
    }

    @Override
    public void run(CommandSender commandSender, String[] args) {
        if (commandSender instanceof Player player) {
            player.setAllowFlight(!player.getAllowFlight());

            MessageHelper.sendDefinedMessage(commandSender, "commands.fly", player.getAllowFlight() ? "enabled" : "disabled");
        }
    }
}