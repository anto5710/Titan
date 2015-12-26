package gmail.anto5710.mcp.titan.util;

import java.util.Arrays;

import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;

public class UtilPotionEffect {
	public static void addEffect(LivingEntity entity ,PotionEffect...effects ){
		entity.addPotionEffects(Arrays.asList(effects));
	}
	public static void removeEffects(LivingEntity entity , PotionEffect...effects){
		for(PotionEffect ef: effects){
				removeEffect(entity , ef);
		}
	}
	private static void removeEffect(LivingEntity entity, PotionEffect pef) {
		if(containEffect(entity , pef)){
			entity.removePotionEffect(pef.getType());
		}
	}
	private static boolean containEffect(LivingEntity entity, PotionEffect pef) {
		for(PotionEffect e : entity.getActivePotionEffects()){
			if(e.getAmplifier()==pef.getAmplifier()&&e.getType().getName().equals(pef.getType().getName())){
				return true;
			}
		}
		return false;
	}
	
	
	
}
