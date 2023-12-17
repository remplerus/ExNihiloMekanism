package novamachina.exnihilomekanism.datagen.client;

import javax.annotation.Nullable;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import novamachina.exnihilomekanism.common.init.ExNihiloMekanismItems;
import novamachina.exnihilomekanism.common.utility.ExNihiloMekanismConstants;

public class ExNihiloMekanismOreItemGenerator extends ItemModelProvider {

  private static final String ITEM_GENERATED_TAG = "item/generated";
  private static final String LAYER_0_TAG = "layer0";

  public ExNihiloMekanismOreItemGenerator(
	  PackOutput generator, ExistingFileHelper existingFileHelper) {
    super(generator, ExNihiloMekanismConstants.ModIds.EX_NIHILO_MEKANISM, existingFileHelper);
  }

  @Override
  protected void registerModels() {
    @Nullable
    final ResourceLocation resourceLocation =
        ForgeRegistries.ITEMS.getKey(ExNihiloMekanismItems.OSMIUM_PIECES.get());
    if (resourceLocation == null) {
      return;
    }
    singleTexture(
        resourceLocation.getPath(),
        new ResourceLocation(ITEM_GENERATED_TAG),
        LAYER_0_TAG,
        new ResourceLocation(modid, "item/ore/piece/" + resourceLocation.getPath()));
  }
}
