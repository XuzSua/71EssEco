package ess.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import ess.event.LoginRecord;

public class Main extends JavaPlugin{
	
	public File money,config;
	
	public FileConfiguration mc,con;
	
	public static Main plugin;
	
	public void onEnable() {
		
		plugin = this;
		
		setFile();
		
		this.getServer().getPluginManager().registerEvents(new LoginRecord(), this);
		
		getCoreExist();
		
	}
	
	public void getCoreExist() {
		
		if(Bukkit.getPluginManager().getPlugin("71Ess") == null) {
			
			this.getLogger().info("找不到核心插件：71Ess，已終止插件");
			
			this.getPluginLoader().disablePlugin(this.getServer().getPluginManager().getPlugin("71EssEco"));
			
		}
		
	}
	
	public void setFile() {
		
		money = new File(this.getDataFolder().getParentFile().getPath() + "/71Ess/eco_data.yml");
		mc = YamlConfiguration.loadConfiguration(money);
		
		config = new File(this.getDataFolder().getParentFile().getPath() + "/71Ess/eco_config.yml");
		con = YamlConfiguration.loadConfiguration(config);
		
	}
	
	public void reloadFile() {
		
		try {
			
			mc.save(money);
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

}
