package com.PanJohnny.minecraft.plugin.bedwars.config;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.util.Vector;

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
	/**
	 * 
	 * @param m Main class {@link Main}
	 * @param id an id of team
	 * @return HashMap
	 */
	public Location readLobby(Main m, String id) {
		FileConfiguration c=m.getConfig();
		double x=c.getDouble("lobby."+id+"x");
		double y=c.getDouble("lobby."+id+"y");
		double z=c.getDouble("lobby."+id+"z");
		Vector location = new Vector(x,y,z);
		String world = c.getString("lobby."+id+"world");
		World rw=Bukkit.getWorld(world);
		if(rw==null) {
			System.err.println("cannot find world with id: "+id);
			return null;
		} else {
			return new Location(rw, location.getX(), location.getY(), location.getZ());
		}
	}


}
