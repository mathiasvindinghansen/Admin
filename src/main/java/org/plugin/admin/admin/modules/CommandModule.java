package org.plugin.admin.admin.modules;

import org.bukkit.command.CommandSender;

import org.plugin.admin.admin.commands.CommandHandler;
import org.plugin.admin.admin.Admin;

import java.util.Objects;

public abstract class CommandModule {
    public String label;
    public int minArgs;
    public int maxArgs;

    public CommandModule(String label, int minArgs, int maxArgs) {
        this.label = label;

        this.minArgs = minArgs;
        this.maxArgs = maxArgs;

        Objects.requireNonNull(Admin.PLUGIN.getCommand(label)).setExecutor(new CommandHandler());

        Admin.COMMANDS.put(label, this);
    }

    public abstract void run(CommandSender commandSender, String[] args);
}