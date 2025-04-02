package net.mcreator.invincible.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import net.mcreator.invincible.init.InvincibleModMobEffects;

public class TimeStoppedUnfreezeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.setNoGravity(false);
		entity.setDeltaMovement(new Vec3((entity.getPersistentData().getDouble("TimeX")), (entity.getPersistentData().getDouble("TimeY")), (entity.getPersistentData().getDouble("TimeZ"))));
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(InvincibleModMobEffects.STOPPED_TIME.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(InvincibleModMobEffects.TIME_STOPPED.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.BLINDNESS);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.DARKNESS);
		if (entity instanceof Mob _mobSetNoAi) {
			_mobSetNoAi.setNoAi(false);
		}
		if (entity instanceof Creeper) {
			if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty())) {
				if (entity instanceof Creeper _creeper)
					_creeper.setSwellDir(0);
			}
		}
	}
}
