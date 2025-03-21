package net.mcreator.invincible.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class DestructionActiveBurstOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.destroyBlock(BlockPos.containing(x, y, z), false);
		world.destroyBlock(BlockPos.containing(x + 1, y, z), false);
		world.destroyBlock(BlockPos.containing(x + 2, y, z), false);
		world.destroyBlock(BlockPos.containing(x + 3, y, z), false);
		world.destroyBlock(BlockPos.containing(x + 4, y, z), false);
		world.destroyBlock(BlockPos.containing(x - 1, y, z), false);
		world.destroyBlock(BlockPos.containing(x - 2, y, z), false);
		world.destroyBlock(BlockPos.containing(x - 3, y, z), false);
		world.destroyBlock(BlockPos.containing(x - 4, y, z), false);
		world.destroyBlock(BlockPos.containing(x, y, z + 1), false);
		world.destroyBlock(BlockPos.containing(x, y, z + 2), false);
		world.destroyBlock(BlockPos.containing(x, y, z + 3), false);
		world.destroyBlock(BlockPos.containing(x, y, z + 4), false);
		world.destroyBlock(BlockPos.containing(x, y, z - 1), false);
		world.destroyBlock(BlockPos.containing(x, y, z - 2), false);
		world.destroyBlock(BlockPos.containing(x, y, z - 3), false);
		world.destroyBlock(BlockPos.containing(x, y, z - 4), false);
	}
}
