package com.jrpanda.Listeners;

import com.jrpanda.Prison.Helper;
import com.jrpanda.Prison.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CommandHelp implements Listener {
    // usage: /help
    // permissions: prison.help

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPreCommand(PlayerCommandPreprocessEvent e) {
        String[] args = e.getMessage().split(" ");
        if(args[0].equalsIgnoreCase("/help")){
            e.setCancelled(true);
            Inventory inv = Helper.createInventory(54, "&eHelp Menu");
            ItemStack item = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1).setName("&0").build();
            

            Helper.fillOuterBorders(inv,item);
            e.getPlayer().openInventory(inv);
        }
    }
}
