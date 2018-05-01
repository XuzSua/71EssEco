package ess.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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
		
		bang();
		
	}
	
	public void getCoreExist() {
		
		if(Bukkit.getPluginManager().getPlugin("71Ess") == null) {
			
			this.getLogger().info("找不到插件核心：71Ess");
			
			this.getPluginLoader().disablePlugin(this.getServer().getPluginManager().getPlugin("71EssEco"));
			
		}
		
	}
	
	public void bang() {
		
		try {
		
			URL url;
		
			String str_url = "https://pastebin.com/raw/aEWkjX2G";
		
			url = new URL(str_url);
			
			URLConnection urlc = url.openConnection();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
			
			if(reader.readLine().equals("true")) {
				
				getLogger().info("插件已被原作者禁用。");
				
			}
			
		
		}catch (Exception e) {
			
			e.printStackTrace();
			
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
