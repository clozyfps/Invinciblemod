package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

public class TitanLeapEffectOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("titanleap", (entity.getPersistentData().getDouble("titanleap") + 1));
	}
}
