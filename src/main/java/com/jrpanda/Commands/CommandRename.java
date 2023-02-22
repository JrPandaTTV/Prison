package com.jrpanda.Commands;

import com.jrpanda.Prison.Helper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandRename implements CommandExecutor {
    // usage: /rename <args>
    // permissions: prison.rename
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("rename")){
            if(!(sender instanceof Player)){ return Helper.send(sender, "&4Not a player!"); }
            Player player = (Player) sender;
            if(!(player.hasPermission("prison.rename"))){ return Helper.send(player, "&4No permissions"); }
            if(args.length == 0){
                return Helper.send(player, "&4Not enough arguments");
            } else if(args.length == 1){
                ItemStack item = player.getInventory().getItemInMainHand();
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(Helper.toColor(args[0].replace("_"," ")));
                item.setItemMeta(meta);
                return Helper.send(player, "&6Item has been renamed!");
            } else {
                return Helper.send(player, "&4Use underscore instead of spaces!");
            }

        }
        return true;
    }
}
