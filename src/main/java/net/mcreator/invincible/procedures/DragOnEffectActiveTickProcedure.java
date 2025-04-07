package net.mcreator.invincible.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.init.InvincibleModParticleTypes;

import java.util.List;
import java.util.Comparator;

public class DragOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		magnitude = Math.sqrt(entity.getLookAngle().x * entity.getLookAngle().x + entity.getLookAngle().y * entity.getLookAngle().y + entity.getLookAngle().z * entity.getLookAngle().z);
		vecX = entity.getLookAngle().x / magnitude;
		vecY = entity.getLookAngle().y / magnitude;
		vecZ = entity.getLookAngle().z / magnitude;
		vecX = vecX * 0.4;
		vecY = vecY * 0;
		vecZ = vecZ * 0.4;
		entity.push(vecX, 0, vecZ);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator)) {
					if (entityiterator instanceof LivingEntity) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity),
								(float) (7 + (entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Strength / 10));
						magnitude = Math.sqrt(entity.getLookAngle().x * entity.getLookAngle().x + entity.getLookAngle().y * entity.getLookAngle().y + entity.getLookAngle().z * entity.getLookAngle().z);
						vecX = entity.getLookAngle().x / magnitude;
						vecY = entity.getLookAngle().y / magnitude;
						vecZ = entity.getLookAngle().z / magnitude;
						vecX = vecX * 0.4;
						vecY = vecY * 0;
						vecZ = vecZ * 0.4;
						entityiterator.push(vecX, vecY, vecZ);
						{
							Entity _ent = entityiterator;
							_ent.teleportTo(x, y, z);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.EXPLOSION, (entityiterator.getX()), (y - 1), (entityiterator.getZ()), 1, 0.01, 0.1, 0.01, 0);
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.BLOOD_DROP.get()), (entityiterator.getX()), (y - 1), (entityiterator.getZ()), 10, 0.1, 0.1, 0.1, 0.2);
						world.levelEvent(2001, BlockPos.containing(x, y - 1, z), Block.getId((world.getBlockState(BlockPos.containing(entityiterator.getX(), y - 1, entityiterator.getZ())))));
					}
				}
			}
		}
	}
}
