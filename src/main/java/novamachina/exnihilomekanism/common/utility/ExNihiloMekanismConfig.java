package novamachina.exnihilomekanism.common.utility;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import java.nio.file.Path;
import net.neoforged.neoforge.common.ModConfigSpec;

public class ExNihiloMekanismConfig {

  public static final ModConfigSpec COMMON_CONFIG;
  private static final String CATEGORY_ORE = "ore";

  private static final ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();
  // Ore
  private static ModConfigSpec.BooleanValue enableOsmium;

  static {
    COMMON_BUILDER.comment("Compatibility Configs").push(CATEGORY_ORE);
    oreConfigs();
    COMMON_BUILDER.pop();

    COMMON_CONFIG = COMMON_BUILDER.build();
  }

  private ExNihiloMekanismConfig() {
  }

  public static boolean enableOsmium() {
    return enableOsmium.get();
  }

  private static void oreConfigs() {
    enableOsmium = COMMON_BUILDER.comment(
            "Enable osmium ore pieces, chunks and ingots if they exist. 'enableOreOverride' in the main Ex Nihilo config must be true for this to work. (Default: true)")
        .define("enableOsmium", true);
  }

  public static void loadConfig(ModConfigSpec spec, Path path) {
    final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave()
        .writingMode(WritingMode.REPLACE).build();

    configData.load();
    spec.setConfig(configData);
  }
}
