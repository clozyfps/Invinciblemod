
package net.mcreator.invincible.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.invincible.procedures.ReturnCooldown9Procedure;
import net.mcreator.invincible.procedures.ReturnCooldown8Procedure;
import net.mcreator.invincible.procedures.ReturnCooldown7Procedure;
import net.mcreator.invincible.procedures.ReturnCooldown6Procedure;
import net.mcreator.invincible.procedures.ReturnCooldown5Procedure;
import net.mcreator.invincible.procedures.ReturnCooldown4Procedure;
import net.mcreator.invincible.procedures.ReturnCooldown3Procedure;
import net.mcreator.invincible.procedures.ReturnCooldown2Procedure;
import net.mcreator.invincible.procedures.ReturnCooldown1Procedure;
import net.mcreator.invincible.procedures.ReturnCooldown10Procedure;
import net.mcreator.invincible.procedures.MoveDisplayDisplayOverlayIngameProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class MoveCooldownDisplayOverlay {
	@SubscribeEvent(priority = EventPriority.LOW)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (MoveDisplayDisplayOverlayIngameProcedure.execute(entity)) {
			if (ReturnCooldown1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/cooldown.png"), 14, h - 30, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnCooldown2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/cooldown.png"), 32, h - 30, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnCooldown3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/cooldown.png"), 50, h - 30, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnCooldown4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/cooldown.png"), 68, h - 30, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnCooldown5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/cooldown.png"), 86, h - 30, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnCooldown6Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/cooldown.png"), 14, h - 30, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnCooldown7Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/cooldown.png"), 32, h - 30, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnCooldown8Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/cooldown.png"), 50, h - 30, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnCooldown9Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/cooldown.png"), 68, h - 30, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnCooldown10Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/cooldown.png"), 86, h - 30, 0, 0, 16, 16, 16, 16);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
