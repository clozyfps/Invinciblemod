
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.invincible.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.invincible.network.ToggleHeavyPunchMessage;
import net.mcreator.invincible.network.GrabMessage;
import net.mcreator.invincible.network.FollowUpMessage;
import net.mcreator.invincible.network.FlyMessage;
import net.mcreator.invincible.network.DashMessage;
import net.mcreator.invincible.network.BurstMessage;
import net.mcreator.invincible.InvincibleMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class InvincibleModKeyMappings {
	public static final KeyMapping FLY = new KeyMapping("key.invincible.fly", GLFW.GLFW_KEY_N, "key.categories.invincible") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new FlyMessage(0, 0));
				FlyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				FLY_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - FLY_LASTPRESS);
				InvincibleMod.PACKET_HANDLER.sendToServer(new FlyMessage(1, dt));
				FlyMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping DASH = new KeyMapping("key.invincible.dash", GLFW.GLFW_KEY_B, "key.categories.invincible") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new DashMessage(0, 0));
				DashMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FOLLOW_UP = new KeyMapping("key.invincible.follow_up", GLFW.GLFW_KEY_X, "key.categories.invincible") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new FollowUpMessage(0, 0));
				FollowUpMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping TOGGLE_HEAVY_PUNCH = new KeyMapping("key.invincible.toggle_heavy_punch", GLFW.GLFW_KEY_M, "key.categories.invincible") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new ToggleHeavyPunchMessage(0, 0));
				ToggleHeavyPunchMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SWITCH_MOVES = new KeyMapping("key.invincible.switch_moves", GLFW.GLFW_KEY_R, "key.categories.invincible") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new SwitchMovesMessage(0, 0));
				SwitchMovesMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping USE_MOVES = new KeyMapping("key.invincible.use_moves", GLFW.GLFW_KEY_F, "key.categories.invincible") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new UseMovesMessage(0, 0));
				UseMovesMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping BURST = new KeyMapping("key.invincible.burst", GLFW.GLFW_KEY_H, "key.categories.invincible") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new BurstMessage(0, 0));
				BurstMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping GRAB = new KeyMapping("key.invincible.grab", GLFW.GLFW_KEY_V, "key.categories.invincible") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new GrabMessage(0, 0));
				GrabMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	private static long FLY_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(FLY);
		event.register(DASH);
		event.register(FOLLOW_UP);
		event.register(TOGGLE_HEAVY_PUNCH);
		event.register(SWITCH_MOVES);
		event.register(USE_MOVES);
		event.register(BURST);
		event.register(GRAB);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				FLY.consumeClick();
				DASH.consumeClick();
				FOLLOW_UP.consumeClick();
				TOGGLE_HEAVY_PUNCH.consumeClick();
				SWITCH_MOVES.consumeClick();
				USE_MOVES.consumeClick();
				BURST.consumeClick();
				GRAB.consumeClick();
			}
		}
	}
}
