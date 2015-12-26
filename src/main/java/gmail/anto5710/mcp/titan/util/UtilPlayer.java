package gmail.anto5710.mcp.titan.util;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class UtilPlayer {
	public static Collection<? extends Player> getPlayers(){
		return Bukkit.getOnlinePlayers();
	}
}
