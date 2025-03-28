package net.mcreator.invincible.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ViltrumiteFemaleOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ViltrumiteEntity _datEntSetI)
			_datEntSetI.getEntityData().set(ViltrumiteEntity.DATA_malevilapp, Mth.nextInt(RandomSource.create(), 1, 5));
		if ((entity instanceof ViltrumiteEntity _datEntI ? _datEntI.getEntityData().get(ViltrumiteEntity.DATA_malevilapp) : 0) == 1) {
			if (entity instanceof ViltrumiteFemaleEntity animatable)
				animatable.setTexture("viltrumite_female_black");
		} else if ((entity instanceof ViltrumiteEntity _datEntI ? _datEntI.getEntityData().get(ViltrumiteEntity.DATA_malevilapp) : 0) == 2) {
			if (entity instanceof ViltrumiteFemaleEntity animatable)
				animatable.setTexture("viltrumite_female_blonde");
		} else if ((entity instanceof ViltrumiteEntity _datEntI ? _datEntI.getEntityData().get(ViltrumiteEntity.DATA_malevilapp) : 0) == 3) {
			if (entity instanceof ViltrumiteFemaleEntity animatable)
				animatable.setTexture("viltrumite_female_brown");
		} else if ((entity instanceof ViltrumiteEntity _datEntI ? _datEntI.getEntityData().get(ViltrumiteEntity.DATA_malevilapp) : 0) == 4) {
			if (entity instanceof ViltrumiteFemaleEntity animatable)
				animatable.setTexture("viltrumite_female_gray");
		} else if ((entity instanceof ViltrumiteEntity _datEntI ? _datEntI.getEntityData().get(ViltrumiteEntity.DATA_malevilapp) : 0) == 5) {
			if (entity instanceof ViltrumiteFemaleEntity animatable)
				animatable.setTexture("viltrumite_female_white");
		}
		if (entity instanceof LivingEntity _entity)
			_entity.setHealth((float) (100 + Mth.nextInt(RandomSource.create(), 1, 400)));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 999999, (int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / 50), false, false));
	}
}
