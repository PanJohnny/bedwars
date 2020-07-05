package com.PanJohnny.minecraft.plugin.bedwars.team;

import java.util.ArrayList;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import org.bukkit.scoreboard.Team.Option;
import org.bukkit.scoreboard.Team.OptionStatus;

public class BedwarsTeams {
	public ScoreboardManager manager = Bukkit.getScoreboardManager();
	public Scoreboard scoreboard = manager.getNewScoreboard();
	public ArrayList<BedwarsTeam> teams=new ArrayList<BedwarsTeam>();
	public void registerNewTean(ChatColor color, String name, String prefix) {
		Team newteam=scoreboard.registerNewTeam(name);
		newteam.setColor(color);
		newteam.setDisplayName(name);
		newteam.setPrefix(prefix+" ");
		newteam.setAllowFriendlyFire(false);
		newteam.setOption(Team.Option.COLLISION_RULE, OptionStatus.FOR_OTHER_TEAMS);
		newteam.setOption(Option.DEATH_MESSAGE_VISIBILITY, OptionStatus.NEVER);
		teams.add(new BedwarsTeam(newteam));
	}
	
	public BedwarsTeam getTeamByPlayer(Player p) {
		//loop
		for(int i=0;i<teams.size();i++) {
			BedwarsTeam t = teams.get(i);
			if(t.hasPlayer(p)) {
				return t;
			}
		}
		return null;
	}
	
	public boolean isPlayerInSomeTeam(Player p) {
		for(int i=0;i<teams.size();i++) {
			BedwarsTeam t = teams.get(i);
			return t.hasPlayer(p);
		}
		return false;
	}
}
