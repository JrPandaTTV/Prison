package com.jrpanda.Commands;

import com.jrpanda.Prison.Helper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpeed implements CommandExecutor {
    // usage: /speed <args> [walking|flying|player]
    // permissions: prison.speed
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("speed")){
            if(!(sender instanceof Player)){ return Helper.send(sender, "&4Not a player!"); }
            Player player = (Player) sender;
            if(!(player.hasPermission("prison.speed"))){ return Helper.send(player, "&4No permissions"); }
            if(args.length == 1){

            }

        }
        return true;
    }
}
