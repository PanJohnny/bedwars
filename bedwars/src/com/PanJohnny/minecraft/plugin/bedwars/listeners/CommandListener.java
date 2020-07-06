package com.PanJohnny.minecraft.plugin.bedwars.listeners;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.PanJohnny.minecraft.plugin.bedwars.Main;
import com.PanJohnny.minecraft.plugin.bedwars.Vars;
import com.PanJohnny.minecraft.plugin.bedwars.build.Builder;
import com.PanJohnny.minecraft.plugin.bedwars.build.WorldBuild;
import com.PanJohnny.minecraft.plugin.bedwars.teleport.WorldTele;


public class CommandListener implements CommandExecutor{
	Main m;
	public CommandListener(Main m) {
		this.m=m;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		boolean succes=true;
		if(sender instanceof Player) {
			Player p= (Player) sender;
			//TODO build mode
			if(label.equalsIgnoreCase("buildmode")) {
				if(args.length!=1) {
					p.sendMessage(ChatColor.RED+"to enter build mode you must provide game id");
				} else {
					games.get(m.getConfig().getInt("games."+args[0]));
				}
			}
			if(label.equalsIgnoreCase("join")) {
				p.sendMessage(Vars.prefix+"joining");
			}
			if(label.equalsIgnoreCase("test")) {
				m.teams.teams.get(0).addPlayer(p);
			}
			if(label.equalsIgnoreCase("createworld")) {
				if(args.length!=1) {
					p.sendMessage(ChatColor.RED+"you must define world name");
					return false;
				} else {
					WorldBuild.build(args[0]);
				}
			}
			if(label.equalsIgnoreCase("world")) {
				if(args.length!=1) {
					p.sendMessage(ChatColor.RED+"you must define world name");
					return false;
				} else {
					WorldTele.teleport(args[0], p);
				}
			}
		}
		return succes;
	}

}
