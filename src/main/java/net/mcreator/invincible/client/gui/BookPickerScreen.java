package net.mcreator.invincible.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
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
	Button button_viltrumite;
	Button button_speedster;
	Button button_spider;

	public BookPickerScreen(BookPickerMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 150;
	}

	private static final ResourceLocation texture = new ResourceLocation("invincible:textures/screens/book_picker.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
	}

	@Override
	public void init() {
		super.init();
		button_viltrumite = Button.builder(Component.translatable("gui.invincible.book_picker.button_viltrumite"), e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new BookPickerButtonMessage(0, x, y, z));
				BookPickerButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 7, this.topPos + 7, 77, 20).build();
		guistate.put("button:button_viltrumite", button_viltrumite);
		this.addRenderableWidget(button_viltrumite);
		button_speedster = Button.builder(Component.translatable("gui.invincible.book_picker.button_speedster"), e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new BookPickerButtonMessage(1, x, y, z));
				BookPickerButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 7, this.topPos + 36, 72, 20).build();
		guistate.put("button:button_speedster", button_speedster);
		this.addRenderableWidget(button_speedster);
		button_spider = Button.builder(Component.translatable("gui.invincible.book_picker.button_spider"), e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new BookPickerButtonMessage(2, x, y, z));
				BookPickerButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 7, this.topPos + 66, 56, 20).build();
		guistate.put("button:button_spider", button_spider);
		this.addRenderableWidget(button_spider);
	}
}
