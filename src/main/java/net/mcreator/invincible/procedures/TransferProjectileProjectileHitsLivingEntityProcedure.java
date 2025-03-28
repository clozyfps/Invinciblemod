package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class TransferProjectileProjectileHitsLivingEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		{
			Entity _ent = entity;
			_ent.teleportTo((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), _ent.getYRot(), _ent.getXRot());
		}
		{
			Entity _ent = sourceentity;
			_ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
		}
	}
}
