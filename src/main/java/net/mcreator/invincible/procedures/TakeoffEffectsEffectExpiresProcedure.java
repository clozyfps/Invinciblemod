package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

public class TakeoffEffectsEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("xincrease", 0);
		entity.getPersistentData().putDouble("xdecrease", 0);
		entity.getPersistentData().putDouble("zincrease", 0);
		entity.getPersistentData().putDouble("zdecrease", 0);
	}
}
