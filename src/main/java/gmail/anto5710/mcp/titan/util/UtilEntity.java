package gmail.anto5710.mcp.titan.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import net.minecraft.server.v1_8_R2.AxisAlignedBB;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftEntity;
import org.bukkit.entity.ComplexEntityPart;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;

public class UtilEntity {
	public static Collection<Entity> getEntities(Location loc, double r) {
		List<Entity>entities = new ArrayList<>();
		
		for(Entity entity: loc.getWorld().getEntities()){
			if(entity.getLocation().distance(loc)<=r){
				entities.add(entity);
			}
		}
		return entities;
	}
	public static Entity getNearestEntity(Location loc, double r, Entity...except){
		double distance = r;
		Entity entity = null;
		Collection<Entity>entities = getEntities(loc, r);	
		if(except!=null){
			entities.removeAll(Arrays.asList(except));
		}
		for (Entity e :entities) {
			double d = e.getLocation().distance(loc);
			if (d < distance) {
				distance = d;
				entity = e;
			}
		}
		return entity;
	}

	public static boolean distance(Entity e, Location loc, double r) {
		if (!(e instanceof EnderDragon)) {
			return distanceEntity(e, loc, r);
		} else {
			return distanceDragons(e, loc, r);
		}
	}

	private static boolean distanceDragons(Entity e, Location loc, double r) {
		EnderDragon dr = (EnderDragon) e;
		Set<ComplexEntityPart> parts = dr.getParts();
		for(ComplexEntityPart p : parts){
			if(distanceEntity(p, loc, 2)){
				return true;
			}
		}
		return false;
	}

	private static boolean distanceEntity(Entity e, Location loc,double r) {
		Location eloc = e.getLocation();
		net.minecraft.server.v1_8_R2.Entity E = ((CraftEntity)e).getHandle();
		AxisAlignedBB bb = E.getBoundingBox();
		double h = bb.e - bb.b;
		
		double x = eloc.getX();
		double y = eloc.getY();
		double z = eloc.getZ();
		
		double lx = loc.getX();
		double ly = loc.getY();
		double lz = loc.getZ();
		
		for(;y<h;y+=0.2){
			boolean inRadius = lx-r < x && x < lx+r && ly-r < y && y < ly+r && lz-r < z && z < lz+r; 
			if(inRadius){
				System.out.println("ddd");

				return true;
			}
		}
		return false;
	}
}
