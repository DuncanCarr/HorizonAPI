package herizone.horizonapi.utils;

import herizone.horizonapi.HorizonAPI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Message {

    private HorizonAPI plugin = JavaPlugin.getPlugin(HorizonAPI.class);

    public void message(CommandSender sender, String message) {
        sender.sendMessage(plugin.colorize(message));
    }

    public void message(Player player, String message) {
        player.sendMessage(plugin.colorize(message));
    }


}
