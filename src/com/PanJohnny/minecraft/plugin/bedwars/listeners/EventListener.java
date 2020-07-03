package com.PanJohnny.minecraft.plugin.bedwars.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;

import com.PanJohnny.minecraft.plugin.bedwars.Vars;
import com.PanJohnny.minecraft.plugin.bedwars.team.BedwarsTeam;


public class EventListener implements Listener{

	@EventHandler
	public void onBedBreak(BlockBreakEvent e) 
	{
		
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) 
	{
		Player placer = e.getPlayer();
		Block b=e.getBlock();
		if(Vars.builder.isInBuildMode(placer)) {
			Vars.builder.addBlock(b);
		}
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e)
	{
		Player placer = e.getPlayer();
		Block b=e.getBlock();
		if(Vars.builder.isInBuildMode(placer)) {
			Vars.builder.removeBlock(b);
		}
	}
	@EventHandler
	public void onPlayerEnterBed(PlayerBedEnterEvent e) 
	{
		Player p = e.getPlayer();
		p.sendMessage(ChatColor.RED+"You cannot enter bed");
		e.setCancelled(true);
	}

	@EventHandler
	public void onPlayerKill(PlayerDeathEvent e) {
		Player p=(Player) e.getEntity();
		LivingEntity en=p.getKiller();
		String[] message=e.getDeathMessage().split("\u0020");
		String name=message[message.length-1];
		String prefix="";
		String prefix2="";
		try {

			if(en.getName()!=null) {
				name=en.getName();
			}
		} catch(NullPointerException exe) {}


		ChatColor c=ChatColor.RESET;
		ChatColor c2=ChatColor.RESET;
		if(Vars.teams.isPlayerInSomeTeam(p)) {
			BedwarsTeam team=Vars.teams.getTeamByPlayer(p);
			c=team.getColor();
			prefix=team.getPrefix();
		}
		if(en!=null & en instanceof Player) {
			if(Vars.teams.isPlayerInSomeTeam((Player)en)) {
				BedwarsTeam team=Vars.teams.getTeamByPlayer((Player)en);
				c2=team.getColor();
				prefix2=team.getPrefix();
			}
		}
		e.setDeathMessage(prefix+c+p.getName()+ChatColor.RESET + " was killed by "+ prefix2+c2+name+ChatColor.RESET);

	}
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		String message=e.getMessage();
		String prefix="";
		ChatColor color=ChatColor.RESET;
		Player p = e.getPlayer();
		if(Vars.teams.isPlayerInSomeTeam(p)) {
			BedwarsTeam tm=Vars.teams.getTeamByPlayer(p);
			prefix=tm.getPrefix();
			color=tm.getColor();
		}
		Bukkit.broadcastMessage(prefix+color+p.getName()+ChatColor.RESET+": "+message);
		e.setCancelled(true);
	}
}
