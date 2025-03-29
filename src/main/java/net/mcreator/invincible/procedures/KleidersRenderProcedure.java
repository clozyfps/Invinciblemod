package net.mcreator.invincible.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.invincible.network.InvincibleModVariables;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;

@Mod.EventBusSubscriber(value = {Dist.CLIENT})
public class KleidersRenderProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onEventTriggered(RenderLivingEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		RenderLivingEvent _evt = (RenderLivingEvent) event;
		Minecraft mc = Minecraft.getInstance();
		EntityRenderDispatcher dis = Minecraft.getInstance().getEntityRenderDispatcher();
		EntityRendererProvider.Context context = new EntityRendererProvider.Context(dis, mc.getItemRenderer(), mc.getBlockRenderer(), dis.getItemInHandRenderer(), mc.getResourceManager(), mc.getEntityModels(), mc.font);
		Entity _evtEntity = _evt.getEntity();
		PlayerRenderer _pr = null;
		PoseStack poseStack = _evt.getPoseStack();
		if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
			ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/empty.png");
			com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer emptyRenderer = new com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer(context,
					(_evtEntity instanceof AbstractClientPlayer ? ((AbstractClientPlayer) _evtEntity).getModelName().equals("slim") : false), _texture);
			_pr = emptyRenderer;
			emptyRenderer.clearLayers();
			emptyRenderer.render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(), _evt.getMultiBufferSource(), _evt.getPackedLight());
		}
		if (((entity.getCapability(InvincibleModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new InvincibleModVariables.PlayerVariables())).Race).equals("Explode")) {
			if (entity.getPersistentData().getDouble("rexSPLODE") <= 20 && entity.getPersistentData().getDouble("rexSPLODE") > 18) {
				if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
					ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
					if (ResourceLocation.tryParse("invincible:textures/entities/explode_1.png") != null) {
						_texture = new ResourceLocation("invincible:textures/entities/explode_1.png");
					}
					new com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer(context, false, _texture).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
							_evt.getMultiBufferSource(), _evt.getPackedLight());
				}
			}
			if (entity.getPersistentData().getDouble("rexSPLODE") <= 18 && entity.getPersistentData().getDouble("rexSPLODE") > 16) {
				if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
					ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
					if (ResourceLocation.tryParse("invincible:textures/entities/explode_2.png") != null) {
						_texture = new ResourceLocation("invincible:textures/entities/explode_2.png");
					}
					new com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer(context, false, _texture).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
							_evt.getMultiBufferSource(), _evt.getPackedLight());
				}
			}
			if (entity.getPersistentData().getDouble("rexSPLODE") <= 16 && entity.getPersistentData().getDouble("rexSPLODE") > 14) {
				if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
					ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
					if (ResourceLocation.tryParse("invincible:textures/entities/explode_3.png") != null) {
						_texture = new ResourceLocation("invincible:textures/entities/explode_3.png");
					}
					new com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer(context, false, _texture).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
							_evt.getMultiBufferSource(), _evt.getPackedLight());
				}
			}
			if (entity.getPersistentData().getDouble("rexSPLODE") <= 14 && entity.getPersistentData().getDouble("rexSPLODE") > 12) {
				if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
					ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
					if (ResourceLocation.tryParse("invincible:textures/entities/explode_4.png") != null) {
						_texture = new ResourceLocation("invincible:textures/entities/explode_4.png");
					}
					new com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer(context, false, _texture).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
							_evt.getMultiBufferSource(), _evt.getPackedLight());
				}
			}
			if (entity.getPersistentData().getDouble("rexSPLODE") <= 12 && entity.getPersistentData().getDouble("rexSPLODE") > 10) {
				if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
					ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
					if (ResourceLocation.tryParse("invincible:textures/entities/explode_5.png") != null) {
						_texture = new ResourceLocation("invincible:textures/entities/explode_5.png");
					}
					new com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer(context, false, _texture).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
							_evt.getMultiBufferSource(), _evt.getPackedLight());
				}
			}
			if (entity.getPersistentData().getDouble("rexSPLODE") <= 10 && entity.getPersistentData().getDouble("rexSPLODE") > 8) {
				if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
					ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
					if (ResourceLocation.tryParse("invincible:textures/entities/explode_6.png") != null) {
						_texture = new ResourceLocation("invincible:textures/entities/explode_6.png");
					}
					new com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer(context, false, _texture).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
							_evt.getMultiBufferSource(), _evt.getPackedLight());
				}
			}
			if (entity.getPersistentData().getDouble("rexSPLODE") <= 8 && entity.getPersistentData().getDouble("rexSPLODE") > 6) {
				if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
					ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
					if (ResourceLocation.tryParse("invincible:textures/entities/explode_7.png") != null) {
						_texture = new ResourceLocation("invincible:textures/entities/explode_7.png");
					}
					new com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer(context, false, _texture).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
							_evt.getMultiBufferSource(), _evt.getPackedLight());
				}
			}
			if (entity.getPersistentData().getDouble("rexSPLODE") <= 6 && entity.getPersistentData().getDouble("rexSPLODE") > 4) {
				if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
					ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
					if (ResourceLocation.tryParse("invincible:textures/entities/explode_8.png") != null) {
						_texture = new ResourceLocation("invincible:textures/entities/explode_8.png");
					}
					new com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer(context, false, _texture).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
							_evt.getMultiBufferSource(), _evt.getPackedLight());
				}
			}
			if (entity.getPersistentData().getDouble("rexSPLODE") <= 4 && entity.getPersistentData().getDouble("rexSPLODE") > 2) {
				if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
					ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
					if (ResourceLocation.tryParse("invincible:textures/entities/explode_9.png") != null) {
						_texture = new ResourceLocation("invincible:textures/entities/explode_9.png");
					}
					new com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer(context, false, _texture).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
							_evt.getMultiBufferSource(), _evt.getPackedLight());
				}
			}
			if (entity.getPersistentData().getDouble("rexSPLODE") <= 2 && entity.getPersistentData().getDouble("rexSPLODE") > 0) {
				if (_evt.getRenderer() instanceof PlayerRenderer && !(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersIgnoreCancel)) {
					ResourceLocation _texture = new ResourceLocation("kleiders_custom_renderer:textures/entities/default.png");
					if (ResourceLocation.tryParse("invincible:textures/entities/explode_10.png") != null) {
						_texture = new ResourceLocation("invincible:textures/entities/explode_10.png");
					}
					new com.kleiders.kleidersplayerrenderer.KleidersSkinRenderer(context, false, _texture).render((AbstractClientPlayer) _evt.getEntity(), _evt.getEntity().getYRot(), _evt.getPartialTick(), _evt.getPoseStack(),
							_evt.getMultiBufferSource(), _evt.getPackedLight());
				}
			}
		}
	}
}
