package com.PanJohnny.minecraft.plugin.bedwars.generator;

import java.util.Random;

import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

public class VoidGen extends ChunkGenerator{
	@Override
	public ChunkData generateChunkData( World world,  Random random, int x, int z,
			 BiomeGrid biome) {
		// TODO Auto-generated method stub
		return createChunkData(world);
	}
	@Override
	public boolean shouldGenerateStructures() {
		// TODO Auto-generated method stub
		return false;
	}
}
