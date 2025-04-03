package net.mcreator.invincible.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.invincible.world.inventory.StatsMenuMenu;
import net.mcreator.invincible.procedures.ReturnStatStrengthProcedure;
import net.mcreator.invincible.procedures.ReturnStatIntelligenceProcedure;
import net.mcreator.invincible.procedures.ReturnStatDefenceProcedure;
import net.mcreator.invincible.procedures.ReturnStatAgilityProcedure;
import net.mcreator.invincible.procedures.ReturnSkillPointsProcedure;
import net.mcreator.invincible.procedures.ReturnShowMasteryProcedure;
import net.mcreator.invincible.procedures.ReturnShowEXPProcedure;
import net.mcreator.invincible.procedures.ReturnPowerProcedure;
import net.mcreator.invincible.procedures.ReturnPlayerEntityProcedure;
import net.mcreator.invincible.procedures.ReturnNameProcedure;
import net.mcreator.invincible.procedures.ReturnMasteryProcedure;
import net.mcreator.invincible.procedures.ReturnMasteryAmountProcedure;
import net.mcreator.invincible.procedures.ReturnEXPProcedure;
import net.mcreator.invincible.procedures.ReturnEXPAmountProcedure;
import net.mcreator.invincible.procedures.ReturnAddSkillPointsProcedure;
import net.mcreator.invincible.procedures.ReturnAbilityProcedure;
import net.mcreator.invincible.network.StatsMenuButtonMessage;
import net.mcreator.invincible.init.InvincibleModScreens.WidgetScreen;
import net.mcreator.invincible.InvincibleMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class StatsMenuScreen extends AbstractContainerScreen<StatsMenuMenu> implements WidgetScreen {
	private final static HashMap<String, Object> guistate = StatsMenuMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private final static HashMap<String, String> textstate = new HashMap<>();
	ImageButton imagebutton_skillpoint;
	ImageButton imagebutton_skillpoint1;
	ImageButton imagebutton_skillpoint2;
	ImageButton imagebutton_skillpoint3;
	ImageButton imagebutton_arrow_left;
	ImageButton imagebutton_arrow_right;

	public StatsMenuScreen(StatsMenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("invincible:textures/screens/stats_menu.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (ReturnPlayerEntityProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + -55, this.topPos + 36, 35, 0f + (float) Math.atan((this.leftPos + -55 - mouseX) / 40.0), (float) Math.atan((this.topPos + -13 - mouseY) / 40.0),
					livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 59 && mouseX < leftPos + 71 && mouseY > topPos + -10 && mouseY < topPos + 2)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible.stats_menu.tooltip_str"), mouseX, mouseY);
		if (mouseX > leftPos + 59 && mouseX < leftPos + 71 && mouseY > topPos + 3 && mouseY < topPos + 15)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible.stats_menu.tooltip_vit"), mouseX, mouseY);
		if (mouseX > leftPos + 59 && mouseX < leftPos + 71 && mouseY > topPos + 16 && mouseY < topPos + 28)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible.stats_menu.tooltip_agl"), mouseX, mouseY);
		if (mouseX > leftPos + 59 && mouseX < leftPos + 71 && mouseY > topPos + 29 && mouseY < topPos + 41)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible.stats_menu.tooltip_int"), mouseX, mouseY);
		if (mouseX > leftPos + -82 && mouseX < leftPos + 80 && mouseY > topPos + -51 && mouseY < topPos + -42)
			guiGraphics.renderTooltip(font, Component.literal(ReturnEXPAmountProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + -82 && mouseX < leftPos + 80 && mouseY > topPos + 66 && mouseY < topPos + 75)
			guiGraphics.renderTooltip(font, Component.literal(ReturnMasteryAmountProcedure.execute(entity)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("invincible:textures/screens/statsmenu.png"), this.leftPos + -214, this.topPos + -120, 0, 0, 427, 240, 427, 240);

		if (ReturnShowEXPProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("invincible:textures/screens/exp_bar.png"), this.leftPos + -81, this.topPos + -50, Mth.clamp((int) ReturnEXPProcedure.execute(entity) * 160, 0, 2400), 0, 160, 7, 2560, 7);
		}
		if (ReturnShowMasteryProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("invincible:textures/screens/exp_bar.png"), this.leftPos + -81, this.topPos + 67, Mth.clamp((int) ReturnMasteryProcedure.execute(entity) * 160, 0, 2400), 0, 160, 7, 2560, 7);
		}
		RenderSystem.disableBlend();
	}

	public HashMap<String, Object> getWidgets() {
		return guistate;
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				ReturnAbilityProcedure.execute(entity), -76, 51, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnAbilityProcedure.execute(entity), -77, 50, -1, false);
		guiGraphics.drawString(this.font,

				ReturnNameProcedure.execute(entity), -76, -68, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnNameProcedure.execute(entity), -77, -69, -1, false);
		guiGraphics.drawString(this.font,

				ReturnStatStrengthProcedure.execute(entity), 4, -7, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnStatDefenceProcedure.execute(entity), 4, 6, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnStatAgilityProcedure.execute(entity), 4, 19, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnStatIntelligenceProcedure.execute(entity), 4, 32, -11252677, false);
		guiGraphics.drawString(this.font,

				ReturnStatStrengthProcedure.execute(entity), 3, -8, -1, false);
		guiGraphics.drawString(this.font,

				ReturnStatDefenceProcedure.execute(entity), 3, 5, -1, false);
		guiGraphics.drawString(this.font,

				ReturnStatAgilityProcedure.execute(entity), 3, 18, -1, false);
		guiGraphics.drawString(this.font,

				ReturnStatIntelligenceProcedure.execute(entity), 3, 31, -1, false);
		guiGraphics.drawString(this.font,

				ReturnPowerProcedure.execute(entity), 4, -33, -14664184, false);
		guiGraphics.drawString(this.font,

				ReturnPowerProcedure.execute(entity), 3, -34, -8455136, false);
		guiGraphics.drawString(this.font,

				ReturnSkillPointsProcedure.execute(entity), 4, -20, -14664184, false);
		guiGraphics.drawString(this.font,

				ReturnSkillPointsProcedure.execute(entity), 3, -21, -8455136, false);
		guiGraphics.drawString(this.font,

				ReturnAddSkillPointsProcedure.execute(entity), 51, -35, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_skillpoint = new ImageButton(this.leftPos + 59, this.topPos + -10, 12, 12, 0, 0, 12, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_skillpoint.png"), 12, 24, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new StatsMenuButtonMessage(0, x, y, z, textstate));
				StatsMenuButtonMessage.handleButtonAction(entity, 0, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_skillpoint", imagebutton_skillpoint);
		this.addRenderableWidget(imagebutton_skillpoint);
		imagebutton_skillpoint1 = new ImageButton(this.leftPos + 59, this.topPos + 3, 12, 12, 0, 0, 12, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_skillpoint1.png"), 12, 24, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new StatsMenuButtonMessage(1, x, y, z, textstate));
				StatsMenuButtonMessage.handleButtonAction(entity, 1, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_skillpoint1", imagebutton_skillpoint1);
		this.addRenderableWidget(imagebutton_skillpoint1);
		imagebutton_skillpoint2 = new ImageButton(this.leftPos + 59, this.topPos + 16, 12, 12, 0, 0, 12, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_skillpoint2.png"), 12, 24, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new StatsMenuButtonMessage(2, x, y, z, textstate));
				StatsMenuButtonMessage.handleButtonAction(entity, 2, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_skillpoint2", imagebutton_skillpoint2);
		this.addRenderableWidget(imagebutton_skillpoint2);
		imagebutton_skillpoint3 = new ImageButton(this.leftPos + 59, this.topPos + 29, 12, 12, 0, 0, 12, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_skillpoint3.png"), 12, 24, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new StatsMenuButtonMessage(3, x, y, z, textstate));
				StatsMenuButtonMessage.handleButtonAction(entity, 3, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_skillpoint3", imagebutton_skillpoint3);
		this.addRenderableWidget(imagebutton_skillpoint3);
		imagebutton_arrow_left = new ImageButton(this.leftPos + 38, this.topPos + -40, 16, 16, 0, 0, 16, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_arrow_left.png"), 16, 32, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new StatsMenuButtonMessage(4, x, y, z, textstate));
				StatsMenuButtonMessage.handleButtonAction(entity, 4, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_arrow_left", imagebutton_arrow_left);
		this.addRenderableWidget(imagebutton_arrow_left);
		imagebutton_arrow_right = new ImageButton(this.leftPos + 68, this.topPos + -40, 16, 16, 0, 0, 16, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_arrow_right.png"), 16, 32, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new StatsMenuButtonMessage(5, x, y, z, textstate));
				StatsMenuButtonMessage.handleButtonAction(entity, 5, x, y, z, textstate);
			}
		});
		guistate.put("button:imagebutton_arrow_right", imagebutton_arrow_right);
		this.addRenderableWidget(imagebutton_arrow_right);
	}
}
