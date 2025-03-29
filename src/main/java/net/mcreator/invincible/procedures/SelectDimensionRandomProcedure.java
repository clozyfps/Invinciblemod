package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SelectDimensionRandomProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double randomDimension = 0;
		boolean alwaysTrue = false;
		alwaysTrue = true;
		{
			BlockPos _bp = BlockPos.containing(x + 2, y, z + 2);
			BlockState _bs = Blocks.AIR.defaultBlockState();
			BlockState _bso = world.getBlockState(_bp);
			for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
				Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
				if (_property != null && _bs.getValue(_property) != null)
					try {
						_bs = _bs.setValue(_property, (Comparable) entry.getValue());
					} catch (Exception e) {
					}
			}
			world.setBlock(_bp, _bs, 3);
		}
		{
			BlockPos _bp = BlockPos.containing(x + 2, y + 1, z + 2);
			BlockState _bs = Blocks.AIR.defaultBlockState();
			BlockState _bso = world.getBlockState(_bp);
			for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
				Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
				if (_property != null && _bs.getValue(_property) != null)
					try {
						_bs = _bs.setValue(_property, (Comparable) entry.getValue());
					} catch (Exception e) {
					}
			}
			world.setBlock(_bp, _bs, 3);
		}
		while (alwaysTrue == true) {
			randomDimension = Mth.nextInt(RandomSource.create(), 1, 7);
			if (randomDimension == 1) {
				if (!((entity.level().dimension()) == Level.OVERWORLD)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level, BlockPos.containing(x + 2, y, z + 2), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && entityiterator instanceof DimensionalPortalEntity) {
								if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
									_toTame.tame(_owner);
								if (entityiterator instanceof DimensionalPortalEntity _datEntSetS)
									_datEntSetS.getEntityData().set(DimensionalPortalEntity.DATA_TargetDimension, "Overworld");
							}
						}
					}
					if (entity instanceof Player _player)
						_player.closeContainer();
					alwaysTrue = false;
					break;
				} else {
					continue;
				}
			} else if (randomDimension == 2) {
				if (!((entity.level().dimension()) == Level.END)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level, BlockPos.containing(x + 2, y, z + 2), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && entityiterator instanceof DimensionalPortalEntity) {
								if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
									_toTame.tame(_owner);
								if (entityiterator instanceof DimensionalPortalEntity _datEntSetS)
									_datEntSetS.getEntityData().set(DimensionalPortalEntity.DATA_TargetDimension, "End");
							}
						}
					}
					if (entity instanceof Player _player)
						_player.closeContainer();
					alwaysTrue = false;
					break;
				} else {
					continue;
				}
			} else if (randomDimension == 3) {
				if (!((entity.level().dimension()) == Level.NETHER)) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level, BlockPos.containing(x + 2, y, z + 2), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && entityiterator instanceof DimensionalPortalEntity) {
								if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
									_toTame.tame(_owner);
								if (entityiterator instanceof DimensionalPortalEntity _datEntSetS)
									_datEntSetS.getEntityData().set(DimensionalPortalEntity.DATA_TargetDimension, "Nether");
							}
						}
					}
					if (entity instanceof Player _player)
						_player.closeContainer();
					alwaysTrue = false;
					break;
				} else {
					continue;
				}
			} else if (randomDimension == 4) {
				if (!((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("invincible:desert_wasteland")))) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level, BlockPos.containing(x + 2, y, z + 2), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && entityiterator instanceof DimensionalPortalEntity) {
								if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
									_toTame.tame(_owner);
								if (entityiterator instanceof DimensionalPortalEntity _datEntSetS)
									_datEntSetS.getEntityData().set(DimensionalPortalEntity.DATA_TargetDimension, "Desert");
							}
						}
					}
					if (entity instanceof Player _player)
						_player.closeContainer();
					alwaysTrue = false;
					break;
				} else {
					continue;
				}
			} else if (randomDimension == 5) {
				if (!((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("invincible:apocalypse_dimension")))) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level, BlockPos.containing(x + 2, y, z + 2), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && entityiterator instanceof DimensionalPortalEntity) {
								if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
									_toTame.tame(_owner);
								if (entityiterator instanceof DimensionalPortalEntity _datEntSetS)
									_datEntSetS.getEntityData().set(DimensionalPortalEntity.DATA_TargetDimension, "Apocalyptic");
							}
						}
					}
					if (entity instanceof Player _player)
						_player.closeContainer();
					alwaysTrue = false;
					break;
				} else {
					continue;
				}
			} else if (randomDimension == 6) {
				if (!((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("invincible:ice_age_dimension")))) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level, BlockPos.containing(x + 2, y, z + 2), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && entityiterator instanceof DimensionalPortalEntity) {
								if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
									_toTame.tame(_owner);
								if (entityiterator instanceof DimensionalPortalEntity _datEntSetS)
									_datEntSetS.getEntityData().set(DimensionalPortalEntity.DATA_TargetDimension, "Snow");
							}
						}
					}
					if (entity instanceof Player _player)
						_player.closeContainer();
					alwaysTrue = false;
					break;
				} else {
					continue;
				}
			} else if (randomDimension == 7) {
				if (!((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("invincible:flaxxan_dimension")))) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level, BlockPos.containing(x + 2, y, z + 2), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && entityiterator instanceof DimensionalPortalEntity) {
								if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
									_toTame.tame(_owner);
								if (entityiterator instanceof DimensionalPortalEntity _datEntSetS)
									_datEntSetS.getEntityData().set(DimensionalPortalEntity.DATA_TargetDimension, "Flaxan");
							}
						}
					}
					if (entity instanceof Player _player)
						_player.closeContainer();
					alwaysTrue = false;
					break;
				} else {
					continue;
				}
			}
		}
	}
}
