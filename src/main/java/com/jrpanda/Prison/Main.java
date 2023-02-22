package com.jrpanda.Prison;

import com.jrpanda.Commands.*;
import com.jrpanda.Listeners.PickaxeEvent;
import com.jrpanda.Listeners.PlayerConnection;
import com.jrpanda.Listeners.ServerListPing;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


public final class Main extends JavaPlugin {

    private File folder;

    @Override
    public void onEnable() {
        registerCommands();
        registerListeners();
        folder = new File(getDataFolder(), "PlayerData");
        folder.mkdirs();

    }

    @Override
    public void onDisable() {

    }

    public void registerCommands(){
        registerCommand("enderchest", new CommandEnderchest());
        registerCommand("fly", new CommandFly());
        registerCommand("newpickaxe", new CommandNewpickaxe());
        registerCommand("rename", new CommandRename());
        registerCommand("workbench", new CommandWorkbench());
    }

    public void registerListeners(){
        registerListener(new PlayerConnection(this));
        registerListener(new PickaxeEvent());
        registerListener(new ServerListPing());
    }

    private void registerCommand(String name, CommandExecutor cmd){
        this.getCommand(name).setExecutor(cmd);
    }

    private void registerListener(Listener listener){
        Bukkit.getServer().getPluginManager().registerEvents(listener, this);
    }

}
