package com.jrpanda.Listeners;

import com.jrpanda.Prison.Main;
import com.jrpanda.Prison.PlayerDB;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;


public class PlayerConnection implements Listener {

    private Main main;
    public PlayerConnection(Main main){
        this.main = main;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        File file = new File("plugins/Prison/PlayerData", player.getUniqueId() + ".yml");
        PlayerDB db = new PlayerDB(player.getUniqueId());
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                main.getServer().getLogger().log(Level.SEVERE, "Can't create " + player.getName() + " user file.");
            }
        }
        db.onLogin();
        db.save(true);


        if(!player.isOp()){
            event.setJoinMessage(null);
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        Player player = event.getPlayer();
        PlayerDB db = new PlayerDB(player.getUniqueId());
        db.onLogout();
        db.save(false);
    }

}
