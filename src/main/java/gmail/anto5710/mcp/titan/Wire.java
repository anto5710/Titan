package gmail.anto5710.mcp.titan;

import gmail.anto5710.mcp.titan.Thread.BatFixationer;
import gmail.anto5710.mcp.titan.Thread.BatUpdater;
import gmail.anto5710.mcp.titan.util.UtilPotionEffect;

import org.bukkit.Location;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
 
public class Wire {
	private main main;
	private Entity holder;
	private Entity attach;
	private Entity fixed;
	private Bat bat;
	private Location end;
	private WireResult result;
	
	public enum WireResult{
		ENTITY , BLOCK , AIR;
	}
	
    public Wire(Entity holder ,Location loc, main main) {
    	this.end = loc;
    	this.main =main;
    	this.holder = holder;
    	this.fixed = null;
    	this.result = WireResult.AIR;
    	makeBat();
    	if(BatUpdater.isEmpty()){
    		new BatUpdater().runTaskTimer(main, 0, 1);
    	}
    	BatUpdater.add(this);
    }

	private void makeBat() {
		this.bat = end.getWorld().spawn(end, Bat.class);
		UtilPotionEffect.addEffect(bat, new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1, false, false));
		bat.setLeashHolder(holder);
	}
	
	public void despawn(){
		bat.remove();
	}
	
	public void attach(Entity e){
		attach = e;
		attach.setPassenger(bat);
	}
	
	public void end(Entity entity, double height) {
		setResult(WireResult.ENTITY);
		fixed = entity;
		if (BatFixationer.isEmpty()) {
			new BatFixationer().runTaskTimer(main, 0, 1);
		}
		BatFixationer.add(this);
	}
	
	public void end(Location loc) {
		setResult(WireResult.BLOCK);
		if (BatFixationer.isEmpty()) {
			new BatFixationer().runTaskTimer(main, 0, 1);
		}
		BatFixationer.add(this);
	}
	
	public Bat getBat(){
		return bat;
	}
	
	public Entity getAttached(){
		return attach;
	}
	
	public Entity getHolder(){
		return holder;
	}
	
	public WireResult getResult(){
		return result;
	}
	
	public Location getLocation() {
		return end;
	}
	
	public Entity getFixedEntity(){
		return fixed;
	}
	
	public void setHolder(Entity holder){
		this.holder = holder;
	}
	
	public void setResult(WireResult result){
		this.result = result;
	}


}
 
