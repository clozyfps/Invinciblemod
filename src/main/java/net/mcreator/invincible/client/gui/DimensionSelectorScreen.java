package net.mcreator.invincible.client.gui;

public class DimensionSelectorScreen extends AbstractContainerScreen<DimensionSelectorMenu> {

	private final static HashMap<String, Object> guistate = DimensionSelectorMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	ImageButton imagebutton_blank;
	ImageButton imagebutton_blank1;
	ImageButton imagebutton_blank2;
	ImageButton imagebutton_blank3;
	ImageButton imagebutton_blank4;
	ImageButton imagebutton_blank5;
	ImageButton imagebutton_blank6;
	ImageButton imagebutton_blank7;

	public DimensionSelectorScreen(DimensionSelectorMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("invincible:textures/screens/dimension_selector.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);

		super.render(guiGraphics, mouseX, mouseY, partialTicks);

		this.renderTooltip(guiGraphics, mouseX, mouseY);

		if (mouseX > leftPos + -52 && mouseX < leftPos + -30 && mouseY > topPos + -47 && mouseY < topPos + -25)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible.dimension_selector.tooltip_overworld"), mouseX, mouseY);
		if (mouseX > leftPos + -78 && mouseX < leftPos + -56 && mouseY > topPos + -47 && mouseY < topPos + -25)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible.dimension_selector.tooltip_random"), mouseX, mouseY);
		if (mouseX > leftPos + -26 && mouseX < leftPos + -4 && mouseY > topPos + -47 && mouseY < topPos + -25)
			guiGraphics.renderTooltip(font, Component.literal(

					ReturnNameNetherProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + 1 && mouseX < leftPos + 23 && mouseY > topPos + -47 && mouseY < topPos + -25)
			guiGraphics.renderTooltip(font, Component.literal(

					ReturnNameEndProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + 27 && mouseX < leftPos + 49 && mouseY > topPos + -47 && mouseY < topPos + -25)
			guiGraphics.renderTooltip(font, Component.literal(

					ReturnNameApocalypticProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + 53 && mouseX < leftPos + 75 && mouseY > topPos + -47 && mouseY < topPos + -25)
			guiGraphics.renderTooltip(font, Component.literal(

					ReturnNameDesertProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + -78 && mouseX < leftPos + -56 && mouseY > topPos + -22 && mouseY < topPos + 0)
			guiGraphics.renderTooltip(font, Component.literal(

					ReturnNameSnowProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + -52 && mouseX < leftPos + -30 && mouseY > topPos + -22 && mouseY < topPos + 0)
			guiGraphics.renderTooltip(font, Component.literal(

					ReturnNameFlaxanProcedure.execute()), mouseX, mouseY);
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

		guiGraphics.blit(new ResourceLocation("invincible:textures/screens/slot.png"), this.leftPos + -52, this.topPos + -22, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(new ResourceLocation("invincible:textures/screens/icon_question.png"), this.leftPos + -75, this.topPos + -44, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("invincible:textures/screens/icon_portal.png"), this.leftPos + -49, this.topPos + -44, 0, 0, 16, 16, 16, 16);

		if (

		ReturnUnlockedNetherProcedure.execute()

		) {
			guiGraphics.blit(new ResourceLocation("invincible:textures/screens/icon_portal.png"), this.leftPos + -23, this.topPos + -44, 0, 0, 16, 16, 16, 16);
		}
		if (

		ReturnUnlockedEndProcedure.execute(entity)

		) {
			guiGraphics.blit(new ResourceLocation("invincible:textures/screens/icon_portal.png"), this.leftPos + 4, this.topPos + -44, 0, 0, 16, 16, 16, 16);
		}
		if (

		ReturnUnlockedApocalytpicProcedure.execute()

		) {
			guiGraphics.blit(new ResourceLocation("invincible:textures/screens/icon_portal.png"), this.leftPos + 30, this.topPos + -44, 0, 0, 16, 16, 16, 16);
		}
		if (

		ReturnUnlockedDesertProcedure.execute()

		) {
			guiGraphics.blit(new ResourceLocation("invincible:textures/screens/icon_portal.png"), this.leftPos + 56, this.topPos + -44, 0, 0, 16, 16, 16, 16);
		}
		if (

		ReturnUnlockedSnowProcedure.execute(entity)

		) {
			guiGraphics.blit(new ResourceLocation("invincible:textures/screens/icon_portal.png"), this.leftPos + -75, this.topPos + -19, 0, 0, 16, 16, 16, 16);
		}
		if (

		ReturnUnlockedFlaxanProcedure.execute()

		) {
			guiGraphics.blit(new ResourceLocation("invincible:textures/screens/icon_portal.png"), this.leftPos + -49, this.topPos + -19, 0, 0, 16, 16, 16, 16);
		}
		if (

		ReturnLockedNetherProcedure.execute(entity)

		) {
			guiGraphics.blit(new ResourceLocation("invincible:textures/screens/icon_question.png"), this.leftPos + -23, this.topPos + -44, 0, 0, 16, 16, 16, 16);
		}
		if (

		ReturnLockedEndProcedure.execute(entity)

		) {
			guiGraphics.blit(new ResourceLocation("invincible:textures/screens/icon_question.png"), this.leftPos + 4, this.topPos + -44, 0, 0, 16, 16, 16, 16);
		}
		if (

		ReturnLockedApocalypticProcedure.execute()

		) {
			guiGraphics.blit(new ResourceLocation("invincible:textures/screens/icon_question.png"), this.leftPos + 30, this.topPos + -44, 0, 0, 16, 16, 16, 16);
		}
		if (

		ReturnLockedDesertProcedure.execute(entity)

		) {
			guiGraphics.blit(new ResourceLocation("invincible:textures/screens/icon_question.png"), this.leftPos + 56, this.topPos + -44, 0, 0, 16, 16, 16, 16);
		}
		if (

		ReturnLockedSnowProcedure.execute(entity)

		) {
			guiGraphics.blit(new ResourceLocation("invincible:textures/screens/icon_question.png"), this.leftPos + -75, this.topPos + -19, 0, 0, 16, 16, 16, 16);
		}
		if (

		ReturnLockedFlaxanProcedure.execute()

		) {
			guiGraphics.blit(new ResourceLocation("invincible:textures/screens/icon_question.png"), this.leftPos + -49, this.topPos + -19, 0, 0, 16, 16, 16, 16);
		}

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
		guiGraphics.drawString(this.font, Component.translatable("gui.invincible.dimension_selector.label_ability_selection1"), -76, -68, -11252677, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.invincible.dimension_selector.label_ability_selection"), -77, -69, -1, false);
	}

	@Override
	public void init() {
		super.init();

		imagebutton_blank = new ImageButton(this.leftPos + -78, this.topPos + -47, 22, 22, 0, 0, 22, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_blank.png"), 22, 44, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new DimensionSelectorButtonMessage(0, x, y, z));
				DimensionSelectorButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});

		guistate.put("button:imagebutton_blank", imagebutton_blank);
		this.addRenderableWidget(imagebutton_blank);

		imagebutton_blank1 = new ImageButton(this.leftPos + -52, this.topPos + -47, 22, 22, 0, 0, 22, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_blank1.png"), 22, 44, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new DimensionSelectorButtonMessage(1, x, y, z));
				DimensionSelectorButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});

		guistate.put("button:imagebutton_blank1", imagebutton_blank1);
		this.addRenderableWidget(imagebutton_blank1);

		imagebutton_blank2 = new ImageButton(this.leftPos + -26, this.topPos + -47, 22, 22, 0, 0, 22, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_blank2.png"), 22, 44, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new DimensionSelectorButtonMessage(2, x, y, z));
				DimensionSelectorButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});

		guistate.put("button:imagebutton_blank2", imagebutton_blank2);
		this.addRenderableWidget(imagebutton_blank2);

		imagebutton_blank3 = new ImageButton(this.leftPos + 1, this.topPos + -47, 22, 22, 0, 0, 22, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_blank3.png"), 22, 44, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new DimensionSelectorButtonMessage(3, x, y, z));
				DimensionSelectorButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});

		guistate.put("button:imagebutton_blank3", imagebutton_blank3);
		this.addRenderableWidget(imagebutton_blank3);

		imagebutton_blank4 = new ImageButton(this.leftPos + 27, this.topPos + -47, 22, 22, 0, 0, 22, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_blank4.png"), 22, 44, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new DimensionSelectorButtonMessage(4, x, y, z));
				DimensionSelectorButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});

		guistate.put("button:imagebutton_blank4", imagebutton_blank4);
		this.addRenderableWidget(imagebutton_blank4);

		imagebutton_blank5 = new ImageButton(this.leftPos + 53, this.topPos + -47, 22, 22, 0, 0, 22, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_blank5.png"), 22, 44, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new DimensionSelectorButtonMessage(5, x, y, z));
				DimensionSelectorButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});

		guistate.put("button:imagebutton_blank5", imagebutton_blank5);
		this.addRenderableWidget(imagebutton_blank5);

		imagebutton_blank6 = new ImageButton(this.leftPos + -78, this.topPos + -22, 22, 22, 0, 0, 22, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_blank6.png"), 22, 44, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new DimensionSelectorButtonMessage(6, x, y, z));
				DimensionSelectorButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});

		guistate.put("button:imagebutton_blank6", imagebutton_blank6);
		this.addRenderableWidget(imagebutton_blank6);

		imagebutton_blank7 = new ImageButton(this.leftPos + -52, this.topPos + -22, 22, 22, 0, 0, 22, new ResourceLocation("invincible:textures/screens/atlas/imagebutton_blank7.png"), 22, 44, e -> {
			if (true) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new DimensionSelectorButtonMessage(7, x, y, z));
				DimensionSelectorButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});

		guistate.put("button:imagebutton_blank7", imagebutton_blank7);
		this.addRenderableWidget(imagebutton_blank7);

	}

}
