package novamachina.exnihilomekanism;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import novamachina.exnihilomekanism.common.init.ExNihiloMekanismInitialization;
import novamachina.exnihilomekanism.common.utility.ExNihiloMekanismConstants;
import org.slf4j.Logger;

@Mod(ExNihiloMekanismConstants.ModIds.EX_NIHILO_MEKANISM)
public class ExNihiloMekanism {

  private static final Logger logger = LogUtils.getLogger();

  public ExNihiloMekanism(IEventBus eventBus) {
    logger.debug("Starting Ex Nihilo: Sequentia - Mekanism Addon");
    ExNihiloMekanismInitialization.init(eventBus);
  }
}
