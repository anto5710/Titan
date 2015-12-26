package gmail.anto5710.mcp.titan.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class UtilLocation {
	private static List<Material>transparent = Arrays.asList(Material.AIR, Material.WATER,Material.STATIONARY_WATER, Material.LAVA,
			Material.STATIONARY_LAVA, Material.LONG_GRASS );
	
	public static Location getTargetLocation(Player player , int max_distance){
		Set<Material>t = new HashSet<>(transparent);
		return player.getTargetBlock(t, max_distance).getLocation();
	}
	
	public static Vector getDirection(Entity holder , double multiply){
		return holder.getLocation().getDirection().multiply(multiply);
	}

	public static Block getBlock(Location location) {
		Block b = location.getBlock();
		if(!transparent.contains(b.getType())){
			return b;
		}
		for(BlockFace bf : BlockFace.values()){
			Block cb =b.getRelative(bf);
			Material m = cb.getType();
			if (!transparent.contains(m)) {
				return cb;
			}
		}
		return null;
	}
}
