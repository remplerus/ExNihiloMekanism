package novamachina.exnihilomekanism;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import novamachina.exnihilomekanism.common.init.ExNihiloMekanismInitialization;
import novamachina.exnihilomekanism.common.utility.ExNihiloMekanismConstants;
import org.slf4j.Logger;

@Mod(ExNihiloMekanismConstants.ModIds.EX_NIHILO_MEKANISM)
public class ExNihiloMekanism {

  private static final Logger logger = LogUtils.getLogger();

  public ExNihiloMekanism() {
    logger.debug("Starting Ex Nihilo: Sequentia - Mekanism Addon");
    ExNihiloMekanismInitialization.init(FMLJavaModLoadingContext.get().getModEventBus());
  }
}
