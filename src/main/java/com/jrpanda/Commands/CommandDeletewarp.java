package com.jrpanda.Commands;

import com.jrpanda.Prison.CustomFile;
import com.jrpanda.Prison.Helper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDeletewarp implements CommandExecutor {
    // usage: /deletewarp <args>
    // permissions: prison.deletewarp
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("deletewarp")){
            if(!(sender instanceof Player)){ return Helper.send(sender, "&4Not a player!"); }
            Player player = (Player) sender;
            if(!(player.hasPermission("prison.deletewarp"))){ return Helper.send(player, "&4No permissions"); }
            CustomFile file = new CustomFile("plugins/Prison/warps.yml");
            if(args.length == 1){
                String path = "Warps." + args[0];
                if(Helper.loadLocation(file, path) == null){ return Helper.send(player, "&cInvalid warp! Please check again!"); }
                Helper.deleteLocation(file, path);
                return Helper.send(player,"&6Warp has been deleted!");
            } else { return Helper.send(player, "&cNot enough args!"); }
        }
        return true;
    }
}
