package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ExplodeSelfProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity
) {
if(
entity == null
) return ;
if (==1) {if (world instanceof Level _level && !_level.isClientSide())
_level.explode(null, x, y, z, 50, Level.ExplosionInteraction.BLOCK);if (world instanceof ServerLevel _level)
_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.EXPLODE.get()), x, y, z, 100, 5, 5, 5, 0);if (world instanceof ServerLevel _level)
_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.DELETED_MOD_ELEMENT.get()), x, y, z, 25, 5, 5, 5, 0);if (world instanceof ServerLevel _level)
_level.sendParticles((SimpleParticleType) (InvincibleModParticleTypes.SHOCKWAVE_BIG.get()), x, y, z, 1, 0.1, 0.1, 0.1, 0);{
final Vec3 _center = new Vec3(x, y, z);
List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true)
.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
for (Entity entityiterator : _entfound) {
if (new Object(){
public boolean checkGamemode(Entity _ent){
if(_ent instanceof ServerPlayer _serverPlayer) {
return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
} else if(_ent.level().isClientSide() && _ent instanceof Player _player) {
return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
}
return false;
}
}.checkGamemode(entityiterator)&&entityiterator instanceof Player) {if (==1) {entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_EXPLOSION), entity), 50);}}else{entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_EXPLOSION), entity), 300);}
}
}entity.getPersistentData().putDouble("rexSPLODE", 0);}
}
}
