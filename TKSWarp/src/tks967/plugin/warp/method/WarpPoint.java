package tks967.plugin.warp.method;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import tks967.plugin.warp.TKSWarp;

public class WarpPoint {

	public boolean ExistPoint(String name){					//configにワープポイントの設定が存在するか確認し、booleanを返すメソッド
		final TKSWarp main = TKSWarp.plugin;					//メインクラスの取得
		
		if(main.getConfig().contains("WarpPointList."+name)){	//WarpPointList.+nameがconfigに存在するなら
			return true;									//trueを返す
		}else{													//WarpPointList.+nameがconfigに存在しなければ
			return false;									//falseを返す
		}
	}


	public void setPoint(String name, Location loc){				//ワープポイントを保存するメソッド。
		final TKSWarp main = TKSWarp.plugin;							//メインクラスの取得
		
		String world = loc.getWorld().getName();						//Locationよりワールド名を取得
		double x = loc.getX();											//LocationよりX座標を取得
		double y = loc.getY();											//LocationよりY座標を取得
		double z = loc.getZ();											//LocationよりZ座標を取得
		
		main.getConfig().set("WarpPointList."+name+".World", world);	//WarpPointList.+name+.World の場所にワールド名を書き出す
		main.getConfig().set("WarpPointList."+name+".X", x);			//以下同様に各座標を書き出す
		main.getConfig().set("WarpPointList."+name+".Y", y);			//
		main.getConfig().set("WarpPointList."+name+".Z", z);			//
		main.saveConfig();												//重要：書き出したものをセーブします
		return;
	}


	public void removePoint(String name){				//ワープポイントを削除するメソッド。
		final TKSWarp main = TKSWarp.plugin;				//メインクラスの取得
		
		main.getConfig().set("WarpPointList."+name, null);	//WarpPointList.+name の内容を削除します
		main.saveConfig();									//書き出したものをセーブします
		return;
	}


	public Location getPoint(String name){											//ワープポイントのLocationを返すメソッド
		final TKSWarp main = TKSWarp.plugin;											//メインクラスの取得
		
		String worldname = main.getConfig().getString("WarpPointList."+name+".World");	//ワールド名を取得
		World world = Bukkit.getServer().getWorld(worldname);							//ワールド名からWorldを取得
		double x = main.getConfig().getDouble("WarpPointList."+name+".X");				//X座標を取得
		double y = main.getConfig().getDouble("WarpPointList."+name+".Y");				//Y座標を取得
		double z = main.getConfig().getDouble("WarpPointList."+name+".Z");				//Z座標を取得
		
		Location location = new Location(world, x, y, z);								//取得できたWorldとXYZ座標より新しくLocationを作成する
		return location;															//Locationを返す
	}


	public List<String> getPoints(){				//ワープポイントの一覧をListにして返すメソッド
		final TKSWarp main = TKSWarp.plugin;			//メインクラスの取得
		
		List<String> list = new ArrayList<String>();	//新しくList<String>を作成
		
		for(String name : main.getConfig().getConfigurationSection("WarpPointList.").getKeys(false)){	//config内のWarpPointList内にあるワープポイントを１つづつ見ていく
			list.add(name);								//Listに名前を追加する
		}
		
		return list;								//Listを返す
	}


}
