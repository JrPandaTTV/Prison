package com.jrpanda.Commands;

import com.jrpanda.Prison.Helper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWorkbench implements CommandExecutor {
    // usage: /workbench <args>
    // permissions: prison.workbench
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("workbench")){
            if(!(sender instanceof Player)){ return Helper.send(sender, "&4Not a player!"); }
            if(sender instanceof Player){
                Player player = (Player) sender;
                if(!(player.hasPermission("prison.workbench"))){ return Helper.send(player, "&4No permissions"); }
                player.openWorkbench(null, true);
            }
        }
        return true;
    }
}
