package net.aurora_spirit.oceans_evolved.worldgen;

import net.aurora_spirit.oceans_evolved.OceansEvolved;
import net.aurora_spirit.oceans_evolved.block.ModBlocks;
import net.aurora_spirit.oceans_evolved.util.ModTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEASHELL_PILE_SAND_KEY = registerKey("seashell_pile_sand");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEASHELL_PILE_GRAVEL_KEY = registerKey("seashell_pile_gravel");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest sandReplaceable = new TagMatchTest(BlockTags.SAND);
        RuleTest gravelReplaceable = new TagMatchTest(ModTags.Blocks.GRAVEL);

        /*List<OreConfiguration.TargetBlockState> seashellPiles = List.of(OreConfiguration.target(sandReplaceable,
                        ModBlocks.SEASHELL_PILE_SAND.get().defaultBlockState()),
                OreConfiguration.target(gravelReplaceable, ModBlocks.SEASHELL_PILE_GRAVEL.get().defaultBlockState()));*/

        register(context, SEASHELL_PILE_SAND_KEY, Feature.DISK,
                new DiskConfiguration(RuleBasedBlockStateProvider.simple(ModBlocks.SEASHELL_PILE_SAND.get()), BlockPredicate.matchesBlocks(List.of(Blocks.SAND)), UniformInt.of(0, 1), 1));

        register(context, SEASHELL_PILE_GRAVEL_KEY, Feature.DISK,
                new DiskConfiguration(RuleBasedBlockStateProvider.simple(ModBlocks.SEASHELL_PILE_GRAVEL.get()), BlockPredicate.matchesBlocks(List.of(Blocks.GRAVEL)), UniformInt.of(0, 1), 1));


    }



    @SuppressWarnings("removal")
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(OceansEvolved.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
