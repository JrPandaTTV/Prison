package com.jrpanda.Commands;

import com.jrpanda.Prison.Helper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFly implements CommandExecutor {
    // usage: /fly <on|off|args>
    // permissions: prison.fly | prison.fly.others
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("fly")){
            if(!(sender instanceof Player)){ return Helper.send(sender, "&4Not a player!"); }
            Player player = (Player) sender;
            if(args.length == 0){
                if(!(player.hasPermission("prison.fly"))){ return Helper.send(player, "&4No permissions"); }
                if(player.getAllowFlight()==true){
                    player.setAllowFlight(false);
                    return Helper.send(player, "&6Fly mode is &cdisabled!");
                } else{
                    player.setAllowFlight(true);
                    return Helper.send(player, "&6Fly mode is &aenabled!");
                }
            }

        }
        return true;
    }
}
