
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

import net.mcreator.invincible.network.UseAbility5Message;
import net.mcreator.invincible.network.UseAbility4Message;
import net.mcreator.invincible.network.UseAbility3Message;
import net.mcreator.invincible.network.UseAbility2Message;
import net.mcreator.invincible.network.UseAbility1Message;
import net.mcreator.invincible.network.ToggleHeavyPunchMessage;
import net.mcreator.invincible.network.SwitchBarsMessage;
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
	public static final KeyMapping DASH = new KeyMapping("key.invincible.dash", GLFW.GLFW_KEY_LEFT_CONTROL, "key.categories.invincible") {
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
	public static final KeyMapping FOLLOW_UP = new KeyMapping("key.invincible.follow_up", GLFW.GLFW_KEY_R, "key.categories.invincible") {
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
	public static final KeyMapping GRAB = new KeyMapping("key.invincible.grab", GLFW.GLFW_KEY_G, "key.categories.invincible") {
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
	public static final KeyMapping USE_ABILITY_1 = new KeyMapping("key.invincible.use_ability_1", GLFW.GLFW_KEY_Z, "key.categories.invincible") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new UseAbility1Message(0, 0));
				UseAbility1Message.pressAction(Minecraft.getInstance().player, 0, 0);
				USE_ABILITY_1_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - USE_ABILITY_1_LASTPRESS);
				InvincibleMod.PACKET_HANDLER.sendToServer(new UseAbility1Message(1, dt));
				UseAbility1Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping USE_ABILITY_2 = new KeyMapping("key.invincible.use_ability_2", GLFW.GLFW_KEY_X, "key.categories.invincible") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new UseAbility2Message(0, 0));
				UseAbility2Message.pressAction(Minecraft.getInstance().player, 0, 0);
				USE_ABILITY_2_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - USE_ABILITY_2_LASTPRESS);
				InvincibleMod.PACKET_HANDLER.sendToServer(new UseAbility2Message(1, dt));
				UseAbility2Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping USE_ABILITY_3 = new KeyMapping("key.invincible.use_ability_3", GLFW.GLFW_KEY_C, "key.categories.invincible") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new UseAbility3Message(0, 0));
				UseAbility3Message.pressAction(Minecraft.getInstance().player, 0, 0);
				USE_ABILITY_3_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - USE_ABILITY_3_LASTPRESS);
				InvincibleMod.PACKET_HANDLER.sendToServer(new UseAbility3Message(1, dt));
				UseAbility3Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping USE_ABILITY_4 = new KeyMapping("key.invincible.use_ability_4", GLFW.GLFW_KEY_V, "key.categories.invincible") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new UseAbility4Message(0, 0));
				UseAbility4Message.pressAction(Minecraft.getInstance().player, 0, 0);
				USE_ABILITY_4_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - USE_ABILITY_4_LASTPRESS);
				InvincibleMod.PACKET_HANDLER.sendToServer(new UseAbility4Message(1, dt));
				UseAbility4Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping USE_ABILITY_5 = new KeyMapping("key.invincible.use_ability_5", GLFW.GLFW_KEY_B, "key.categories.invincible") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new UseAbility5Message(0, 0));
				UseAbility5Message.pressAction(Minecraft.getInstance().player, 0, 0);
				USE_ABILITY_5_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - USE_ABILITY_5_LASTPRESS);
				InvincibleMod.PACKET_HANDLER.sendToServer(new UseAbility5Message(1, dt));
				UseAbility5Message.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SWITCH_BARS = new KeyMapping("key.invincible.switch_bars", GLFW.GLFW_KEY_Y, "key.categories.invincible") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				InvincibleMod.PACKET_HANDLER.sendToServer(new SwitchBarsMessage(0, 0));
				SwitchBarsMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	private static long FLY_LASTPRESS = 0;
	private static long USE_ABILITY_1_LASTPRESS = 0;
	private static long USE_ABILITY_2_LASTPRESS = 0;
	private static long USE_ABILITY_3_LASTPRESS = 0;
	private static long USE_ABILITY_4_LASTPRESS = 0;
	private static long USE_ABILITY_5_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(FLY);
		event.register(DASH);
		event.register(FOLLOW_UP);
		event.register(TOGGLE_HEAVY_PUNCH);
		event.register(BURST);
		event.register(GRAB);
		event.register(USE_ABILITY_1);
		event.register(USE_ABILITY_2);
		event.register(USE_ABILITY_3);
		event.register(USE_ABILITY_4);
		event.register(USE_ABILITY_5);
		event.register(SWITCH_BARS);
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
				BURST.consumeClick();
				GRAB.consumeClick();
				USE_ABILITY_1.consumeClick();
				USE_ABILITY_2.consumeClick();
				USE_ABILITY_3.consumeClick();
				USE_ABILITY_4.consumeClick();
				USE_ABILITY_5.consumeClick();
				SWITCH_BARS.consumeClick();
			}
		}
	}
}
