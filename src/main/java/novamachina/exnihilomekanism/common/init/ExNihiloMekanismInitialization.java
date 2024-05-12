package novamachina.exnihilomekanism.common.init;

import com.mojang.logging.LogUtils;
import javax.annotation.Nonnull;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import novamachina.exnihilomekanism.common.utility.ExNihiloMekanismConstants;
import novamachina.exnihilosequentia.world.item.EXNCreativeModeTabs;
import novamachina.exnihilosequentia.world.item.EXNItems;
import novamachina.novacore.world.item.CreativeModeTabDefinition;
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

  public static void addToCreativeTab(BuildCreativeModeTabContentsEvent event) {
    logger.debug("Fired BuildCreativeModeTabContentsEvent");
	for (CreativeModeTabDefinition tab : EXNCreativeModeTabs.getDefinitions()) {
		if (event.getTab() == tab.tab()) {
			event.accept(ExNihiloMekanismItems.OSMIUM_PIECES.get());
		}
	}
  }

  public static void init(@Nonnull final IEventBus modEventBus) {
    logger.debug("Initializing modded items");
    ExNihiloMekanismItems.init(modEventBus);
	modEventBus.addListener(ExNihiloMekanismInitialization::addToCreativeTab);
  }

  private static void enableOres() {
    EXNItems.TIN.setEnabled(true);
    EXNItems.COPPER.setEnabled(true);
    EXNItems.URANIUM.setEnabled(true);
    EXNItems.LEAD.setEnabled(true);
  }
}
