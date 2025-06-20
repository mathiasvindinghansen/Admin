package org.plugin.admin.admin.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.plugin.admin.admin.helpers.MessageHelper;
import org.plugin.admin.admin.modules.CommandModule;

public class feed extends CommandModule {
    public feed() {
        super("feed", 0, 0);
    }

    @Override
    public void run(CommandSender commandSender, String[] args) {
        if (commandSender instanceof final Player player) {
            player.setSaturation(20);
            player.setFoodLevel(20);

            MessageHelper.sendDefinedMessage(commandSender, "commands.feed");
        }
    }
}