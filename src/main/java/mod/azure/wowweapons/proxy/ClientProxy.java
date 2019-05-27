package mod.azure.wowweapons.proxy;

import mod.azure.wowweapons.IMultiType;
import mod.azure.wowweapons.WoWWeaponsMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	
	@EventHandler
	public void preInit()
    {
		OBJLoader.INSTANCE.addDomain(WoWWeaponsMod.modid);
    }
	
	@EventHandler
	public void init() {
		
	}
	
	@EventHandler
	public void postInit() {
		
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		for (ItemStack variant : variantList) {
			Item item = variant.getItem();
			ModelLoader.setCustomModelResourceLocation(item, variant.getItemDamage(), new ModelResourceLocation(item.getRegistryName(), String.format("type=%d", ((IMultiType) item).getType(variant))));
		}
	}
}
