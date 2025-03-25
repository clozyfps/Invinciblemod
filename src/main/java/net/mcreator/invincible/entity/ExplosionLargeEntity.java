
package net.mcreator.invincible.entity;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class ExplosionLargeEntity extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(Blocks.AIR);

	public ExplosionLargeEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(InvincibleModEntities.EXPLOSION_LARGE.get(), world);
	}

	public ExplosionLargeEntity(EntityType<? extends ExplosionLargeEntity> type, Level world) {
		super(type, world);
	}

	public ExplosionLargeEntity(EntityType<? extends ExplosionLargeEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public ExplosionLargeEntity(EntityType<? extends ExplosionLargeEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected ItemStack getPickupItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		SmallExplosionHitProcedure.execute();
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		LargeExplosionHitProcedure.execute();
	}

	@Override
	public void tick() {
		super.tick();
		ExplosionFlyingTickProcedure.execute();
		if (this.inGround)
			this.discard();
	}

	public static ExplosionLargeEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 1f, 5, 5);
	}

	public static ExplosionLargeEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
		return shoot(world, entity, source, pullingPower * 1f, 5, 5);
	}

	public static ExplosionLargeEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		ExplosionLargeEntity entityarrow = new ExplosionLargeEntity(InvincibleModEntities.EXPLOSION_LARGE.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		entityarrow.setSecondsOnFire(100);
		world.addFreshEntity(entityarrow);
		return entityarrow;
	}

	public static ExplosionLargeEntity shoot(LivingEntity entity, LivingEntity target) {
		ExplosionLargeEntity entityarrow = new ExplosionLargeEntity(InvincibleModEntities.EXPLOSION_LARGE.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(5);
		entityarrow.setKnockback(5);
		entityarrow.setCritArrow(false);
		entityarrow.setSecondsOnFire(100);
		entity.level().addFreshEntity(entityarrow);
		return entityarrow;
	}
}
