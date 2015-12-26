package gmail.anto5710.mcp.titan.event;

import gmail.anto5710.mcp.titan.CustomItem;
import gmail.anto5710.mcp.titan.main;
import gmail.anto5710.mcp.titan.main3DMG;
import gmail.anto5710.mcp.titan.util.UtilItemStack;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ChainClickEvent implements Listener{
	HashMap<Player, main3DMG>map = new HashMap<>();
	main main;
	public ChainClickEvent(main main) {
		this.main = main;
	}
	@EventHandler
	public void _ChainClickEvent(PlayerInteractEvent e){
		Player player = e.getPlayer();
		Action action = e.getAction();
		ItemStack item = e.getItem();
		
		boolean isChain =UtilItemStack.isSimilar(item, CustomItem.Chain)||UtilItemStack.isSimilar(item, CustomItem.Blade);
		if(!isChain||player.isSneaking()){
			return;
		}
		if(!map.containsKey(player)){
			map.put(player, new main3DMG(player,main));
		}
		main3DMG main3dmg = map.get(player);
		boolean isLeft =action==Action.LEFT_CLICK_AIR||action==Action.LEFT_CLICK_BLOCK;
		
		main3dmg.use(isLeft);
	}
}
