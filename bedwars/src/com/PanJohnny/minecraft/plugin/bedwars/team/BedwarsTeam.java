package com.PanJohnny.minecraft.plugin.bedwars.team;

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
}
