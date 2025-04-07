package net.mcreator.invincible.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class RoboBallEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.STONE.defaultBlockState()));
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.POOF, x, (y + 1), z, 3, 0.01, 0.01, 0.01, 0.2);
	}
}
