package com.PanJohnny.minecraft.plugin.bedwars;


import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import com.PanJohnny.minecraft.plugin.bedwars.build.Builder;
import com.PanJohnny.minecraft.plugin.bedwars.team.BedwarsTeams;


public class Vars {
	public static final Builder builder = new Builder();
	public static final String prefix = ChatColor.AQUA+"[BW] "+ChatColor.RESET;
	public static final BedwarsTeams teams=new BedwarsTeams();
}
