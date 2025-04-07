package net.mcreator.invincible.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.init.InvincibleModParticleTypes;
import net.mcreator.invincible.entity.AtomBarrierEntity;

import java.util.List;
import java.util.Comparator;

public class AtomBarrierOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator instanceof AtomBarrierEntity)) {
						if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == entityiterator)) {
							if (entityiterator instanceof LivingEntity) {
								entityiterator.hurt(
										new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)),
										(float) (7 + ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new InvincibleModVariables.PlayerVariables())).Strength / 5));
								if (!entity.level().isClientSide())
									entity.discard();
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.PINK_SMOKE.get()), (entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), 5, 0.1, 0.1, 0.1, 0.2);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.EXPLOSION, (entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), 3, 0.1, 0.1, 0.1, 0);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							}
						}
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.PINK_SHOCKWAVE.get()), x, (y + 1), z, 1, 0.1, 0.1, 0.1, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, x, y, z, 15, 2, 2, 2, 0.2);
			magnitude = Math.sqrt((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getLookAngle().x * (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getLookAngle().x
					+ (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getLookAngle().y * (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getLookAngle().y
					+ (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getLookAngle().z * (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getLookAngle().z);
			vecX = (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getLookAngle().x / magnitude;
			vecY = (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getLookAngle().y / magnitude;
			vecZ = (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getLookAngle().z / magnitude;
			vecX = vecX * 1;
			vecY = vecY * 1;
			vecZ = vecZ * 1;
			entity.push(vecX, vecY, vecZ);
			{
				Entity _ent = entity;
				_ent.setYRot((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getYRot());
				_ent.setXRot((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getXRot());
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"particle dust 0.95 0.67 0.98 3 ~ ~ ~ 1 1 1 0 25");
		}
	}
}
