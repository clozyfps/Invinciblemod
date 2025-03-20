package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.invincible.init.InvincibleModMobEffects;

public class FogColorProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(InvincibleModMobEffects.MARS_SHADER.get())) {
		}
	}
}
