package ess.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import ess.main.Main;

public class LoginRecord implements Listener{
	
	Main plugin = Main.plugin;
	
	@EventHandler
	public void event(PlayerLoginEvent e) {
		
		if(plugin.mc.get(e.getPlayer().getName()) != null) return;
		
		plugin.mc.set(e.getPlayer().getName() + ".money",0);
		plugin.mc.set(e.getPlayer().getName() + ".bought", 0);
		
		plugin.getLogger().info(" [�g�٨t��] " + e.getPlayer().getName() + " ���a���s�b�A�w�Ͳ��@���ɮ�");
		
	}

}
