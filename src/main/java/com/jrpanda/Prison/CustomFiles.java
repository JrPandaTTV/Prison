package com.jrpanda.Prison;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;

public class CustomFiles {

    private File file;
    private FileConfiguration config;

    public CustomFiles(String path){
        file = new File(path);
        setup();
    }

    public FileConfiguration getConfig(){
        return config;
    }

    private void setup(){
        File parent = file.getParentFile();
        if(!parent.exists()){ parent.mkdirs(); }
        if(!file.exists()) {
            try{
                file.createNewFile();
            } catch(IOException e){
                throw new RuntimeException(e);
            }
        }
        load();
    }

    public void load(){
        config = YamlConfiguration.loadConfiguration(file);
    }

    public void save(){
        try{
            config.save(file);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public void saveAsynchronously(){
        new BukkitRunnable(){
            @Override
            public void run() {
                save();
            }
        }.runTaskAsynchronously(Main.getPlugin(Main.class));
    }
}
