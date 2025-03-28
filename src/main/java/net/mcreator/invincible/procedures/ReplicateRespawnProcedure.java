package net.mcreator.invincible.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.entity.CloneEntity;

import javax.annotation.Nullable;

import java.util.Comparator;

@Mod.EventBusSubscriber
public class ReplicateRespawnProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		execute(null, world, x, y, z, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		if (entity == null)
			return;
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Race).equals("Replicate")) {
			if (amount >= (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
				if (!world.getEntitiesOfClass(CloneEntity.class, AABB.ofSize(new Vec3(x, y, z), 99999, 99999, 99999), e -> true).isEmpty()) {
					if (((Entity) world.getEntitiesOfClass(CloneEntity.class, AABB.ofSize(new Vec3(x, y, z), 99999, 99999, 99999), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
						{
							Entity _ent = entity;
							_ent.teleportTo((((Entity) world.getEntitiesOfClass(CloneEntity.class, AABB.ofSize(new Vec3(x, y, z), 99999, 99999, 99999), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(CloneEntity.class, AABB.ofSize(new Vec3(x, y, z), 99999, 99999, 99999), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(CloneEntity.class, AABB.ofSize(new Vec3(x, y, z), 99999, 99999, 99999), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport((((Entity) world.getEntitiesOfClass(CloneEntity.class, AABB.ofSize(new Vec3(x, y, z), 99999, 99999, 99999), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(CloneEntity.class, AABB.ofSize(new Vec3(x, y, z), 99999, 99999, 99999), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(CloneEntity.class, AABB.ofSize(new Vec3(x, y, z), 99999, 99999, 99999), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), _ent.getYRot(), _ent.getXRot());
						}
						if (!((Entity) world.getEntitiesOfClass(CloneEntity.class, AABB.ofSize(new Vec3(x, y, z), 99999, 99999, 99999), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).level().isClientSide())
							((Entity) world.getEntitiesOfClass(CloneEntity.class, AABB.ofSize(new Vec3(x, y, z), 99999, 99999, 99999), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
						if (event != null && event.isCancelable()) {
							event.setCanceled(true);
						}
					}
				}
			}
		}
	}
}
