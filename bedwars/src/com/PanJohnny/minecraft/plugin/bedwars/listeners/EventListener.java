package com.PanJohnny.minecraft.plugin.bedwars.listeners;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;

import com.PanJohnny.minecraft.plugin.bedwars.Vars;

import net.md_5.bungee.api.ChatColor;

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
	public void onPlayerKill(EntityDeathEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p= (Player) e.getEntity();
			LivingEntity en=p.getKiller();
			String name=en.getName();
			Bukkit.broadcastMessage(p.getName() + " was killed by "+ name);
		}
	}
}
