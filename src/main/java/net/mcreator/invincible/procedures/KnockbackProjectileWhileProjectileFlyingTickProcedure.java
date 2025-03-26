package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

public class KnockbackProjectileWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		InvincibleMod.queueServerWork(10, () -> {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		});
		immediatesourceentity.setNoGravity(true);
	}
}
