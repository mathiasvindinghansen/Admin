package org.plugin.admin.admin.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;

import org.plugin.admin.admin.helpers.MessageHelper;
import org.plugin.admin.admin.modules.CommandModule;
import org.plugin.admin.admin.Admin;

import org.jetbrains.annotations.NotNull;

public class CommandHandler implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender commandSender, Command command, @NotNull String label, String @NotNull [] args) {
        final String commandName = command.getName();

        if (Admin.COMMANDS.containsKey(commandName)) {
            CommandModule commandModule = Admin.COMMANDS.get(commandName);

            if (args.length >= commandModule.minArgs && (args.length <= commandModule.maxArgs || commandModule.maxArgs == -1)) {
                commandModule.run(commandSender, args);
            } else {
                MessageHelper.sendDefinedMessage(commandSender, "errors.invalid_parameters", label);
            }
        }

        return false;
    }
}