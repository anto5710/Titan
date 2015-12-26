package gmail.anto5710.mcp.titan;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class CommandException {
	Command cmd;
	Player p;
	CommandExceptionReason reason;
	public enum CommandExceptionReason {
		Usage , Material;
		
		public String toString(CommandExceptionReason reason , Command cmd) {
			String string = "";
			if(reason==Usage){
				String usage = cmd.getUsage();
				string = "Usage: "+cmd.getUsage();
				if(usage==null){
					string ="Wrong Command";
				}
			}
			if(reason==CommandExceptionReason.Material){
				string = "No enough Materials";
			}
			return string;
		}
	}
	
	public CommandException(Command cmd,Player p,CommandExceptionReason reason) {
		this.cmd = cmd;
		this.p = p;
		this.reason = reason;
	}
	
	public void send(){
		p.sendMessage(this.toString());
	}
	
	
	@Override
	public String toString() {
		return ChatColor.RED+"Info>"+ChatColor.GRAY+reason.toString(reason, cmd);
	}
	
}
