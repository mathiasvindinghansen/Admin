package org.plugin.admin.admin.helpers;

import org.bukkit.command.CommandSender;

import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.Component;

import org.plugin.admin.admin.Admin;

import java.util.Arrays;

public class MessageHelper {
    public static void sendDefinedMessage(CommandSender commandSender, String path, String... args) {
        String message = Admin.LANGUAGE_FILE.getString(path);

        if (message != null) {
            message = String.format(message, Arrays.toString(args).replaceAll("[\\[\\](){}]",""));

            final Component component = MiniMessage.miniMessage().deserialize(message);
            commandSender.sendMessage(component);
        }
    }

    public static void sendCustomMessage(CommandSender commandSender, String message) {
        final Component component = MiniMessage.miniMessage().deserialize(message);
        commandSender.sendMessage(component);
    }
}