package gmail.anto5710.mcp.titan.event;

import gmail.anto5710.mcp.titan.CustomItem;
import gmail.anto5710.mcp.titan.main;
import gmail.anto5710.mcp.titan.util.UtilItemStack;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class ChainPlaceEvent implements Listener{
	main main;
	public ChainPlaceEvent(main main) {
		this.main = main;
	}

	@EventHandler
	public void _ChainPlaceEvent(BlockPlaceEvent e){
		ItemStack item = e.getItemInHand();
		if(UtilItemStack.isSimilar(item , CustomItem.Chain)){
			e.setCancelled(true);
		}
	}
}	
