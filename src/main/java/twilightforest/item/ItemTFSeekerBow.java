package twilightforest.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.BowItem;
import twilightforest.entity.TFEntities;
import twilightforest.entity.projectile.EntitySeekerArrow;

public class ItemTFSeekerBow extends BowItem {

	public ItemTFSeekerBow(Properties props) {
		super(props);
	}

	@Override
	public AbstractArrowEntity customArrow(AbstractArrowEntity arrow) {
		if (arrow.func_234616_v_() instanceof LivingEntity) {
			return new EntitySeekerArrow(TFEntities.seeker_arrow, arrow.world, (LivingEntity) arrow.func_234616_v_());
		}
		return arrow;
	}
}
