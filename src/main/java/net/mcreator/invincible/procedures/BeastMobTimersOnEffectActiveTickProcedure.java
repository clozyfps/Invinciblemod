package net.mcreator.invincible.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.invincible.init.InvincibleModMobEffects;

import java.util.List;
import java.util.Comparator;

public class BeastMobTimersOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("beastmobfollow", (entity.getPersistentData().getDouble("beastmobfollow") + 1));
		entity.getPersistentData().putDouble("beastmobfinal", (entity.getPersistentData().getDouble("beastmobfinal") + 1));
		if (entity.getPersistentData().getDouble("beastmobfollow") >= 15) {
			entity.getPersistentData().putDouble("beastmobfollow", 0);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(55 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)) {
						if (entityiterator.getPersistentData().getBoolean("beasttarget")) {
							{
								Entity _ent = entity;
								_ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 1.5), (entityiterator.getZ()));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 1.5), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("invincible:powerfulpunch")),
											SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("invincible:powerfulpunch")), SoundSource.NEUTRAL, 1, 1,
											false);
								}
							}
						}
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("beastmobfinal") >= 20) {
			entity.getPersistentData().putDouble("beastmobfinal", 0);
			entity.getPersistentData().putDouble("beastmobfollow", 0);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(InvincibleModMobEffects.BEAST_MOB_TIMERS.get());
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(55 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)) {
						if (entityiterator.getPersistentData().getBoolean("beasttarget")) {
							entityiterator.push(0, (-3), 0);
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 8);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("invincible:powerfulpunch")),
											SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("invincible:powerfulpunch")), SoundSource.NEUTRAL, 1, 1,
											false);
								}
							}
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.POINT_DESTRUCTION.get(), 60, 0, false, false));
						}
					}
				}
			}
		}
	}
}
