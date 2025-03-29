package net.mcreator.invincible.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.invincible.entity.DimensionalPortalEntity;

public class DimensionalPortalTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof DimensionalPortalEntity _datEntI ? _datEntI.getEntityData().get(DimensionalPortalEntity.DATA_DelayEnter) : 0) > 0) {
			if (entity instanceof DimensionalPortalEntity _datEntSetI)
				_datEntSetI.getEntityData().set(DimensionalPortalEntity.DATA_DelayEnter, (int) ((entity instanceof DimensionalPortalEntity _datEntI ? _datEntI.getEntityData().get(DimensionalPortalEntity.DATA_DelayEnter) : 0) - 1));
		}
	}
}
