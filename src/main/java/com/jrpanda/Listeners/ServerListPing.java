package com.jrpanda.Listeners;

import com.jrpanda.Prison.Helper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListPing implements Listener {
    @EventHandler
    public void SLP(ServerListPingEvent event){
        event.setMotd(Helper.toColor("&3Please Name Server &8>> &7Prison"));
    }
}
