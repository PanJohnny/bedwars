package com.PanJohnny.minecraft.plugin.bedwars.team;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

public class BedwarsTeam {
	public Team team;
	public BedwarsTeam(Team team) {
		this.team=team;
	}
	
	@SuppressWarnings("deprecation")
	public boolean hasPlayer(Player p)
	{
		return team.hasPlayer(p);
	}
	
	@SuppressWarnings("deprecation")
	public void addPlayer(Player p) {
		team.addPlayer(p);
	}
	
	public ChatColor getColor() {
		return team.getColor();
	}
	
	public String getName() {
		return team.getDisplayName();
	}
	
	public String getPrefix() {
		return team.getPrefix();
	}
}
