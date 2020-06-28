package com.PanJohnny.minecraft.plugin.bedwars.build;

import java.util.ArrayList;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Builder {
	ArrayList<Player> builderMode = new ArrayList<Player>();
	ArrayList<Block> savedBlocks = new ArrayList<Block>();
	/**
	 * 
	 * @param p player
	 * @return true if player doesn't have build mode
	 * @return false if player is in build mode
	 */
	public boolean enableBuildMode(Player p) 
	{
		if(builderMode.contains(p)) {
			return false;
		}
		
		builderMode.add(p);
		return true;
	}
	
	/**
	 * 
	 * @param p
	 * @return true if removal was success (player was in build mode)
	 * @return false if player wasn't in build mode
	 */
	public boolean disableBuildMode(Player p) 
	{
		return builderMode.remove(p);
	}
	
	public boolean isInBuildMode(Player p) {
		return builderMode.contains(p);
	}
	
	public void addBlock(Block b) {
		savedBlocks.add(b);
	}
	
	public void removeBlock(Block b) {
		savedBlocks.remove(b);
	}
}
