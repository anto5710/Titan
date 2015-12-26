package gmail.anto5710.mcp.titan.Thread;

import gmail.anto5710.mcp.titan.Wire;
import gmail.anto5710.mcp.titan.Wire.WireResult;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.scheduler.BukkitRunnable;

public class BatFixationer extends BukkitRunnable{
	private static List<Wire>wires = new ArrayList<>();
	private static List<Wire>removed = new ArrayList<>();
	
	@Override
	public void run() {
		Iterator<Wire>itr = wires.iterator();
		while(itr.hasNext()){
			Wire wire = itr.next();
			Entity e =  wire.getAttached();
			
			if(wire.getResult()==WireResult.ENTITY){
				e.teleport(wire.getFixedEntity().getLocation().add(0, 2, 0));
			}
		}
		
		wires.removeAll(removed);
		removed.clear();
	}

	public static boolean isEmpty() {
		return wires.isEmpty();
	}

	public static void add(Wire wire) {
		wires.add(wire);
	}
}
