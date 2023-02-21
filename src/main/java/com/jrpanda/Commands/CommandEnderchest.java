package com.jrpanda.Commands;

import com.jrpanda.Prison.Helper;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandEnderchest implements CommandExecutor {
    // usage: /enderchest <args>
    // permissions: prison.enderchest | prison.enderchest.others
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("enderchest")){
            if(!(sender instanceof Player)){ return Helper.send(sender, "&4Not a player!"); }
            Player player = (Player) sender;
            if(!(player.hasPermission("prison.enderchest"))){ return Helper.send(player, "&4No permissions"); }
            if(args.length == 0) {
                player.openInventory(player.getEnderChest());
            } else if (args.length == 1){
                if(!(player.hasPermission("prison.enderchest.others"))){ return Helper.send(player, "&4No permissions"); }
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null){ return Helper.send(player, "&4Player could not be found!"); }
                player.openInventory(target.getEnderChest());
            } else { return Helper.send(player, "&4Too much args!"); }
        }
        return true;
    }
}
