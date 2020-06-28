package com.PanJohnny.minecraft.plugin.bedwars.listeners;

import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.PanJohnny.minecraft.plugin.bedwars.Vars;


public class CommandListener implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		boolean succes=false;
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
		}
		return succes;
	}

}
