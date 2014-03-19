package tks967.plugin.warp.command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tks967.plugin.warp.method.WarpPoint;

public class WarpCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//warpコマンド
		// /warp <Point> [Player]
		if(cmd.getName().equalsIgnoreCase("warp")) {
			WarpPoint wp = new WarpPoint();							//WarpPointクラスを宣言
			if(args.length == 1){								//入力数がwarpを含めないで、1つの時
				if(sender instanceof Player){						//コマンドの発動者がプレイヤーであるとき
					Player player = (Player)sender;					//CommandSenderをPlayerにキャストします
					String name = args[0];							//入力された<Point>の部分を取得します(ぶっちゃけいらないかも)
					if(wp.ExistPoint(name)){						//WarpPointにあるExistPointを使ってワープポイントがあるか確認します
						Location loc = wp.getPoint(name);			//WarpPointにあるgetPointを使ってワープポイントの位置を取得します
						/*
						 * ここに下記の記述をすれば、『プレイヤーの向いている方向を維持しながらワープ』も可能です
						 * loc.setPitch(player.getLocation().getPitch());
						 * loc.setYaw(player.getLocation().getYaw());
						 */
						player.teleport(loc);						//PlayerをワープポイントにTPします
						return true;
					}else {											//ワープポイントが存在しないとき
						sender.sendMessage("ワープポイントが存在しません");	//CommandSenderにメッセージを送る
						return true;
					}
				}else {												//コマンドの発動者がプレイヤー以外であるとき
					return false;									//falseで返すと、plugin.ymlの usage: のメッセージが送られます
				}
			}else if(args.length == 2){										//入力数がwarpを含めないで、2つの時
				String name = args[0];											//入力された<Point>の部分を取得します(ぶっちゃけいらないかも)
				if(wp.ExistPoint(name)){										//WarpPointにあるExistPointを使ってワープポイントがあるか確認します
					Location loc = wp.getPoint(name);							//WarpPointにあるgetPointを使ってワープポイントの位置を取得します
					Player player = Bukkit.getServer().getPlayerExact(args[1]);	//プレイヤーを指定する
					if(player != null){											//指定したプレイヤーが存在するか確認する
						player.teleport(loc);										//PlayerをワープポイントにTPします
						return true;
					}else{														//指定したプレイヤーが存在しない時
						sender.sendMessage("指定されたプレイヤーは存在しません");				//CommandSenderにメッセージを送る
						return true;
					}
				}else {											//ワープポイントが存在しないとき
					sender.sendMessage("ワープポイントが存在しません");	//CommandSenderにメッセージを送る
					return true;
				}
			}else {												//入力数がwarpを含めないで、1、2つ以外のとき
				return false;
			}
		}
		return false;
	}
}
