package herizone.horizonapi.utils;

import herizone.horizonapi.HorizonAPI;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Utility {

    private HorizonAPI plugin = JavaPlugin.getPlugin(HorizonAPI.class);

    public void checkPlayer(CommandSender sender, String ifNot) {
        if (!(sender instanceof Player)) {
            plugin.getMessage().message(sender, ifNot);
        }
    }
}
