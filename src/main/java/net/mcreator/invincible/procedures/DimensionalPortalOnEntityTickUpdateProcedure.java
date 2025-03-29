package net.mcreator.invincible.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
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

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.init.InvincibleModEntities;
import net.mcreator.invincible.InvincibleMod;

import java.util.List;
import java.util.Comparator;

public class DimensionalPortalOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)) {
						if (entityiterator instanceof Player) {
							if ((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new InvincibleModVariables.PlayerVariables())).SelectedDimensionString).equals("Empty")) {
								entity.getPersistentData().putDouble("portalrandom", (Mth.nextInt(RandomSource.create(), 1, 6)));
								if (entity.getPersistentData().getDouble("portalrandom") == 1) {
									if (!((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new InvincibleModVariables.PlayerVariables())).DimensionList).contains("Apocalypse World"))) {
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
										InvincibleMod.queueServerWork(10, () -> {
											{
												Entity _ent = entityiterator;
												_ent.teleportTo((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())), (entityiterator.getZ()));
												if (_ent instanceof ServerPlayer _serverPlayer)
													_serverPlayer.connection.teleport((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())),
															(entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
											}
											if (world instanceof ServerLevel _level) {
												Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level,
														BlockPos.containing(entityiterator.getX() - 2, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ()), entityiterator.getZ() - 2),
														MobSpawnType.MOB_SUMMONED);
												if (entityToSpawn != null) {
												}
											}
										});
										{
											String _setval = (((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new InvincibleModVariables.PlayerVariables())).DimensionList) + " , " + "Apocalypse World";
											(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.DimensionList = _setval;
												capability.syncPlayerVariables((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null));
											});
										}
										CollectApocalypticProcedure.execute(entity);
									} else if ((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new InvincibleModVariables.PlayerVariables())).DimensionList).contains("Apocalypse World")) {
										entity.getPersistentData().putDouble("portalrandom", (Mth.nextInt(RandomSource.create(), 1, 2)));
									}
								} else if (entity.getPersistentData().getDouble("portalrandom") == 2) {
									if (!((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new InvincibleModVariables.PlayerVariables())).DimensionList).contains("Desert Wasteland"))) {
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
										InvincibleMod.queueServerWork(10, () -> {
											{
												Entity _ent = entityiterator;
												_ent.teleportTo((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())), (entityiterator.getZ()));
												if (_ent instanceof ServerPlayer _serverPlayer)
													_serverPlayer.connection.teleport((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())),
															(entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
											}
											if (world instanceof ServerLevel _level) {
												Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level,
														BlockPos.containing(entityiterator.getX() - 2, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ()), entityiterator.getZ() - 2),
														MobSpawnType.MOB_SUMMONED);
												if (entityToSpawn != null) {
												}
											}
										});
										{
											String _setval = (((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new InvincibleModVariables.PlayerVariables())).DimensionList) + " , " + "Desert Wasteland";
											(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.DimensionList = _setval;
												capability.syncPlayerVariables((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null));
											});
										}
										CollectDesertProcedure.execute(entity);
									} else if ((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new InvincibleModVariables.PlayerVariables())).DimensionList).contains("Desert Wasteland")) {
										entity.getPersistentData().putDouble("portalrandom", (Mth.nextInt(RandomSource.create(), 1, 6)));
									}
								} else if (entity.getPersistentData().getDouble("portalrandom") == 3) {
									if (!((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new InvincibleModVariables.PlayerVariables())).DimensionList).contains("The Nether"))) {
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
										InvincibleMod.queueServerWork(10, () -> {
											{
												Entity _ent = entityiterator;
												_ent.teleportTo((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())), (entityiterator.getZ()));
												if (_ent instanceof ServerPlayer _serverPlayer)
													_serverPlayer.connection.teleport((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())),
															(entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
											}
											if (world instanceof ServerLevel _level) {
												Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level,
														BlockPos.containing(entityiterator.getX() - 2, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ()), entityiterator.getZ() - 2),
														MobSpawnType.MOB_SUMMONED);
												if (entityToSpawn != null) {
												}
											}
										});
										{
											String _setval = (((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new InvincibleModVariables.PlayerVariables())).DimensionList) + " , " + "The Nether";
											(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.DimensionList = _setval;
												capability.syncPlayerVariables((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null));
											});
										}
										CollectNetherProcedure.execute(entity);
									} else if ((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new InvincibleModVariables.PlayerVariables())).DimensionList).contains("The Nether")) {
										entity.getPersistentData().putDouble("portalrandom", (Mth.nextInt(RandomSource.create(), 1, 6)));
									}
								} else if (entity.getPersistentData().getDouble("portalrandom") == 4) {
									if (!((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new InvincibleModVariables.PlayerVariables())).DimensionList).contains("The End"))) {
										if (entityiterator instanceof ServerPlayer _player && !_player.level().isClientSide()) {
											ResourceKey<Level> destinationType = Level.END;
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
										InvincibleMod.queueServerWork(10, () -> {
											{
												Entity _ent = entityiterator;
												_ent.teleportTo((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())), (entityiterator.getZ()));
												if (_ent instanceof ServerPlayer _serverPlayer)
													_serverPlayer.connection.teleport((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())),
															(entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
											}
											if (world instanceof ServerLevel _level) {
												Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level,
														BlockPos.containing(entityiterator.getX() - 2, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ()), entityiterator.getZ() - 2),
														MobSpawnType.MOB_SUMMONED);
												if (entityToSpawn != null) {
												}
											}
										});
										{
											String _setval = (((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new InvincibleModVariables.PlayerVariables())).DimensionList) + " , " + "The End";
											(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.DimensionList = _setval;
												capability.syncPlayerVariables((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null));
											});
										}
										CollectEndProcedure.execute(entity);
									} else if ((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new InvincibleModVariables.PlayerVariables())).DimensionList).contains("The End")) {
										entity.getPersistentData().putDouble("portalrandom", (Mth.nextInt(RandomSource.create(), 1, 6)));
									}
								} else if (entity.getPersistentData().getDouble("portalrandom") == 5) {
									if (!((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new InvincibleModVariables.PlayerVariables())).DimensionList).contains("Ice Age"))) {
										if (entityiterator instanceof ServerPlayer _player && !_player.level().isClientSide()) {
											ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("invincible:ice_age_dimension"));
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
										InvincibleMod.queueServerWork(10, () -> {
											{
												Entity _ent = entityiterator;
												_ent.teleportTo((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())), (entityiterator.getZ()));
												if (_ent instanceof ServerPlayer _serverPlayer)
													_serverPlayer.connection.teleport((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())),
															(entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
											}
											if (world instanceof ServerLevel _level) {
												Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level,
														BlockPos.containing(entityiterator.getX() - 2, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ()), entityiterator.getZ() - 2),
														MobSpawnType.MOB_SUMMONED);
												if (entityToSpawn != null) {
												}
											}
										});
										{
											String _setval = (((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new InvincibleModVariables.PlayerVariables())).DimensionList) + " , " + "Ice Age";
											(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.DimensionList = _setval;
												capability.syncPlayerVariables((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null));
											});
										}
										CollectSnowProcedure.execute(entity);
									} else if ((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new InvincibleModVariables.PlayerVariables())).DimensionList).contains("Ice Age")) {
										entity.getPersistentData().putDouble("portalrandom", (Mth.nextInt(RandomSource.create(), 1, 6)));
									}
								} else if (entity.getPersistentData().getDouble("portalrandom") == 6) {
									if (!((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new InvincibleModVariables.PlayerVariables())).DimensionList).contains("Flaxan Dimension"))) {
										if (entityiterator instanceof ServerPlayer _player && !_player.level().isClientSide()) {
											ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("invincible:flaxxan_dimension"));
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
										InvincibleMod.queueServerWork(10, () -> {
											{
												Entity _ent = entityiterator;
												_ent.teleportTo((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())), (entityiterator.getZ()));
												if (_ent instanceof ServerPlayer _serverPlayer)
													_serverPlayer.connection.teleport((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())),
															(entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
											}
											if (world instanceof ServerLevel _level) {
												Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level,
														BlockPos.containing(entityiterator.getX() - 2, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ()), entityiterator.getZ() - 2),
														MobSpawnType.MOB_SUMMONED);
												if (entityToSpawn != null) {
												}
											}
										});
										{
											String _setval = (((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new InvincibleModVariables.PlayerVariables())).DimensionList) + " , " + "Flaxan Dimension";
											(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.DimensionList = _setval;
												capability.syncPlayerVariables((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null));
											});
										}
										CollectFlaxanProcedure.execute(entity);
									} else if ((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new InvincibleModVariables.PlayerVariables())).DimensionList).contains("Flaxan Dimension")) {
										entity.getPersistentData().putDouble("portalrandom", (Mth.nextInt(RandomSource.create(), 1, 6)));
									}
								}
							} else if ((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new InvincibleModVariables.PlayerVariables())).SelectedDimensionString).equals("Apocalypse World")) {
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
								InvincibleMod.queueServerWork(10, () -> {
									{
										Entity _ent = entityiterator;
										_ent.teleportTo((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())), (entityiterator.getZ()));
										if (_ent instanceof ServerPlayer _serverPlayer)
											_serverPlayer.connection.teleport((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())), (entityiterator.getZ()),
													_ent.getYRot(), _ent.getXRot());
									}
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level,
												BlockPos.containing(entityiterator.getX() - 2, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ()), entityiterator.getZ() - 2),
												MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
								});
							} else if ((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new InvincibleModVariables.PlayerVariables())).SelectedDimensionString).equals("Desert Wasteland")) {
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
								InvincibleMod.queueServerWork(10, () -> {
									{
										Entity _ent = entityiterator;
										_ent.teleportTo((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())), (entityiterator.getZ()));
										if (_ent instanceof ServerPlayer _serverPlayer)
											_serverPlayer.connection.teleport((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())), (entityiterator.getZ()),
													_ent.getYRot(), _ent.getXRot());
									}
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level,
												BlockPos.containing(entityiterator.getX() - 2, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ()), entityiterator.getZ() - 2),
												MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
								});
							} else if ((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new InvincibleModVariables.PlayerVariables())).SelectedDimensionString).equals("The Nether")) {
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
								InvincibleMod.queueServerWork(10, () -> {
									{
										Entity _ent = entityiterator;
										_ent.teleportTo((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())), (entityiterator.getZ()));
										if (_ent instanceof ServerPlayer _serverPlayer)
											_serverPlayer.connection.teleport((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())), (entityiterator.getZ()),
													_ent.getYRot(), _ent.getXRot());
									}
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level,
												BlockPos.containing(entityiterator.getX() - 2, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ()), entityiterator.getZ() - 2),
												MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
								});
							} else if ((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new InvincibleModVariables.PlayerVariables())).SelectedDimensionString).equals("Ice Age")) {
								if (entityiterator instanceof ServerPlayer _player && !_player.level().isClientSide()) {
									ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("invincible:ice_age_dimension"));
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
								InvincibleMod.queueServerWork(10, () -> {
									{
										Entity _ent = entityiterator;
										_ent.teleportTo((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())), (entityiterator.getZ()));
										if (_ent instanceof ServerPlayer _serverPlayer)
											_serverPlayer.connection.teleport((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())), (entityiterator.getZ()),
													_ent.getYRot(), _ent.getXRot());
									}
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level,
												BlockPos.containing(entityiterator.getX() - 2, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ()), entityiterator.getZ() - 2),
												MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
								});
							} else if ((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new InvincibleModVariables.PlayerVariables())).SelectedDimensionString).equals("Flaxan Dimension")) {
								if (entityiterator instanceof ServerPlayer _player && !_player.level().isClientSide()) {
									ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("invincible:flaxxan_dimension"));
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
								InvincibleMod.queueServerWork(10, () -> {
									{
										Entity _ent = entityiterator;
										_ent.teleportTo((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())), (entityiterator.getZ()));
										if (_ent instanceof ServerPlayer _serverPlayer)
											_serverPlayer.connection.teleport((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())), (entityiterator.getZ()),
													_ent.getYRot(), _ent.getXRot());
									}
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level,
												BlockPos.containing(entityiterator.getX() - 2, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ()), entityiterator.getZ() - 2),
												MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
								});
							} else if ((((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new InvincibleModVariables.PlayerVariables())).SelectedDimensionString).equals("The End")) {
								if (entityiterator instanceof ServerPlayer _player && !_player.level().isClientSide()) {
									ResourceKey<Level> destinationType = Level.END;
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
								InvincibleMod.queueServerWork(10, () -> {
									{
										Entity _ent = entityiterator;
										_ent.teleportTo((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())), (entityiterator.getZ()));
										if (_ent instanceof ServerPlayer _serverPlayer)
											_serverPlayer.connection.teleport((entityiterator.getX()), (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ())), (entityiterator.getZ()),
													_ent.getYRot(), _ent.getXRot());
									}
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level,
												BlockPos.containing(entityiterator.getX() - 2, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entityiterator.getX(), (int) entityiterator.getZ()), entityiterator.getZ() - 2),
												MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
										}
									}
								});
							}
						}
					}
				}
			}
		}
	}
}
