
package net.mcreator.invincible.item;

public class TutorialItem extends Item {
	public TutorialItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		TutorialRightclickedProcedure.execute();
		return ar;
	}
}