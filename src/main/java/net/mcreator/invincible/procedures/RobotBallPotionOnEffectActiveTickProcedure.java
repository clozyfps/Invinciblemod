package net.mcreator.invincible.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.invincible.init.InvincibleModEntities;
import net.mcreator.invincible.entity.RoboBallEntity;
import net.mcreator.invincible.entity.DimensionalPortalEntity;

import java.util.List;
import java.util.Comparator;

public class RobotBallPotionOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		entity.getPersistentData().putDouble("roboball", (entity.getPersistentData().getDouble("roboball") + 1));
		if (entity.getPersistentData().getDouble("roboball") >= 3) {
			entity.getPersistentData().putDouble("roboball", 0);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof DimensionalPortalEntity) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = InvincibleModEntities.ROBO_BALL.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof RoboBallEntity) {
						if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
							_toTame.tame(_owner);
					}
				}
			}
		}
	}
}
