package mod.azure.wowweapons.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public interface IMultiType {

	public int getMaxTypes();
	public int getType(ItemStack variant);
}