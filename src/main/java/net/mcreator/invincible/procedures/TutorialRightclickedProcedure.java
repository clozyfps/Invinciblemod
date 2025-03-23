package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

public class TutorialRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("-Viltrumites-"), false);
		InvincibleMod.queueServerWork(10, () -> {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("You cannot perform heavy punches until you reach 10 Strength "), false);
			InvincibleMod.queueServerWork(10, () -> {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Knockback isnt high until you reach higher strengths 25+"), false);
				InvincibleMod.queueServerWork(10, () -> {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Right Click To Throw After Grabbing"), false);
					InvincibleMod.queueServerWork(10, () -> {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Kill Mobs To Level Up Your Power"), false);
						InvincibleMod.queueServerWork(10, () -> {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("Use /Invincible To Set Stats"), false);
						});
					});
				});
			});
		});
	}
}
