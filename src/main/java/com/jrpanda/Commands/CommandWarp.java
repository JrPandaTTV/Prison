package com.jrpanda.Commands;

import com.jrpanda.Prison.CustomFile;
import com.jrpanda.Prison.Helper;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWarp implements CommandExecutor {
    // usage: /warp <args>
    // permissions: prison.warp
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("warp")){
            if(!(sender instanceof Player)){ return Helper.send(sender, "&4Not a player!"); }
            Player player = (Player) sender;
            if(!(player.hasPermission("prison.warp"))){ return Helper.send(player, "&4No permissions"); }
            CustomFile file = new CustomFile("plugins/Prison/warps.yml");
            if(args.length == 1){
                String path = "Warps." + args[0];
                Location location = Helper.loadLocation(file, path);
                if(location == null){return Helper.send(player, "&cWarp does not exist!");}
                player.teleport(location);
                return Helper.send(player,"&6Teleport...");
            } else { return Helper.send(player, "&cNot enough args!"); }
        }
        return true;
    }
}
