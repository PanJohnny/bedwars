package com.PanJohnny.minecraft.plugin.bedwars.listeners;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.PanJohnny.minecraft.plugin.bedwars.Vars;
import com.PanJohnny.minecraft.plugin.bedwars.build.WorldBuild;
import com.PanJohnny.minecraft.plugin.bedwars.teleport.WorldTele;


public class CommandListener implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		boolean succes=true;
		if(sender instanceof Player) {
			Player p= (Player) sender;
			//build mode
			if(label.equalsIgnoreCase("buildmode")) {
				if(Vars.builder.isInBuildMode(p)) {
					Vars.builder.disableBuildMode(p);
					p.sendMessage(Vars.prefix+"disabling build mode");
				} else {
					Vars.builder.enableBuildMode(p);
					p.sendMessage(Vars.prefix+"enabling build mode");
				}
			}
			if(label.equalsIgnoreCase("join")) {
				p.sendMessage(Vars.prefix+"joining");
			}
			if(label.equalsIgnoreCase("test")) {
				Vars.teams.teams.get(0).addPlayer(p);
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