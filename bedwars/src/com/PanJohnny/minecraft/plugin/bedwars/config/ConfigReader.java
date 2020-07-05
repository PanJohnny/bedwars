package com.PanJohnny.minecraft.plugin.bedwars.config;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import com.PanJohnny.minecraft.plugin.bedwars.Main;

public class ConfigReader {
	/**
	 * keys:
	 * 	color
	 * 	name
	 * 	prefix
	 * @param m Main class {@link Main}
	 * @param id an id of team
	 * @return HashMap
	 */
	public static HashMap<String, String> readTeam(Main m, String id) {
		FileConfiguration c=m.getConfig();
		HashMap<String, String> map= new HashMap<String, String>();
		String color=c.getString("teams."+id+".color");
		String name=c.getString("teams."+id+".name");
		String prefix=ChatColor.translateAlternateColorCodes('&', c.getString("teams."+id+".prefix"));
		map.put("color", color);
		map.put("name", name);
		map.put("prefix", prefix);
		return map;
	}

	
}
