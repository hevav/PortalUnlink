package dev.hevav.portalunlink;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PortalUnlink extends JavaPlugin {
    private static PortalUnlink instance;

    public static PortalUnlink getInstance(){
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PortalListener(), this);

        System.out.println("[PortalUnlink] initialized");
    }
}
