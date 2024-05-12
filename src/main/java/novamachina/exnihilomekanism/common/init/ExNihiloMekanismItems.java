package novamachina.exnihilomekanism.common.init;

import com.mojang.logging.LogUtils;
import javax.annotation.Nonnull;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import novamachina.exnihilomekanism.common.utility.ExNihiloMekanismConstants;
import org.slf4j.Logger;

public class ExNihiloMekanismItems {

  private static final DeferredRegister<Item> ITEMS =
      DeferredRegister.create(BuiltInRegistries.ITEM, ExNihiloMekanismConstants.ModIds.EX_NIHILO_MEKANISM);
  public static final DeferredHolder<Item, Item> OSMIUM_PIECES =
      ITEMS.register(
          "osmium_pieces",
          () -> new Item(new Item.Properties()));
  @Nonnull private static final Logger logger = LogUtils.getLogger();

  public static void init(IEventBus modEventBus) {
    logger.debug("Register items");
    ITEMS.register(modEventBus);
  }
}
