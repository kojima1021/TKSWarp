package tks967.plugin.warp.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import tks967.plugin.warp.method.WarpPoint;

public class DelWarpCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//removewarpコマンド
		// /removewarp <Point>
		if(cmd.getName().equalsIgnoreCase("delwarp")) {
			WarpPoint wp = new WarpPoint();						//WarpPointクラスを宣言
			if(args.length == 1){								//入力数がremovewarpを含めないで、1つの時
				String name = args[0];							//入力された<Point>の部分を取得します(ぶっちゃけいらないかも)
				if(wp.ExistPoint(name)){						//WarpPointにあるExistPointを使ってワープポイントがあるか確認します
					wp.removePoint(name);						//WarpPointにあるremovePointを使ってワープポイントを削除します
					sender.sendMessage(name+"を削除しました");		//CommandSenderにメッセージを送る
					return true;
				}else {											//ワープポイントが存在しないとき
					sender.sendMessage("ワープポイントが存在しません");	//CommandSenderにメッセージを送る
					return true;
				}
			}else {												//入力数がremovewarpを含めないで、1、2つ以外のとき
				return false;
			}
		}
		return false;
	}
}
