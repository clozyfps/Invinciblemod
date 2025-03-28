package net.mcreator.invincible.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.invincible.world.inventory.BookPickerMenu;
import net.mcreator.invincible.network.BookPickerButtonMessage;
import net.mcreator.invincible.InvincibleMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class BookPickerScreen extends AbstractContainerScreen<BookPickerMenu> {
	private final static HashMap<String, Object> guistate = BookPickerMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_icon_viltrumite;
	ImageButton imagebutton_icon_human;
	ImageButton imagebutton_icon_speedster;
	ImageButton imagebutton_icon_spider;
	ImageButton imagebutton_icon_explode;
	ImageButton imagebutton_icon_cloning;
	ImageButton imagebutton_icon_portal;

	public BookPickerScreen(BookPickerMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("invincible:textures/screens/book_picker.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -52 && mouseX < leftPos + -30 && mouseY > topPos + -47 && mouseY < topPos + -25)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible.book_picker.tooltip_viltrumite"), mouseX, mouseY);
		if (mouseX > leftPos + -78 && mouseX < leftPos + -56 && mouseY > topPos + -47 && mouseY < topPos + -25)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible.book_picker.tooltip_human"), mouseX, mouseY);
		if (mouseX > leftPos + -26 && mouseX < leftPos + -4 && mouseY > topPos + -47 && mouseY < topPos + -25)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible.book_picker.tooltip_speedster"), mouseX, mouseY);
		if (mouseX > leftPos + 1 && mouseX < leftPos + 23 && mouseY > topPos + -47 && mouseY < topPos + -25)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible.book_picker.tooltip_spider"), mouseX, mouseY);
		if (mouseX > leftPos + 27 && mouseX < leftPos + 49 && mouseY > topPos + -47 && mouseY < topPos + -25)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible.book_picker.tooltip_explode"), mouseX, mouseY);
		if (mouseX > leftPos + 53 && mouseX < leftPos + 75 && mouseY > topPos + -47 && mouseY < topPos + -25)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible.book_picker.tooltip_cloning"), mouseX, mouseY);
		if (mouseX > leftPos + -78 && mouseX < leftPos + -56 && mouseY > topPos + -22 && mouseY < topPos + 0)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible.book_picker.tooltip_portal"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("invincible:textures/screens/selection_menu.png"), this.leftPos + -214, this.topPos + -120, 0, 0, 427, 240, 427, 240);

		guiGraphics.blit(new ResourceLocation("invincible:textures/screens/slot.png"), this.leftPos + -78, this.topPos + -47, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(new ResourceLocation("invincible:textures/screens/slot.png"), this.leftPos + -52, this.topPos + -47, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(new ResourceLocation("invincible:textures/screens/slot.png"), this.leftPos + -26, this.topPos + -47, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(new ResourceLocation("invincible:textures/screens/slot.png"), this.leftPos + 1, this.topPos + -47, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(new ResourceLocation("invincible:textures/screens/slot.png"), this.leftPos + 27, this.topPos + -47, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(new ResourceLocation("invincible:textures/screens/slot.png"), this.leftPos + 53, this.topPos + -47, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(new ResourceLocation("invincible:textures/screens/slot.png"), this.leftPos + -78, this.topPos + -22, 0, 0, 22, 22, 22, 22);

		RenderSystem.disableBlend();
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
		guiGraphics.drawString(this.font, Component.translatable("gui.invincible.book_picker.label_ability_selection1"), -76, -68, -11252677, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.invincible.book_picker.label_ability_selection"), -77, -69, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_icon_viltrumite = new ImageButton(this.leftPos + -49, this.topPos + -44, 16, 16, 0, 0, 16, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_icon_viltrumite.png"), 16, 32, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new BookPickerButtonMessage(0, x, y, z));
				BookPickerButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_icon_viltrumite", imagebutton_icon_viltrumite);
		this.addRenderableWidget(imagebutton_icon_viltrumite);
		imagebutton_icon_human = new ImageButton(this.leftPos + -75, this.topPos + -43, 16, 16, 0, 0, 16, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_icon_human.png"), 16, 32, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new BookPickerButtonMessage(1, x, y, z));
				BookPickerButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_icon_human", imagebutton_icon_human);
		this.addRenderableWidget(imagebutton_icon_human);
		imagebutton_icon_speedster = new ImageButton(this.leftPos + -23, this.topPos + -44, 16, 16, 0, 0, 16, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_icon_speedster.png"), 16, 32, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new BookPickerButtonMessage(2, x, y, z));
				BookPickerButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_icon_speedster", imagebutton_icon_speedster);
		this.addRenderableWidget(imagebutton_icon_speedster);
		imagebutton_icon_spider = new ImageButton(this.leftPos + 4, this.topPos + -44, 16, 16, 0, 0, 16, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_icon_spider.png"), 16, 32, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new BookPickerButtonMessage(3, x, y, z));
				BookPickerButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_icon_spider", imagebutton_icon_spider);
		this.addRenderableWidget(imagebutton_icon_spider);
		imagebutton_icon_explode = new ImageButton(this.leftPos + 30, this.topPos + -44, 16, 16, 0, 0, 16, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_icon_explode.png"), 16, 32, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new BookPickerButtonMessage(4, x, y, z));
				BookPickerButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_icon_explode", imagebutton_icon_explode);
		this.addRenderableWidget(imagebutton_icon_explode);
		imagebutton_icon_cloning = new ImageButton(this.leftPos + 56, this.topPos + -44, 16, 16, 0, 0, 16, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_icon_cloning.png"), 16, 32, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new BookPickerButtonMessage(5, x, y, z));
				BookPickerButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_icon_cloning", imagebutton_icon_cloning);
		this.addRenderableWidget(imagebutton_icon_cloning);
		imagebutton_icon_portal = new ImageButton(this.leftPos + -75, this.topPos + -19, 16, 16, 0, 0, 16, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_icon_portal.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_icon_portal", imagebutton_icon_portal);
		this.addRenderableWidget(imagebutton_icon_portal);
	}
}
