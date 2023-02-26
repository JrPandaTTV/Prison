package com.jrpanda.Prison;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Helper {
    public static boolean send(CommandSender sender, String msg){
        sender.sendMessage(Helper.toColor(msg));
        return true;
    }
    public static String toColor(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static Inventory createInventory(int size, String name){ return Bukkit.createInventory(null, size, toColor(name)); }

    public static void fillBorders(Inventory inv, ItemStack border){
        ItemStack item = border;
        int size = inv.getSize();
        for(int i=0; i<size; i++){inv.setItem(i, item);}
    }

    public static void fillOuterBorders(Inventory inv, ItemStack border){
        ItemStack item = border;
        int size = inv.getSize();
        for(int i=0; i<size; i++){
            if((i<9) || (i>size-10)){inv.setItem(i, item);}
            if((i%9==8) || (i%9==0)){inv.setItem(i, item);}
        }
    }

    public static void saveLocation(CustomFile file, Player player, String path){
        FileConfiguration config = file.getConfig();
        config.set(path + ".X", player.getLocation().getX());
        config.set(path + ".Y", player.getLocation().getY());
        config.set(path + ".Z", player.getLocation().getZ());
        config.set(path + ".World", player.getLocation().getWorld().getName());
        config.set(path + ".Yaw", player.getLocation().getYaw());
        config.set(path + ".Pitch", player.getLocation().getPitch());
        file.save();
    }

    public static void deleteLocation(CustomFile file, String path){
        FileConfiguration config = file.getConfig();
        config.set(path, null);
        file.save();
    }

    public static Location loadLocation(CustomFile file, String path){
        FileConfiguration config = file.getConfig();
        if(!config.contains(path)){
            return null;
        }
        return new Location(Bukkit.getWorld(config.getString(path + ".World")),
                config.getDouble(path + ".X"),
                config.getDouble(path + ".Y"),
                config.getDouble(path + ".Z"),
                (float) config.getDouble(path + ".Yaw"),
                (float) config.getDouble(path + ".Pitch"));
    }

}
