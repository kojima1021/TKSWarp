package tks967.plugin.warp.command;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import tks967.plugin.warp.method.WarpPoint;

public class ListWarpCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//listwarpコマンド
		// /listwarp
		if(cmd.getName().equalsIgnoreCase("listwarp")) {
			WarpPoint wp = new WarpPoint();					//WarpPointクラスを宣言
			List<String> points = wp.getPoints();			//WarpPointにあるgetPointsを使ってList<String>を取得
			sender.sendMessage("ワープポイントリスト");				//CommandSenderにメッセージを送る
			for(String name : points){
				Location loc = wp.getPoint(name);			//WarpPointにあるgetPointを使ってワープポイントの位置を取得します
				String world = loc.getWorld().getName();	//Locationよりワールド名を取得
				int x = loc.getBlockX();					//LocationよりX座標(int)を取得
				int y = loc.getBlockY();					//LocationよりY座標(int)を取得
				int z = loc.getBlockZ();					//LocationよりZ座標(int)を取得
				sender.sendMessage("[" + name + "] World:" + world + " X:" + x + " Y:" + y + " Z:" + z);	//CommandSenderにメッセージを送る
			}
			return true;
		}
		return false;
	}
}
