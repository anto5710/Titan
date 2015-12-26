package gmail.anto5710.mcp.titan.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class UtilItemStack {
	
	public static void setDisplayName(ItemStack item , String name){
		ItemMeta Meta = item.getItemMeta();
		Meta.setDisplayName(name);
		item.setItemMeta(Meta);
	}
	
	public static void enchantment(ItemStack item, Enchantment enchantment, int level, boolean IgnoreLevelLimit) {
		ItemMeta Meta = item.getItemMeta();
		
		if(item.getType()==Material.ENCHANTED_BOOK){
			Meta = (EnchantmentStorageMeta) Meta;
		}
		
		Meta.addEnchant(enchantment, level, IgnoreLevelLimit);
		item.setItemMeta(Meta);
	}

	public static boolean isSimilar(ItemStack item, ItemStack item2) {
		if(item==null||item2==null){
			return false;
		}
		ItemMeta meta = item.getItemMeta();
		ItemMeta meta2 = item2.getItemMeta();
		return 
			   
			   (meta.getLore()==null&&meta2.getLore()==null)||meta.getLore().equals(meta2.getLore())&&
			   meta.getDisplayName().equals(meta2.getDisplayName())&&
			   item.getType()==item2.getType();
	}
}
