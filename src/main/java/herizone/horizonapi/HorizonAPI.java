package herizone.horizonapi;

import herizone.horizonapi.utils.Message;
import herizone.horizonapi.utils.Utility;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class HorizonAPI extends JavaPlugin {

    private Message message;
    private Utility utility;

    @Override
    public void onEnable() {
        message = new Message();
        utility = new Utility();
    }

    public String colorize(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }

    public Message getMessage() {
        return message;
    }

    public Utility getUtility() {
        return utility;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
