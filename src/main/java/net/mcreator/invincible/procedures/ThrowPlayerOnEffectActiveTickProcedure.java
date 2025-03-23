package net.mcreator.invincible.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.init.InvincibleModMobEffects;

import java.util.List;
import java.util.Comparator;

public class ThrowPlayerOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator)) {
					if (entityiterator instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(InvincibleModMobEffects.GRABBING_ACTIVE.get())) {
						magnitude = Math.sqrt(entityiterator.getLookAngle().x * entityiterator.getLookAngle().x + entityiterator.getLookAngle().y * entityiterator.getLookAngle().y + entityiterator.getLookAngle().z * entityiterator.getLookAngle().z);
						vecX = entityiterator.getLookAngle().x / magnitude;
						vecY = entityiterator.getLookAngle().y / magnitude;
						vecZ = entityiterator.getLookAngle().z / magnitude;
						vecX = vecX * (1.5 + (entityiterator.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 20);
						vecY = vecY * (1.5 + (entityiterator.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 20);
						vecZ = vecZ * (1.5 + (entityiterator.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 20);
						entity.push(vecX, vecY, vecZ);
					}
				}
			}
		}
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(InvincibleModMobEffects.GRABBING_ACTIVE.get());
	}
}
