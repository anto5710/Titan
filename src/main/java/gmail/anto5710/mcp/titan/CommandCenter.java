package gmail.anto5710.mcp.titan;

import gmail.anto5710.mcp.titan.CommandException.CommandExceptionReason;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CommandCenter {

	
	public CommandCenter(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equals("titan")){
			EnumCommand en = EnumCommand.find(args[0]);
			Player p = Bukkit.getPlayer(sender.getName());
			
			if(en == null){
				new CommandException(cmd, p,CommandExceptionReason.Usage).send();
			}else{
				run(en, p, args);
			}
		}
	}

	public void run(EnumCommand en, Player p, String[] args) {
		if (en == EnumCommand.GET) {
			String arg = args[1].toLowerCase();
			Inventory inventory = p.getInventory();

			inventory.addItem(getItem(arg));
			p.updateInventory();
		}
		if (en == EnumCommand.SPAWN) {

		}
	}

	private ItemStack getItem(String arg) {
		ItemStack item = new ItemStack(Material.AIR);
		if (arg.equals("blade")) {
			item = CustomItem.Blade;
		}
		if (arg.equals("chain")) {
			item = CustomItem.Chain;
		}
		return item;
	}
	
	public enum EnumCommand {
		SPAWN, GET;
		public static EnumCommand find(String args) {

			String name = args.toUpperCase();
			for (EnumCommand e : EnumCommand.values()) {
				if (e.name().equals(name)) {
					return e;
				}
			}
			return null;
		}

		public boolean equals(Command command, EnumCommand e) {
			return e.toString().equals(command.getName());
		}

	}
}
