package com.jrpanda.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PickaxeEvent implements Listener {
    @EventHandler
    public void pickaxeEnchants(PlayerInteractEvent event){
        if(event.getAction() == Action.RIGHT_CLICK_AIR){
            Player player = event.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();
            if(item.getType() == Material.DIAMOND_PICKAXE){
                player.sendMessage("Test!");
            }
        }
    }
}
