
package net.mcreator.invincible.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.invincible.procedures.ReturnStatStrengthProcedure;
import net.mcreator.invincible.procedures.ReturnStatHealthProcedure;
import net.mcreator.invincible.procedures.ReturnStatDefenceProcedure;
import net.mcreator.invincible.procedures.ReturnStatAgilityProcedure;
import net.mcreator.invincible.procedures.ReturnAgeProcedure;
import net.mcreator.invincible.procedures.ReturnAbilityProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class StatsOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(ScreenEvent.Render.Post event) {
		if (event.getScreen() instanceof InventoryScreen) {
			int w = event.getScreen().width;
			int h = event.getScreen().height;
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
			if (true) {
				event.getGuiGraphics().blit(new ResourceLocation("invincible:textures/screens/statmenu.png"), w / 2 + -213, h / 2 + -120, 0, 0, 427, 240, 427, 240);

				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnAbilityProcedure.execute(entity), w / 2 + -186, h / 2 + -75, -10066330, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnAbilityProcedure.execute(entity), w / 2 + -187, h / 2 + -76, -1, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnAgeProcedure.execute(entity), w / 2 + -186, h / 2 + -65, -10066330, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnAgeProcedure.execute(entity), w / 2 + -187, h / 2 + -66, -1, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnStatStrengthProcedure.execute(entity), w / 2 + -163, h / 2 + -52, -1, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnStatDefenceProcedure.execute(entity), w / 2 + -163, h / 2 + -41, -1, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnStatAgilityProcedure.execute(entity), w / 2 + -163, h / 2 + -30, -1, false);
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnStatHealthProcedure.execute(entity), w / 2 + -163, h / 2 + -19, -1, false);
			}
			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
