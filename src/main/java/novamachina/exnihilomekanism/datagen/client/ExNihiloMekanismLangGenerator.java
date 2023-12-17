package novamachina.exnihilomekanism.datagen.client;

import net.minecraft.data.PackOutput;
import novamachina.exnihilomekanism.common.utility.ExNihiloMekanismConstants.ModIds;
import novamachina.novacore.data.AbstractLangGenerator;

public class ExNihiloMekanismLangGenerator extends AbstractLangGenerator {

  public ExNihiloMekanismLangGenerator(PackOutput gen, String locale) {
    super(gen, ModIds.EX_NIHILO_MEKANISM, locale);
  }

  @Override
  protected void addTranslations() {
    // Items
    addItem();
  }

  private void addItem() {
    addPieceAutoName("osmium");
  }
}
