package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SelectDimensionDesertProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("invincible:desert_wasteland")))) {
			if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).DimensionList).contains("Desert" + ", ")) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = InvincibleModEntities.DIMENSIONAL_PORTAL.get().spawn(_level, BlockPos.containing(x + 2, y, z + 2), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
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
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("You haven't been to that dimension"), true);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("You can not open a portal here"), true);
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
