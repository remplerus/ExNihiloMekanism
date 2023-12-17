package novamachina.exnihilomekanism.common.init;

import com.mojang.logging.LogUtils;
import javax.annotation.Nonnull;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import novamachina.exnihilomekanism.common.utility.ExNihiloMekanismConstants;
import org.slf4j.Logger;

public class ExNihiloMekanismItems {

  private static final DeferredRegister<Item> ITEMS =
      DeferredRegister.create(
          ForgeRegistries.ITEMS, ExNihiloMekanismConstants.ModIds.EX_NIHILO_MEKANISM);
  public static final RegistryObject<Item> OSMIUM_PIECES =
      ITEMS.register(
          "osmium_pieces",
          () -> new Item(new Item.Properties()));
  @Nonnull private static final Logger logger = LogUtils.getLogger();

  public static void init(IEventBus modEventBus) {
    logger.debug("Register items");
    ITEMS.register(modEventBus);
  }
}
