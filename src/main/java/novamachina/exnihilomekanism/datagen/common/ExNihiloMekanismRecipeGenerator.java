package novamachina.exnihilomekanism.datagen.common;

import java.util.Objects;
import java.util.function.Consumer;
import javax.annotation.Nullable;

import mekanism.common.registries.MekanismBlocks;
import mekanism.common.registries.MekanismItems;
import mekanism.common.resource.PrimaryResource;
import mekanism.common.resource.ResourceType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import novamachina.exnihilomekanism.common.init.ExNihiloMekanismItems;
import novamachina.exnihilomekanism.common.utility.ExNihiloMekanismConstants.ModIds;
import novamachina.exnihilosequentia.common.utility.ExNihiloConstants;
import novamachina.exnihilosequentia.data.recipes.HeatRecipeBuilder;
import novamachina.exnihilosequentia.data.recipes.RecipeProviderUtilities;
import novamachina.exnihilosequentia.data.recipes.SiftingRecipeBuilder;
import novamachina.exnihilosequentia.world.item.MeshType;
import novamachina.exnihilosequentia.world.item.crafting.MeshWithChance;
import novamachina.novacore.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;

import static novamachina.exnihilosequentia.data.recipes.RecipeProviderUtilities.prependRecipePrefix;

public class ExNihiloMekanismRecipeGenerator extends RecipeProvider {

  public ExNihiloMekanismRecipeGenerator(PackOutput generator, ExistingFileHelper helper) {
    super(generator, helper, ModIds.EX_NIHILO_MEKANISM);
  }

  @Override
  protected void addRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
    registerCrafting(consumer);
    registerSieve(consumer);
	registerHeat(consumer);
  }

	private void registerHeat(Consumer<FinishedRecipe> consumer) {
		HeatRecipeBuilder.heat(MekanismBlocks.SUPERHEATING_ELEMENT.getBlock(), 10)
			.build(consumer, heatLoc("superheating_element"));
	}

	private void registerCrafting(Consumer<FinishedRecipe> consumer) {
    Item item = ExNihiloMekanismItems.OSMIUM_PIECES.get();
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Objects.requireNonNull(MekanismItems.PROCESSED_RESOURCES.get(ResourceType.RAW, PrimaryResource.OSMIUM)))
        .pattern("xx")
        .pattern("xx")
        .define('x', item)
        .unlockedBy("has_piece", InventoryChangeTrigger.TriggerInstance.hasItems(item))
        .save(consumer, new ResourceLocation(ModIds.EX_NIHILO_MEKANISM,
                prependRecipePrefix(ForgeRegistries.ITEMS.getKey(item).getPath())));
  }

  private void registerSieve(Consumer<FinishedRecipe> consumer) {
	SiftingRecipeBuilder.sifting(Ingredient.of(Blocks.GRAVEL), ExNihiloMekanismItems.OSMIUM_PIECES.get())
		.addRoll(new MeshWithChance(MeshType.IRON, 0.05F))
		.addRoll(new MeshWithChance(MeshType.DIAMOND, 0.1F))
		.build(consumer, siftingLoc("osmium_pieces"));

	SiftingRecipeBuilder.sifting(Ingredient.of(Blocks.GRAVEL), MekanismItems.FLUORITE_GEM.asItem())
	  .addRoll(new MeshWithChance(MeshType.IRON, 0.025F))
	  .addRoll(new MeshWithChance(MeshType.DIAMOND, 0.05F))
	  .build(consumer, siftingLoc(MekanismItems.FLUORITE_GEM.getRegistryName().getPath()));

	SiftingRecipeBuilder.sifting(Ingredient.of(Blocks.SAND), MekanismItems.SALT.asItem())
	  .addRoll(new MeshWithChance(MeshType.FLINT, 0.01F))
	  .addRoll(new MeshWithChance(MeshType.IRON, 0.02F))
	  .addRoll(new MeshWithChance(MeshType.DIAMOND, 0.4F))
	  .build(consumer, siftingLoc(MekanismItems.SALT.getRegistryName().getPath()));
  }

	private ResourceLocation siftingLoc(String id) {
		return new ResourceLocation(ModIds.EX_NIHILO_MEKANISM, "sifting/" + RecipeProviderUtilities.prependRecipePrefix(id));
	}
	private ResourceLocation heatLoc(String id) {
		return new ResourceLocation(ModIds.EX_NIHILO_MEKANISM, "heat/" + RecipeProviderUtilities.prependRecipePrefix(id));
	}
}
