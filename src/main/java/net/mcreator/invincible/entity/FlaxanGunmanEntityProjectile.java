
package net.mcreator.invincible.entity;

import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

import net.mcreator.invincible.init.InvincibleModItems;
import net.mcreator.invincible.init.InvincibleModEntities;

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
		return new ItemStack(InvincibleModItems.FLAXAN_GUN.get());
	}

	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(InvincibleModItems.FLAXAN_GUN.get());
	}
}
