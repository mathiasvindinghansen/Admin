package org.plugin.admin.admin;

import org.bukkit.configuration.file.YamlConfiguration;

import org.plugin.admin.admin.commands.*;
import org.plugin.admin.admin.modules.*;

import java.io.File;
import java.util.HashMap;

import org.bukkit.plugin.java.JavaPlugin;

public final class Admin extends JavaPlugin {
    public static Admin PLUGIN;

    public static YamlConfiguration LANGUAGE_FILE;
    public static HashMap<String, CommandModule> COMMANDS;

    @Override
    public void onEnable() {
        COMMANDS = new HashMap<>();
        PLUGIN = this;

        registerResources();
        registerCommands();
    }

    private void registerResources() {
        saveResource("config.yml", false);
        saveResource("languages/en-us.yml", true);
        saveResource("languages/da-dk.yml", true);

        final String language = getConfig().getString("language");

        final File file = new File(PLUGIN.getDataFolder(), "languages/" + language + ".yml");
        LANGUAGE_FILE = YamlConfiguration.loadConfiguration(file);

        saveDefaultConfig();
    }

    private void registerCommands() {
        new heal();
        new feed();
        new fly();
        new gamemode();
        new reloadconfig();
        new teleport();
    }
}