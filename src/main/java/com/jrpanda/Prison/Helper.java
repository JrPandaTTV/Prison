package com.jrpanda.Prison;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.Inventory;

public class Helper {
    public static boolean send(CommandSender sender, String msg){
        sender.sendMessage(Helper.toColor(msg));
        return true;
    }
    public static String toColor(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static Inventory createInventory(int size, String name){ return Bukkit.createInventory(null, size, toColor(name)); }
    
}
