package gmail.anto5710.mcp.titan.util;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R2.EnumParticle;
import net.minecraft.server.v1_8_R2.PacketPlayOutWorldParticles;

public class UtilParticleEffect {
	public static void playEffect(EnumParticle particle, Location loc , int id){
		float x = (float) loc.getX();
		float y = (float) loc.getY();
		float z = (float) loc.getZ();
		PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(particle, true, x, y, z, 0, 0, 0, 0, id, 0);
		for(Player p : UtilPlayer.getPlayers()){
			((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
		}
	}
}
