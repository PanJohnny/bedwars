package com.PanJohnny.minecraft.plugin.bedwars;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.PanJohnny.minecraft.plugin.bedwars.config.ConfigReader;
import com.PanJohnny.minecraft.plugin.bedwars.listeners.CommandListener;
import com.PanJohnny.minecraft.plugin.bedwars.listeners.EventListener;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		getLogger().warning("\n**************************************\n"
				+ "      Enabling Bedwars 1.0\n"
				+ "      Author: PanJohnny\n"
				+ "      github: github.com/StefanCz0\n"
				+ "**************************************");
		Bukkit.getPluginManager().registerEvents(new EventListener(), this);
		registerCommands();
		saveConfig();
		loadTeams();
	}
	
	public void registerCommands() {
		CommandListener li=new CommandListener();
		getCommand("join").setExecutor(li);
		getCommand("test").setExecutor(li);
		getCommand("createworld").setExecutor(li);
		getCommand("world").setExecutor(li);
	}
	
	public void loadTeams() {
		int teamCount = getConfig().getInt("teams.count");
		for(int i=0;i<teamCount;i++) {
			HashMap<String, String> hash=ConfigReader.readTeam(this, i+"");
			String name=hash.get("name");
			String color=hash.get("color");
			String prefix=hash.get("prefix");
			Vars.teams.registerNewTean(ChatColor.valueOf(color), name, prefix);
		}
		
	}
}
