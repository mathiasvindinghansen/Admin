package org.plugin.admin.admin.commands;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.plugin.admin.admin.helpers.MessageHelper;
import org.plugin.admin.admin.modules.CommandModule;
import org.plugin.admin.admin.Admin;

import java.io.File;

public class reloadconfig extends CommandModule {
    public reloadconfig() {
        super("reloadconfig", 0, 0);
    }

    @Override
    public void run(CommandSender commandSender, String[] args) {
        if (commandSender instanceof Player) {
            Admin.PLUGIN.reloadConfig();

            final String language = Admin.PLUGIN.getConfig().getString("language");

            final File file = new File(Admin.PLUGIN.getDataFolder(), "languages/" + language + ".yml");
            Admin.LANGUAGE_FILE = YamlConfiguration.loadConfiguration(file);

            MessageHelper.sendDefinedMessage(commandSender, "commands.reloadconfig");
        }
    }
}