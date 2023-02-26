package com.jrpanda.Commands;

import com.jrpanda.Prison.CustomFile;
import com.jrpanda.Prison.Helper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetwarp implements CommandExecutor {
    // usage: /setwarp <args>
    // permissions: prison.setwarp

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("setwarp")){
            if(!(sender instanceof Player)){ return Helper.send(sender, "&4Not a player!"); }
            Player player = (Player) sender;
            if(!(player.hasPermission("prison.setwarp"))){ return Helper.send(player, "&4No permissions"); }
            CustomFile file = new CustomFile("plugins/Prison/warps.yml");
            if(args.length == 1){
                String path = "Warps." + args[0];
                if(Helper.loadLocation(file, path) != null){ return Helper.send(player, "&cThere's an existing warp by this name! Do /delwarp first!"); }
                Helper.saveLocation(file, player, path);
                return Helper.send(player, "&6Warp has been set!");
            } else { return Helper.send(player, "&cNot enough args!"); }
        }
        return true;
    }
}
