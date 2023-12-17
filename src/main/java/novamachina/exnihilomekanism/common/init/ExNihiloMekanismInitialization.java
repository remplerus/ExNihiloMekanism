package novamachina.exnihilomekanism.common.init;

import com.mojang.logging.LogUtils;
import javax.annotation.Nonnull;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import novamachina.exnihilomekanism.common.utility.ExNihiloMekanismConstants;
import novamachina.exnihilosequentia.world.item.EXNItems;
import org.slf4j.Logger;

@Mod.EventBusSubscriber(
    modid = ExNihiloMekanismConstants.ModIds.EX_NIHILO_MEKANISM,
    bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ExNihiloMekanismInitialization {

  private static final Logger logger = LogUtils.getLogger();

  private ExNihiloMekanismInitialization() {}

  @SubscribeEvent
  public static void onServerStart(ServerStartingEvent event) {
    logger.debug("Fired ServerStartingEvent");
    enableOres();
  }

  public static void init(@Nonnull final IEventBus modEventBus) {
    logger.debug("Initializing modded items");
    ExNihiloMekanismItems.init(modEventBus);
  }

  private static void enableOres() {
    EXNItems.TIN.setEnabled(true);
    EXNItems.COPPER.setEnabled(true);
    EXNItems.URANIUM.setEnabled(true);
    EXNItems.LEAD.setEnabled(true);
  }
}
