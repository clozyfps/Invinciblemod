
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

import net.mcreator.invincible.procedures.ReturnBar2Procedure;
import net.mcreator.invincible.procedures.ReturnBar1Procedure;
import net.mcreator.invincible.procedures.ReturnAbility9Procedure;
import net.mcreator.invincible.procedures.ReturnAbility8Procedure;
import net.mcreator.invincible.procedures.ReturnAbility7Procedure;
import net.mcreator.invincible.procedures.ReturnAbility6Procedure;
import net.mcreator.invincible.procedures.ReturnAbility5Procedure;
import net.mcreator.invincible.procedures.ReturnAbility4Procedure;
import net.mcreator.invincible.procedures.ReturnAbility3Procedure;
import net.mcreator.invincible.procedures.ReturnAbility2Procedure;
import net.mcreator.invincible.procedures.ReturnAbility1Procedure;
import net.mcreator.invincible.procedures.ReturnAbility10Procedure;
import net.mcreator.invincible.procedures.MoveNameDisplayShadowProcedure;
import net.mcreator.invincible.procedures.MoveNameDisplayProcedure;
import net.mcreator.invincible.procedures.MoveDisplayDisplayOverlayIngameProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class MoveDisplayOverlay {
	@SubscribeEvent(priority = EventPriority.HIGH)
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
			event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/ability_bar.png"), 9, h - 35, 0, 0, 110, 26, 110, 26);

			if (ReturnBar1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/bar_selected.png"), 109, h - 31, 0, 0, 7, 10, 7, 10);
			}
			if (ReturnBar2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/bar_selected.png"), 109, h - 23, 0, 0, 7, 10, 7, 10);
			}
			if (ReturnAbility1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/1.png"), 14, h - 30, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnAbility2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/2.png"), 32, h - 30, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnAbility3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/3.png"), 50, h - 30, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnAbility4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/4.png"), 68, h - 30, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnAbility5Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/5.png"), 86, h - 30, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnAbility6Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/6.png"), 14, h - 30, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnAbility7Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/7.png"), 32, h - 30, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnAbility8Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/8.png"), 50, h - 30, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnAbility9Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/9.png"), 68, h - 30, 0, 0, 16, 16, 16, 16);
			}
			if (ReturnAbility10Procedure.execute(entity)) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/10.png"), 86, h - 30, 0, 0, 16, 16, 16, 16);
			}
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					MoveNameDisplayShadowProcedure.execute(entity), 13, h - 46, -10066330, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					MoveNameDisplayProcedure.execute(entity), 12, h - 47, -1, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
