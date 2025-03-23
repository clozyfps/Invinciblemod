package net.mcreator.invincible.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.entity.MarsProximityEntity;

import java.util.Comparator;

public class TestRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!entity.isShiftKeyDown()) {
			if (!world.getEntitiesOfClass(MarsProximityEntity.class, AABB.ofSize(new Vec3(x, y, z), 500, 500, 500), e -> true).isEmpty()) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("nigga mars is at X:" + ((Entity) world.getEntitiesOfClass(MarsProximityEntity.class, AABB.ofSize(new Vec3(x, y, z), 500, 500, 500), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX() + " Y:" + ((Entity) world.getEntitiesOfClass(MarsProximityEntity.class, AABB.ofSize(new Vec3(x, y, z), 500, 500, 500), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY() + " Z:" + ((Entity) world.getEntitiesOfClass(MarsProximityEntity.class, AABB.ofSize(new Vec3(x, y, z), 500, 500, 500), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ())), false);
			}
		} else if (entity.isShiftKeyDown()) {
			InvincibleModVariables.WorldVariables.get(world).EventTimer = 18000;
			InvincibleModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
