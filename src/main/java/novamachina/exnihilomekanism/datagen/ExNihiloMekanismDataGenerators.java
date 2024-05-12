package novamachina.exnihilomekanism.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import novamachina.exnihilomekanism.datagen.client.ExNihiloMekanismLangGenerator;
import novamachina.exnihilomekanism.datagen.client.ExNihiloMekanismOreItemGenerator;
import novamachina.exnihilomekanism.datagen.common.ExNihiloMekanismItemTagGenerator;
import novamachina.exnihilomekanism.datagen.common.ExNihiloMekanismRecipeGenerator;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExNihiloMekanismDataGenerators {

  private ExNihiloMekanismDataGenerators() {}

  @SubscribeEvent
  public static void gatherData(GatherDataEvent event) {
    DataGenerator generator = event.getGenerator();
    PackOutput packoutput = generator.getPackOutput();
	CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

    if (event.includeServer()) {
      // Recipes
      generator.addProvider(true, new ExNihiloMekanismRecipeGenerator(packoutput));
      // Tags
      generator.addProvider(true, new ExNihiloMekanismItemTagGenerator(packoutput, lookupProvider, event.getExistingFileHelper()));
    }
    if (event.includeClient()) {
	  // Models
      generator.addProvider(true, new ExNihiloMekanismOreItemGenerator(packoutput, event.getExistingFileHelper()));
	  // Lang
	  generator.addProvider(true, new ExNihiloMekanismLangGenerator(packoutput, "en_us"));
    }
  }
}
