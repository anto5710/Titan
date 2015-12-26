package gmail.anto5710.mcp.titan.Thread;

import gmail.anto5710.mcp.titan.Wire;
import gmail.anto5710.mcp.titan.Wire.WireResult;
import gmail.anto5710.mcp.titan.util.UtilEntity;
import gmail.anto5710.mcp.titan.util.UtilLocation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftBat;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

public class BatUpdater extends BukkitRunnable{
	private static List<Wire>wires = new ArrayList<>();
	private static List<Wire>removed = new ArrayList<>();
	public BatUpdater() {
		
	}
	@Override
	public void run() {
		Iterator<Wire>itr = wires.iterator();
		while(itr.hasNext()){
			
			Wire wire = itr.next();
			Bat bat = wire.getBat();
			Location loc = bat.getLocation();

			Entity entity = findEntity(loc,bat, wire.getAttached(), wire.getHolder());
			if(entity!=null){
				if(entity instanceof EnderDragon==false){
					double h = bat.getLocation().getY();
					wire.end(entity , h);
				}
			}else{
				Block b =UtilLocation.getBlock(bat.getLocation());
				if(b!=null){
					wire.end(b.getLocation());
				}
			}
			if(wire.getAttached()==null||wire.getHolder()==null||wire.getBat()==null){
				remove(wire);
				itr.remove();
			}
		}
		wires.removeAll(removed);
		removed.clear();
	}
	
	public static Entity findEntity(Location loc, Entity...except){
		Entity e = UtilEntity.getNearestEntity(loc, 6, except);
		if(e!=null){
			if(UtilEntity.distance(e, loc, 2)){
				return e;
			}
		}
		return null;
	}
	
	public static Collection<Bat> getBats(){
		Collection<Bat>bats = new ArrayList<>();
		for(Wire wire: wires){
			bats.add((CraftBat)wire.getBat());
		}
		return bats;
	}
	
	public static void add(Wire wire){
		wires.add(wire);
	}
	
	public static void remove(Wire wire){
		if(wires.contains(wire)){
			removed.add(wire);
		}
	}
	
	public static boolean contains(Bat bat){
		return getBats().contains(bat);
	}
	
	public static boolean isEmpty() {
		return wires.isEmpty();
	}
}
