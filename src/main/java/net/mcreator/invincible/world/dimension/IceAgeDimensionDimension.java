
package net.mcreator.invincible.world.dimension;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.DimensionSpecialEffects;

@Mod.EventBusSubscriber
public class IceAgeDimensionDimension {
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class IceAgeDimensionSpecialEffectsHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public static void registerDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent event) {
			DimensionSpecialEffects customEffect = new DimensionSpecialEffects(192f, true, DimensionSpecialEffects.SkyType.NONE, false, false) {
				@Override
				public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
					return new Vec3(1, 1, 1);
				}

				@Override
				public boolean isFoggyAt(int x, int y) {
					return false;
				}
			};
			event.register(new ResourceLocation("invincible:ice_age_dimension"), customEffect);
		}
	}
}
