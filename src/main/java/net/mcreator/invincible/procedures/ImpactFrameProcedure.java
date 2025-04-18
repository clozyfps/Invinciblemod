package net.mcreator.invincible.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.invincible.init.InvincibleModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ImpactFrameProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.isClientSide() && entity instanceof Player) {
			if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(InvincibleModMobEffects.IMPACT_FRAME_POTION.get())) {
				if (Minecraft.getInstance().gameRenderer.currentEffect() == null) {
					Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("minecraft:shaders/post/invert.json"));
				}
			} else {
				if (Minecraft.getInstance().gameRenderer.currentEffect() != null) {
					Minecraft.getInstance().gameRenderer.shutdownEffect();
				}
			}
			if (entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(InvincibleModMobEffects.STOPPED_TIME.get()) || entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(InvincibleModMobEffects.TIME_STOPPED.get())) {
				if (Minecraft.getInstance().gameRenderer.currentEffect() == null) {
					Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("minecraft:shaders/post/desaturate.json"));
				}
			} else {
				if (Minecraft.getInstance().gameRenderer.currentEffect() != null) {
					Minecraft.getInstance().gameRenderer.shutdownEffect();
				}
			}
		}
	}
}
