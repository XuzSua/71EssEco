package ess.classes;

import org.bukkit.entity.Player;

import ess.main.Main;

public class EcoData {
	
	Player player;
	
	static Main plugin = Main.plugin;
	
	public EcoData(Player player) {
		
		this.player = player;
		
	}
	
	public int getMoney() {
		
		int money = plugin.mc.getInt(player.getName() + ".money",0);
		
		return money;
		
	}
	
	public void takeMoney(int amount) {
		
		int money = plugin.mc.getInt(player.getName() + ".money",0);
		
		plugin.mc.set(player.getName() + ".money", amount - money);
		
		plugin.reloadFile();
		
	}
	
	public static void giveMoney(Player player,int amount) {
		
		int money = plugin.mc.getInt(player.getName() + ".money",0);
		
		if(String.valueOf(money).length() > 10) {
			
			plugin.getLogger().info("超過金錢上限，十位數");
			return;
			
		}
		
		plugin.mc.set(player.getName() + ".money", amount + money);
		
		
		plugin.reloadFile();
		
	}
	
	public static boolean BankRupted(Player player) {
		
		int money = plugin.mc.getInt(player.getName() + ".money",0);
		
		return (money < 0);
		
	}
	
	

}
