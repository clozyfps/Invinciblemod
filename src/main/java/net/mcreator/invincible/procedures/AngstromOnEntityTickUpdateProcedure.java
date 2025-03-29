package net.mcreator.invincible.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.invincible.init.InvincibleModEntities;

import java.util.List;
import java.util.Comparator;

public class AngstromOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).isAlive()) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					if (Math.random() < 0.003) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entity == entityiterator)) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
									if (entityiterator instanceof Player) {
										if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
											if (entityiterator instanceof ServerPlayer _player && !_player.level().isClientSide()) {
												ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("invincible:apocalypse_dimension"));
												if (_player.level().dimension() == destinationType)
													return;
												ServerLevel nextLevel = _player.server.getLevel(destinationType);
												if (nextLevel != null) {
													_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
													_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
													_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
													for (MobEffectInstance _effectinstance : _player.getActiveEffects())
														_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
													_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
												}
											}
										} else if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
											if (entityiterator instanceof ServerPlayer _player && !_player.level().isClientSide()) {
												ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("invincible:desert_wasteland"));
												if (_player.level().dimension() == destinationType)
													return;
												ServerLevel nextLevel = _player.server.getLevel(destinationType);
												if (nextLevel != null) {
													_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
													_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
													_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
													for (MobEffectInstance _effectinstance : _player.getActiveEffects())
														_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
													_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
												}
											}
										} else if (Mth.nextInt(RandomSource.create(), 1, 3) == 3) {
											if (entityiterator instanceof ServerPlayer _player && !_player.level().isClientSide()) {
												ResourceKey<Level> destinationType = Level.NETHER;
												if (_player.level().dimension() == destinationType)
													return;
												ServerLevel nextLevel = _player.server.getLevel(destinationType);
												if (nextLevel != null) {
													_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
													_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
													_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
													for (MobEffectInstance _effectinstance : _player.getActiveEffects())
														_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
													_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
												}
											}
										}
									} else {
										if (!entityiterator.level().isClientSide())
											entityiterator.discard();
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
