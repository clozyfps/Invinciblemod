package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

public class RexplodeForwardProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.isClientSide()) {
			SetupAnimationsProcedure.setAnimationClientside((Player) entity, "slam", true);
		}
		if (!world.isClientSide()) {
			if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
				List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
				synchronized (connections) {
					Iterator<Connection> iterator = connections.iterator();
					while (iterator.hasNext()) {
						Connection connection = iterator.next();
						if (!connection.isConnecting() && connection.isConnected())
							InvincibleMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.InvincibleModAnimationMessage(Component.literal("slam"), entity.getId(), true), connection, NetworkDirection.PLAY_TO_CLIENT);
					}
				}
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.SHOCKWAVE_BIG.get()), x, (y + 1), z, 1, 0.1, 0.1, 0.1, 0);
		int horizontalRadiusSquare = (int) 3 - 1;
		int verticalRadiusSquare = (int) 1 - 1;
		int yIterationsSquare = verticalRadiusSquare;
		for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
			for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
				for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
					// Execute the desired statements within the square/cube
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null, (entity.getX() + entity.getLookAngle().x * 4) + xi, y + i, (entity.getZ() + entity.getLookAngle().z * 4) + zi, (float) 0.5, Level.ExplosionInteraction.MOB);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.EXPLODE.get()), (entity.getX() + entity.getLookAngle().x * 4) + xi, y + i, (entity.getZ() + entity.getLookAngle().z * 4) + zi, 1, 0.1, 0.1, 0.1, 0);
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("invincible:untargetable")))) {
						entityiterator.invulnerableTime = 0;
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_EXPLOSION), entity), 25);
					}
				}
			}
		}
	}
}
