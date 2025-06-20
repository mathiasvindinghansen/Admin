package org.plugin.admin.admin.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import org.plugin.admin.admin.helpers.MessageHelper;
import org.plugin.admin.admin.modules.CommandModule;

public class heal extends CommandModule {
    public heal() {
        super("heal", 0, 0);
    }

    @Override
    public void run(CommandSender commandSender, String[] args) {
        if (commandSender instanceof final Player player) {
            final AttributeInstance MAX_HEALTH = player.getAttribute(Attribute.MAX_HEALTH);

            if (MAX_HEALTH != null) {
                player.setHealth(MAX_HEALTH.getBaseValue());
                player.setSaturation(20);
                player.setFoodLevel(20);

                MessageHelper.sendDefinedMessage(commandSender, "commands.heal");
            }
        }
    }
}