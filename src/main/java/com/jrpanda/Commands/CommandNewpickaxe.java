package com.jrpanda.Commands;

import com.jrpanda.Prison.Helper;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandNewpickaxe implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("newpickaxe")){
            if(!(sender instanceof Player)){ return Helper.send(sender, "&4Not a player!"); }
            if(sender instanceof Player){
                Player player = (Player) sender;
                giveItem(player);
                return Helper.send(player, "&eEnjoy your new pickaxe!");
            }
        }
        return true;
    }

    private void giveItem(Player player){
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b" + player.getName() + "'s Pickaxe"));
        item.setItemMeta(meta);

        player.getInventory().addItem(item);
    }
}
