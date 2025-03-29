package net.mcreator.invincible.network;

import software.bernie.geckolib.core.object.Color;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
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
		InvincibleMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
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
			clone.AbilityBar = original.AbilityBar;
			clone.DimensionList = original.DimensionList;
			if (!event.isWasDeath()) {
				clone.Flying = original.Flying;
				clone.SelectedTitle = original.SelectedTitle;
				clone.KeyHeld = original.KeyHeld;
				clone.InputDelay = original.InputDelay;
				clone.Cooldown1 = original.Cooldown1;
				clone.Cooldown2 = original.Cooldown2;
				clone.Cooldown3 = original.Cooldown3;
				clone.Cooldown4 = original.Cooldown4;
				clone.Cooldown5 = original.Cooldown5;
				clone.Cooldown6 = original.Cooldown6;
				clone.Cooldown7 = original.Cooldown7;
				clone.Cooldown8 = original.Cooldown8;
				clone.Cooldown9 = original.Cooldown9;
				clone.Cooldown10 = original.Cooldown10;
				clone.DashCooldown = original.DashCooldown;
			}
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					InvincibleMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					InvincibleMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					InvincibleMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "invincible_worldvars";
		public double EventTimer = 0;
		public String Event = "\"\"";
		public double EventX = 0;
		public double EventY = 0;
		public double EventZ = 0;

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			EventTimer = nbt.getDouble("EventTimer");
			Event = nbt.getString("Event");
			EventX = nbt.getDouble("EventX");
			EventY = nbt.getDouble("EventY");
			EventZ = nbt.getDouble("EventZ");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("EventTimer", EventTimer);
			nbt.putString("Event", Event);
			nbt.putDouble("EventX", EventX);
			nbt.putDouble("EventY", EventY);
			nbt.putDouble("EventZ", EventZ);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				InvincibleMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "invincible_mapvars";
		public boolean DaylightChanged = false;
		public boolean FireDamageChanged = false;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			if (nbt == null) {
				nbt = save(new CompoundTag());
			}
			DaylightChanged = nbt.getBoolean("DaylightChanged");
			FireDamageChanged = nbt.getBoolean("FireDamageChanged");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putBoolean("DaylightChanged", DaylightChanged);
			nbt.putBoolean("FireDamageChanged", FireDamageChanged);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				InvincibleMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
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
		public double MaximumMoves = 3.0;
		public double AbilityBar = 1.0;
		public boolean KeyHeld = false;
		public double InputDelay = 0.0;
		public double Cooldown1 = 0.0;
		public double Cooldown2 = 0.0;
		public double Cooldown3 = 0.0;
		public double Cooldown4 = 0.0;
		public double Cooldown5 = 0.0;
		public double Cooldown6 = 0.0;
		public double Cooldown7 = 0.0;
		public double Cooldown8 = 0.0;
		public double Cooldown9 = 0.0;
		public double Cooldown10 = 0.0;
		public double DashCooldown = 0.0;
		public String DimensionList = "\"\"";

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
			nbt.putDouble("AbilityBar", AbilityBar);
			nbt.putBoolean("KeyHeld", KeyHeld);
			nbt.putDouble("InputDelay", InputDelay);
			nbt.putDouble("Cooldown1", Cooldown1);
			nbt.putDouble("Cooldown2", Cooldown2);
			nbt.putDouble("Cooldown3", Cooldown3);
			nbt.putDouble("Cooldown4", Cooldown4);
			nbt.putDouble("Cooldown5", Cooldown5);
			nbt.putDouble("Cooldown6", Cooldown6);
			nbt.putDouble("Cooldown7", Cooldown7);
			nbt.putDouble("Cooldown8", Cooldown8);
			nbt.putDouble("Cooldown9", Cooldown9);
			nbt.putDouble("Cooldown10", Cooldown10);
			nbt.putDouble("DashCooldown", DashCooldown);
			nbt.putString("DimensionList", DimensionList);
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
			AbilityBar = nbt.getDouble("AbilityBar");
			KeyHeld = nbt.getBoolean("KeyHeld");
			InputDelay = nbt.getDouble("InputDelay");
			Cooldown1 = nbt.getDouble("Cooldown1");
			Cooldown2 = nbt.getDouble("Cooldown2");
			Cooldown3 = nbt.getDouble("Cooldown3");
			Cooldown4 = nbt.getDouble("Cooldown4");
			Cooldown5 = nbt.getDouble("Cooldown5");
			Cooldown6 = nbt.getDouble("Cooldown6");
			Cooldown7 = nbt.getDouble("Cooldown7");
			Cooldown8 = nbt.getDouble("Cooldown8");
			Cooldown9 = nbt.getDouble("Cooldown9");
			Cooldown10 = nbt.getDouble("Cooldown10");
			DashCooldown = nbt.getDouble("DashCooldown");
			DimensionList = nbt.getString("DimensionList");
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
					variables.AbilityBar = message.data.AbilityBar;
					variables.KeyHeld = message.data.KeyHeld;
					variables.InputDelay = message.data.InputDelay;
					variables.Cooldown1 = message.data.Cooldown1;
					variables.Cooldown2 = message.data.Cooldown2;
					variables.Cooldown3 = message.data.Cooldown3;
					variables.Cooldown4 = message.data.Cooldown4;
					variables.Cooldown5 = message.data.Cooldown5;
					variables.Cooldown6 = message.data.Cooldown6;
					variables.Cooldown7 = message.data.Cooldown7;
					variables.Cooldown8 = message.data.Cooldown8;
					variables.Cooldown9 = message.data.Cooldown9;
					variables.Cooldown10 = message.data.Cooldown10;
					variables.DashCooldown = message.data.DashCooldown;
					variables.DimensionList = message.data.DimensionList;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
