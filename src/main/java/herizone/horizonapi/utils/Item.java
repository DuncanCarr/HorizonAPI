package herizone.horizonapi.utils;

import herizone.horizonapi.HorizonAPI;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public class Item {

    private HorizonAPI plugin = JavaPlugin.getPlugin(HorizonAPI.class);

    private final String name;
    private final ArrayList<String> lore;
    private final Material material;
    private final int amount;
    private final int shrt;
    private final HashMap<Enchantment, Integer> enchants;
    private ItemStack parsed;

    public Item(Material material, int amount, String name, ArrayList<String> lore, HashMap<Enchantment, Integer> enchants, int shrt) {
        this.material = material;
        this.name = name;
        this.amount = amount;
        this.lore = lore;
        this.enchants = enchants;
        this.shrt = shrt;
    }

    public ItemStack parse() {
        ItemStack item = new ItemStack(material, amount, (short) shrt);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(plugin.colorize(name));
        ArrayList<String> loreParsed = new ArrayList<>();
        for (String l : lore) {
            loreParsed.add(plugin.colorize(l));
        }
        meta.setLore(loreParsed);
        item.addEnchantments(enchants);
        item.setItemMeta(meta);
        this.parsed = item;
        return item;
    }

    public interface Callback {
        void call();
    }

    public void interact(ItemStack item, PlayerInteractEvent event, Callback callback) {
        Player p = event.getPlayer();
        if (p.getInventory().getItemInMainHand() != null) {
            if (p.getInventory().getItemInMainHand() == item) {
                callback.call();
            }
        }
    }

    public ItemStack getParsed() {
        return parsed;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getLore() {
        return lore;
    }

    public Material getMaterial() {
        return material;
    }

    public int getAmount() {
        return amount;
    }

    public int getShrt() {
        return shrt;
    }

    public HashMap<Enchantment, Integer> getEnchants() {
        return enchants;
    }
}
