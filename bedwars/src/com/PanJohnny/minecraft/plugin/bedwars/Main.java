package com.PanJohnny.minecraft.plugin.bedwars;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.PanJohnny.minecraft.plugin.bedwars.build.Builder;
import com.PanJohnny.minecraft.plugin.bedwars.config.ConfigReader;
import com.PanJohnny.minecraft.plugin.bedwars.game.BedwarsGame;
import com.PanJohnny.minecraft.plugin.bedwars.listeners.CommandListener;
import com.PanJohnny.minecraft.plugin.bedwars.listeners.EventListener;
import com.PanJohnny.minecraft.plugin.bedwars.team.BedwarsTeams;

public class Main extends JavaPlugin{
	public BedwarsTeams teams = new BedwarsTeams();
	public Builder builder = new Builder();
	public ArrayList<BedwarsGame> games=new ArrayList<BedwarsGame>();
	@Override
	public void onEnable() {
		getLogger().warning("\n**************************************\n"
				+ "      Enabling Bedwars 1.0\n"
				+ "      Author: PanJohnny\n"
				+ "      github: github.com/StefanCz0\n"
				+ "**************************************");
		Bukkit.getPluginManager().registerEvents(new EventListener(this), this);
		registerCommands();
		saveConfig();
		loadGames();
	}
	
	public void registerCommands() {
		CommandListener li=new CommandListener(this);
		getCommand("join").setExecutor(li);
		getCommand("test").setExecutor(li);
		getCommand("createworld").setExecutor(li);
		getCommand("world").setExecutor(li);
	}
	
	public void loadGames() {
		
	}
}
