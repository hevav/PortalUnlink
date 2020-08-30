package dev.hevav.portalunlink;

import org.bukkit.*;
import org.bukkit.block.Block;

import java.util.Arrays;
import java.util.List;

public class PortalChunk {
    public static List<List<List<Integer>>> portal = Arrays.asList(
            Arrays.asList(
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0)
            ),
            Arrays.asList(
                    Arrays.asList(1,1,1,1,1,1,1,1),
                    Arrays.asList(1,1,1,1,1,1,1,1),
                    Arrays.asList(1,1,1,1,1,1,1,1),
                    Arrays.asList(1,1,1,1,1,1,1,1),
                    Arrays.asList(1,1,1,1,1,1,1,1),
                    Arrays.asList(1,1,1,1,1,1,1,1),
                    Arrays.asList(1,1,1,1,1,1,1,1),
                    Arrays.asList(1,1,1,1,1,1,1,1)
                    ),
            Arrays.asList(
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,2,0,0,0),
                    Arrays.asList(0,0,0,0,2,0,0,0),
                    Arrays.asList(0,0,0,0,2,0,0,0),
                    Arrays.asList(0,0,0,0,2,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0)
            ),
            Arrays.asList(
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,2,0,0,0),
                    Arrays.asList(0,0,0,0,3,0,0,0),
                    Arrays.asList(0,0,0,0,3,0,0,0),
                    Arrays.asList(0,0,0,0,2,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0)
            ),
            Arrays.asList(
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,2,0,0,0),
                    Arrays.asList(0,0,0,0,3,0,0,0),
                    Arrays.asList(0,0,0,0,3,0,0,0),
                    Arrays.asList(0,0,0,0,2,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0)
            ),
            Arrays.asList(
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,2,0,0,0),
                    Arrays.asList(0,0,0,0,3,0,0,0),
                    Arrays.asList(0,0,0,0,3,0,0,0),
                    Arrays.asList(0,0,0,0,2,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0)
            ),
            Arrays.asList(
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,2,0,0,0),
                    Arrays.asList(0,0,0,0,2,0,0,0),
                    Arrays.asList(0,0,0,0,2,0,0,0),
                    Arrays.asList(0,0,0,0,2,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0)
            ),
            Arrays.asList(
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0),
                    Arrays.asList(0,0,0,0,0,0,0,0)
            )
    );

    private static Material fromInt(Integer integer, Material bottomMaterial){
        switch (integer){
            default:
                return Material.AIR;
            case 1:
                return bottomMaterial;
            case 2:
                return Material.OBSIDIAN;
            case 3:
                return Material.PORTAL;
        }
    }

    public static Location getTeleportLocation(Location startLocation, Material bottomMaterial){
        World world = startLocation.getWorld();
        int x = (int) startLocation.getX();
        int y = (int) startLocation.getY();
        int z = (int) startLocation.getZ();
        boolean doCopy = true;

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < 20; k++) {
                    Block block = world.getBlockAt(x+j-10, y+i-10, z+k-10);
                    if (block.getType() == Material.PORTAL){
                        doCopy = false;
                        startLocation = new Location(world, x+j-10, y+i-10, z+k-10);
                        break;
                    }
                }
            }
        }

        if(doCopy){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 8; k++) {
                        Material setMaterial = fromInt(portal.get(i).get(j).get(k), bottomMaterial);
                        Block block = world.getBlockAt(x+j, y+i, z+k);
                        if (setMaterial != Material.AIR && (block.getType() == Material.AIR || block.getType() == Material.LONG_GRASS)){
                            Bukkit.getScheduler().scheduleSyncDelayedTask(PortalUnlink.getInstance(), ()->
                                block.setType(setMaterial)
                            );
                        }
                    }
                }
            }
        }

        return startLocation.add(3, 3, 3);
    }
}
