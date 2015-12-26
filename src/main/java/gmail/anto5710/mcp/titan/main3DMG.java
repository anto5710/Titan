package gmail.anto5710.mcp.titan;

import gmail.anto5710.mcp.titan.util.UtilLocation;
import gmail.anto5710.mcp.titan.util.UtilPotionEffect;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class main3DMG {
	private Player player;
	main main;
	Wire Left_wire;
	Wire Right_wire;
	
	private boolean left_used;
	private boolean right_used;
	
	public main3DMG(Player player , main main){
		this.main = main;
		this.player = player;
		left_used =false;
		right_used =false;
	}
	
	public void use(boolean isLeft){

		boolean used = right_used;
		if(isLeft&&left_used){
			used = true;
		}
		if (!used) {
			catapult(isLeft);
		} else {
			pull(isLeft);
		}
	}
	
	private void catapult(boolean isLeft){
		Location pl = player.getEyeLocation();
		Vector v= UtilLocation.getDirection(player, 2);
		if(isLeft){
			
		}else{
			Entity b = player.getWorld().spawn(pl, Pig.class);
			b.setVelocity(v);
			
			Right_wire =new Wire(player ,b.getLocation(), main);
			Right_wire.attach(b);
		}
	}

	private void pull(boolean isLeft){
		if(isLeft){
			
		}else{
			
		}
	}
	
	public Player getPlayer() {
		return player;
	}

	public boolean isLeft_used() {
		return left_used;
	}


	public boolean isRight_used() {
		return right_used;
	}

	
}
