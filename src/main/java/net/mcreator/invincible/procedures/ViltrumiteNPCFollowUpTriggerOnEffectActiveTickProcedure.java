package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ViltrumiteNPCFollowUpTriggerOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		entity.getPersistentData().putDouble("vilnpcfollow", (entity.getPersistentData().getDouble("vilnpcfollow") + 1));
		if (entity.getPersistentData().getDouble("vilnpcfollow") >= 15) {
			entity.getPersistentData().putDouble("vilnpcfollow", 0);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(InvincibleModMobEffects.VILTRUMITE_NPC_FOLLOW_UP_TRIGGER.get());
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getPersistentData().getString("target")).equals(entity.getDisplayName().getString())) {
						if (entityiterator instanceof LivingEntity _entity)
							_entity.removeEffect(InvincibleModMobEffects.COMBO_STILL.get());
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(InvincibleModMobEffects.COMBO_STILL.get());
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 19);
						{
							Entity _shootFrom = entity;
							Level projectileLevel = _shootFrom.level();
							if (!projectileLevel.isClientSide()) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new KnockbackProjectileEntity(InvincibleModEntities.DELETED_MOD_ELEMENT.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 0, 15);
								_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
								_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
						world.levelEvent(2001, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), Block.getId(Blocks.REDSTONE_BLOCK.defaultBlockState()));
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.SHOCKWAVE.get()), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 1, 0.1, 2, 0.1, 0);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("invincible:powerfulpunch")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("invincible:powerfulpunch")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						magnitude = Math.sqrt(entity.getLookAngle().x * entity.getLookAngle().x + entity.getLookAngle().y * entity.getLookAngle().y + entity.getLookAngle().z * entity.getLookAngle().z);
						vecX = entity.getLookAngle().x / magnitude;
						vecY = entity.getLookAngle().y / magnitude;
						vecZ = entity.getLookAngle().z / magnitude;
						vecX = vecX * 3;
						vecY = vecY * 3;
						vecZ = vecZ * 3;
						entityiterator.push(vecX, vecY, vecZ);
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(InvincibleModMobEffects.POINT_DESTRUCTION.get(), 50, 0));
						entityiterator.getPersistentData().putString("target", "");
					}
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(InvincibleModMobEffects.VILTRUMITE_NPC_FOLLOW_UP_TRIGGER.get());
		}
	}
}
