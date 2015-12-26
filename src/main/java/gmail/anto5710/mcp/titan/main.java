package gmail.anto5710.mcp.titan;

import java.util.List;

import gmail.anto5710.mcp.titan.event.ChainClickEvent;
import gmail.anto5710.mcp.titan.event.ChainPlaceEvent;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{
	PluginManager manager = getServer().getPluginManager();
	public main(){
	}
	@Override
	public void onEnable() {
		new CustomItem();
		registerEvent(manager ,new ChainPlaceEvent(this), new ChainClickEvent(this));
	}
	@Override
	public void onDisable() {
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		new CommandCenter(sender, command, label, args);
		return true;
	}
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command,
			String alias, String[] args) {
		if(command.getName().equals("titan")){
			return TapComplete.getTabComplete(sender, command , alias , args);
		}
		return null;
	}
	private void registerEvent(PluginManager manager, Listener...listeners) {
		for(Listener listener : listeners){
			manager.registerEvents(listener, this);
		}
	}
}
