package net.mcreator.invincible.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.init.InvincibleModMobEffects;

import java.util.List;
import java.util.Comparator;

public class StoppedTimeContinueProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if ((entityiterator == entity) == false) {
					if (!((entityiterator.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Race).equals("Speedster")) {
						if (entityiterator.getPersistentData().getBoolean("InitialStop") == false) {
							entityiterator.getPersistentData().putDouble("TimeX", (entityiterator.getDeltaMovement().x()));
							entityiterator.getPersistentData().putDouble("TimeY", (entityiterator.getDeltaMovement().y()));
							entityiterator.getPersistentData().putDouble("TimeZ", (entityiterator.getDeltaMovement().z()));
							entityiterator.getPersistentData().putBoolean("InitialStop", true);
						} else {
							entityiterator.setDeltaMovement(new Vec3(0, 0, 0));
						}
						if ((entityiterator instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(InvincibleModMobEffects.TIME_STOPPED.get())) == false) {
							entity.getPersistentData().putDouble("LookX", (entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(100)), ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, entity)).getBlockPos().getX()));
							entity.getPersistentData().putDouble("LookY", (entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(100)), ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, entity)).getBlockPos().getY()));
							entity.getPersistentData().putDouble("LookZ", (entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(100)), ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, entity)).getBlockPos().getZ()));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.TIME_STOPPED.get(), 20, 0, false, false));
						}
					}
				}
			}
		}
	}
}
