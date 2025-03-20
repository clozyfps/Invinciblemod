package net.mcreator.invincible.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.invincible.InvincibleMod;

import java.util.function.Supplier;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class InvincibleModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		InvincibleMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.Race = original.Race;
			clone.Defense = original.Defense;
			clone.Power = original.Power;
			clone.Age = original.Age;
			clone.AgeTimer = original.AgeTimer;
			clone.PowerExp = original.PowerExp;
			clone.PowerEXPCap = original.PowerEXPCap;
			clone.Strength = original.Strength;
			clone.Health = original.Health;
			clone.Agility = original.Agility;
			clone.Punches = original.Punches;
			clone.ToggleSpecial = original.ToggleSpecial;
			clone.FollowUpCharges = original.FollowUpCharges;
			clone.FollowUpChargeTimer = original.FollowUpChargeTimer;
			clone.MoveSelected = original.MoveSelected;
			clone.SelectedNumber = original.SelectedNumber;
			clone.AverageDamage = original.AverageDamage;
			clone.JoinedWorld = original.JoinedWorld;
			clone.SprintCheck = original.SprintCheck;
			clone.Color = original.Color;
			clone.WebX = original.WebX;
			clone.WebZ = original.WebZ;
			clone.WebY = original.WebY;
			clone.WebN = original.WebN;
			clone.VerticalMovement = original.VerticalMovement;
			clone.MaximumMoves = original.MaximumMoves;
			if (!event.isWasDeath()) {
				clone.Flying = original.Flying;
				clone.SelectedTitle = original.SelectedTitle;
			}
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("invincible", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public String Race = "";
		public double Defense = 0;
		public boolean Flying = false;
		public double Power = 0.0;
		public String SelectedTitle = "";
		public double Age = 10.0;
		public double AgeTimer = 0;
		public double PowerExp = 0;
		public double PowerEXPCap = 10.0;
		public double Strength = 0;
		public double Health = 0;
		public double Agility = 0;
		public double Punches = 0;
		public boolean ToggleSpecial = false;
		public double FollowUpCharges = 3.0;
		public double FollowUpChargeTimer = 0;
		public String MoveSelected = "";
		public double SelectedNumber = 1.0;
		public double AverageDamage = 0;
		public boolean JoinedWorld = false;
		public boolean SprintCheck = false;
		public String Color = "\"\"";
		public double WebX = 0;
		public double WebZ = 0;
		public double WebY = 0;
		public double WebN = 0;
		public double VerticalMovement = 0;
		public double MaximumMoves = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				InvincibleMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(entity.level()::dimension), new PlayerVariablesSyncMessage(this, entity.getId()));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("Race", Race);
			nbt.putDouble("Defense", Defense);
			nbt.putBoolean("Flying", Flying);
			nbt.putDouble("Power", Power);
			nbt.putString("SelectedTitle", SelectedTitle);
			nbt.putDouble("Age", Age);
			nbt.putDouble("AgeTimer", AgeTimer);
			nbt.putDouble("PowerExp", PowerExp);
			nbt.putDouble("PowerEXPCap", PowerEXPCap);
			nbt.putDouble("Strength", Strength);
			nbt.putDouble("Health", Health);
			nbt.putDouble("Agility", Agility);
			nbt.putDouble("Punches", Punches);
			nbt.putBoolean("ToggleSpecial", ToggleSpecial);
			nbt.putDouble("FollowUpCharges", FollowUpCharges);
			nbt.putDouble("FollowUpChargeTimer", FollowUpChargeTimer);
			nbt.putString("MoveSelected", MoveSelected);
			nbt.putDouble("SelectedNumber", SelectedNumber);
			nbt.putDouble("AverageDamage", AverageDamage);
			nbt.putBoolean("JoinedWorld", JoinedWorld);
			nbt.putBoolean("SprintCheck", SprintCheck);
			nbt.putString("Color", Color);
			nbt.putDouble("WebX", WebX);
			nbt.putDouble("WebZ", WebZ);
			nbt.putDouble("WebY", WebY);
			nbt.putDouble("WebN", WebN);
			nbt.putDouble("VerticalMovement", VerticalMovement);
			nbt.putDouble("MaximumMoves", MaximumMoves);
			return nbt;
		}

		public void readNBT(Tag tag) {
			if (tag == null) {
				tag = writeNBT();
			}
			CompoundTag nbt = (CompoundTag) tag;
			if (nbt == null) {
				nbt = (CompoundTag) writeNBT();
			}
			Race = nbt.getString("Race");
			Defense = nbt.getDouble("Defense");
			Flying = nbt.getBoolean("Flying");
			Power = nbt.getDouble("Power");
			SelectedTitle = nbt.getString("SelectedTitle");
			Age = nbt.getDouble("Age");
			AgeTimer = nbt.getDouble("AgeTimer");
			PowerExp = nbt.getDouble("PowerExp");
			PowerEXPCap = nbt.getDouble("PowerEXPCap");
			Strength = nbt.getDouble("Strength");
			Health = nbt.getDouble("Health");
			Agility = nbt.getDouble("Agility");
			Punches = nbt.getDouble("Punches");
			ToggleSpecial = nbt.getBoolean("ToggleSpecial");
			FollowUpCharges = nbt.getDouble("FollowUpCharges");
			FollowUpChargeTimer = nbt.getDouble("FollowUpChargeTimer");
			MoveSelected = nbt.getString("MoveSelected");
			SelectedNumber = nbt.getDouble("SelectedNumber");
			AverageDamage = nbt.getDouble("AverageDamage");
			JoinedWorld = nbt.getBoolean("JoinedWorld");
			SprintCheck = nbt.getBoolean("SprintCheck");
			Color = nbt.getString("Color");
			WebX = nbt.getDouble("WebX");
			WebZ = nbt.getDouble("WebZ");
			WebY = nbt.getDouble("WebY");
			WebN = nbt.getDouble("WebN");
			VerticalMovement = nbt.getDouble("VerticalMovement");
			MaximumMoves = nbt.getDouble("MaximumMoves");
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		InvincibleMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	public static class PlayerVariablesSyncMessage {
		private final int target;
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
			this.target = buffer.readInt();
		}

		public PlayerVariablesSyncMessage(PlayerVariables data, int entityid) {
			this.data = data;
			this.target = entityid;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
			buffer.writeInt(message.target);
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.level().getEntity(message.target).getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.Race = message.data.Race;
					variables.Defense = message.data.Defense;
					variables.Flying = message.data.Flying;
					variables.Power = message.data.Power;
					variables.SelectedTitle = message.data.SelectedTitle;
					variables.Age = message.data.Age;
					variables.AgeTimer = message.data.AgeTimer;
					variables.PowerExp = message.data.PowerExp;
					variables.PowerEXPCap = message.data.PowerEXPCap;
					variables.Strength = message.data.Strength;
					variables.Health = message.data.Health;
					variables.Agility = message.data.Agility;
					variables.Punches = message.data.Punches;
					variables.ToggleSpecial = message.data.ToggleSpecial;
					variables.FollowUpCharges = message.data.FollowUpCharges;
					variables.FollowUpChargeTimer = message.data.FollowUpChargeTimer;
					variables.MoveSelected = message.data.MoveSelected;
					variables.SelectedNumber = message.data.SelectedNumber;
					variables.AverageDamage = message.data.AverageDamage;
					variables.JoinedWorld = message.data.JoinedWorld;
					variables.SprintCheck = message.data.SprintCheck;
					variables.Color = message.data.Color;
					variables.WebX = message.data.WebX;
					variables.WebZ = message.data.WebZ;
					variables.WebY = message.data.WebY;
					variables.WebN = message.data.WebN;
					variables.VerticalMovement = message.data.VerticalMovement;
					variables.MaximumMoves = message.data.MaximumMoves;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
