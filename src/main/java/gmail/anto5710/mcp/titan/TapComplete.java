package gmail.anto5710.mcp.titan;

import gmail.anto5710.mcp.titan.CommandCenter.EnumCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class TapComplete {
	private static List<String>commandList = new ArrayList<String>(Arrays.asList("get","spawn"));
	private static List<String>itemList = new ArrayList<>(Arrays.asList("blade","chain"));
	
	public static List<String> getTabComplete(CommandSender sender, Command command,
			String alias, String[] args) {
		int size = args.length;
		if(size > 1){
			EnumCommand cmd = EnumCommand.find(args[0]);
			if(cmd == EnumCommand.GET){
				return itemList;
			}
			if(cmd == EnumCommand.SPAWN){
				
			}
		}
		return commandList;
	}

}
