package com.jrpanda.Commands;

import com.jrpanda.Prison.Helper;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDiscord implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("discord")){
            if(args.length == 0){
                if(!(sender instanceof Player)){ return Helper.send(sender, "&4Not a player!"); }
                Player player = (Player) sender;
                TextComponent text = new TextComponent("");
                text.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Displays the server's discord!")));
                player.sendMessage(String.valueOf(new BaseComponent[]{text}));
            }

        }
        return true;
    }
}
