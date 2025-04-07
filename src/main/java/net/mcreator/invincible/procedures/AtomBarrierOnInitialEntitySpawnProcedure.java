package net.mcreator.invincible.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.invincible.InvincibleMod;

public class AtomBarrierOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		InvincibleMod.queueServerWork(100, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
