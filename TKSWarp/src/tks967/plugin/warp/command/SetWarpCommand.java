package tks967.plugin.warp.command;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tks967.plugin.warp.method.WarpPoint;

public class SetWarpCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//setwarpコマンド
		// /setwarp <Point>
		if(cmd.getName().equalsIgnoreCase("setwarp")) {
			WarpPoint wp = new WarpPoint();					//WarpPointクラスを宣言
			if(args.length == 1){							//入力数がsetwarpを含めないで、1つの時
				if(sender instanceof Player){				//コマンドの発動者がプレイヤーであるとき
					Player player = (Player)sender;			//CommandSenderをPlayerにキャストします
					Location loc = player.getLocation(); 	//Playerの位置情報であるLocationを取得します
					String name = args[0];					//入力された<Point>の部分を取得します(ぶっちゃけいらないかも)
					wp.setPoint(name, loc);					//WarpPointにあるsetPointを使ってワープポイントを保存します
					player.sendMessage(name + "を保存しました");//メッセージ
					return true;
				}else {										//コマンドの発動者がプレイヤー以外であるとき
					sender.sendMessage("ゲーム内コマンドです");	//CommandSenderにメッセージを送る
					return true;
				}
			}else {											//入力数がsetwarpを含めないで、1つ以外のとき
				sender.sendMessage(ChatColor.RED + "/setwarp <Point>");	//CommandSenderにメッセージを送る(色付き)
				return true;
			}
		}
		return false;
	}


}
