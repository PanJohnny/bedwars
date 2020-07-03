package com.PanJohnny.minecraft.plugin.bedwars.teleport;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class WorldTele {
	public static void teleport(String name, Player p) {
		World w=Bukkit.getWorld(name);
		if(w==null) {
			p.sendMessage(name+ChatColor.RED+" is invalid name");
			return;
		}
		p.teleport(w.getSpawnLocation());
	}
}
