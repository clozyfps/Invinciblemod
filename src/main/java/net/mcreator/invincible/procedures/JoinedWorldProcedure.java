package net.mcreator.invincible.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.mcreator.invincible.network.InvincibleModVariables;
import net.mcreator.invincible.init.InvincibleModItems;
import net.mcreator.invincible.init.InvincibleModGameRules;
import net.mcreator.invincible.InvincibleMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class JoinedWorldProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double randomPower = 0;
		if ((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).JoinedWorld == false) {
			{
				boolean _setval = true;
				entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.JoinedWorld = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world.getLevelData().getGameRules().getBoolean(InvincibleModGameRules.POWER_SELECTION_BOOK) == true) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(InvincibleModItems.CHARACTER_PICKER.get()).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
			if (world.getLevelData().getGameRules().getBoolean(InvincibleModGameRules.RANDOM_POWERS) == true) {
				randomPower = Mth.nextInt(RandomSource.create(), 1, 5);
				if (randomPower == 1) {
					{
						String _setval = "Human";
						entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Race = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("You have spawned as a: " + "Human")), false);
				} else if (randomPower == 2) {
					{
						String _setval = "Viltrumite";
						entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Race = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("You have spawned as a: " + "Viltrumite")), false);
				} else if (randomPower == 3) {
					{
						String _setval = "Explode";
						entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Race = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("You have spawned with the power: " + "Explode")), false);
				} else if (randomPower == 4) {
					{
						String _setval = "Replicate";
						entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Race = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("You have spawned with the power: " + "Replicate")), false);
				} else if (randomPower == 5) {
					{
						String _setval = "Portal";
						entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Race = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("You have spawned with the power: " + "Portal")), false);
				}
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(InvincibleModItems.TUTORIAL.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			InvincibleMod.queueServerWork(30, () -> {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7lTip: \u00A7rThe \"Activate Special\" Keybind allows you to perform powerful punches at 10 Strength."), false);
				InvincibleMod.queueServerWork(30, () -> {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7lTip: \u00A7rSpawnOnViltrum Gamerule is active! Meaning Viltrumites spawn on Viltrum while its active. "), false);
				});
			});
		}
	}
}
