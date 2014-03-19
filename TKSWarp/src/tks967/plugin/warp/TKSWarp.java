package tks967.plugin.warp;

import org.bukkit.plugin.java.JavaPlugin;

import tks967.plugin.warp.command.DelWarpCommand;
import tks967.plugin.warp.command.ListWarpCommand;
import tks967.plugin.warp.command.SetWarpCommand;
import tks967.plugin.warp.command.WarpCommand;

public class TKSWarp extends JavaPlugin {

	public static TKSWarp plugin;
	public void onEnable(){
		plugin = this;
		
		getCommand("warp").setExecutor(new WarpCommand());
		getCommand("setwarp").setExecutor(new SetWarpCommand());
		getCommand("delwarp").setExecutor(new DelWarpCommand());
		getCommand("listwarp").setExecutor(new ListWarpCommand());
		
		saveDefaultConfig();
	}
	public void onDisable(){
	}
}
