package gmail.anto5710.mcp.titan;

import gmail.anto5710.mcp.titan.util.Glow;

import gmail.anto5710.mcp.titan.util.UtilItemStack;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CustomItem{
	public static ItemStack Chain = new ItemStack(Material.TRIPWIRE_HOOK);
	public static ItemStack Blade  = new ItemStack(Material.IRON_SWORD,1, (short)10);
	public CustomItem(){
		setChain();
		setBlade();
	}
	private void setChain() {
		UtilItemStack.enchantment(Chain, new Glow(), 1, true);
		UtilItemStack.setDisplayName(Chain, ChatColor.WHITE+"Anchor Catapult");
	}
	private void setBlade() {
		UtilItemStack.setDisplayName(Blade, ChatColor.WHITE+"Super Hardened Steel Blade");
	}
}
