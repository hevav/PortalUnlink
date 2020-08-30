package dev.hevav.portalunlink;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.player.PlayerPortalEvent;

public class PortalListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public static void onEvent(PlayerPortalEvent event){
        System.out.println("[PortalUnlink] Portal exited");
        Location start = event.getFrom();
        System.out.println(start);
        Location end = event.getTo();
        System.out.println(end);
        if(start.getWorld().getEnvironment() == World.Environment.NORMAL && end.getWorld().getEnvironment() == World.Environment.NETHER){
            Location setLoc = new Location(end.getWorld(), start.getX()/8, start.getY()-7, start.getZ()/8);
            event.setCancelled(true);
            event.getPlayer().teleport(PortalChunk.getTeleportLocation(setLoc, Material.NETHERRACK));
        }
        else if(start.getWorld().getEnvironment() == World.Environment.NETHER && end.getWorld().getEnvironment() == World.Environment.NORMAL){
            Location setLoc = new Location(end.getWorld(), start.getX()*8, start.getY()-7, start.getZ()*8);
            event.setCancelled(true);
            event.getPlayer().teleport(PortalChunk.getTeleportLocation(setLoc, Material.GRASS));
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEvent(BlockPhysicsEvent event) {
        Block block = event.getBlock();
        Material material = block.getType();
        if (material == Material.PORTAL)
            event.setCancelled(true);
    }
}
