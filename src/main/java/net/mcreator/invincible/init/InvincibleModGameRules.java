
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.invincible.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class InvincibleModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> SPACEEXIST = GameRules.register("spaceexist", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> POWER_SELECTION_BOOK = GameRules.register("powerSelectionBook", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> RANDOM_POWERS = GameRules.register("randomPowers", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
}
