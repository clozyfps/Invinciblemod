
package net.mcreator.invincible.world.dimension;

@Mod.EventBusSubscriber
public class FlaxxanDimensionDimension {
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class FlaxxanDimensionSpecialEffectsHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public static void registerDimensionSpecialEffects(RegisterDimensionSpecialEffectsEvent event) {
			DimensionSpecialEffects customEffect = new DimensionSpecialEffects(192f, true, DimensionSpecialEffects.SkyType.NONE, false, false) {
				@Override
				public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
					return new Vec3(0.6, 0, 0);
				}

				@Override
				public boolean isFoggyAt(int x, int y) {
					return false;
				}
			};
			event.register(new ResourceLocation("invincible:flaxxan_dimension"), customEffect);
		}
	}
}