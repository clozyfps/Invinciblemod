package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class TransferProjectileProjectileHitsLivingEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		sourceentity.getPersistentData().putDouble("transferx", (sourceentity.getX()));
		sourceentity.getPersistentData().putDouble("transfery", (sourceentity.getY()));
		sourceentity.getPersistentData().putDouble("transferz", (sourceentity.getZ()));
		{
			Entity _ent = sourceentity;
			_ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
		}
		{
			Entity _ent = entity;
			_ent.teleportTo((sourceentity.getPersistentData().getDouble("transferx")), (sourceentity.getPersistentData().getDouble("transfery")), (sourceentity.getPersistentData().getDouble("transferz")));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport((sourceentity.getPersistentData().getDouble("transferx")), (sourceentity.getPersistentData().getDouble("transfery")), (sourceentity.getPersistentData().getDouble("transferz")), _ent.getYRot(),
						_ent.getXRot());
		}
	}
}
