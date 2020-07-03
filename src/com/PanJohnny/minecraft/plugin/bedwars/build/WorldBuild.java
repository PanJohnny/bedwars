package com.PanJohnny.minecraft.plugin.bedwars.build;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.block.Block;

import com.PanJohnny.minecraft.plugin.bedwars.generator.VoidGen;

public class WorldBuild {
	public static World build(String name) {
		WorldCreator wc = new WorldCreator(name);
		
		wc.environment(World.Environment.NORMAL);
		wc.type(WorldType.FLAT);
		wc.generateStructures(false);
		wc.generator(new VoidGen());
		World w=wc.createWorld();
		Block b=w.getBlockAt(w.getSpawnLocation().add(0, -1, 0));
		b.setType(Material.BEDROCK);
		return w;
	}
}
