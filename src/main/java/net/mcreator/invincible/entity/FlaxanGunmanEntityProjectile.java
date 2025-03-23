
package net.mcreator.invincible.entity;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class FlaxanGunmanEntityProjectile extends AbstractArrow implements ItemSupplier {

	public FlaxanGunmanEntityProjectile(PlayMessages.SpawnEntity packet, Level world) {
		super(InvincibleModEntities.FLAXAN_GUNMAN_PROJECTILE.get(), world);
	}

	public FlaxanGunmanEntityProjectile(EntityType<? extends FlaxanGunmanEntityProjectile> type, Level world) {
		super(type, world);
	}

	public FlaxanGunmanEntityProjectile(EntityType<? extends FlaxanGunmanEntityProjectile> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public FlaxanGunmanEntityProjectile(EntityType<? extends FlaxanGunmanEntityProjectile> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void doPostHurtEffects(LivingEntity livingEntity) {
		super.doPostHurtEffects(livingEntity);
		livingEntity.setArrowCount(livingEntity.getArrowCount() - 1);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return new ItemStack(InvincibleModItems.DELETED_MOD_ELEMENT.get());
	}

	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(InvincibleModItems.DELETED_MOD_ELEMENT.get());
	}
}
