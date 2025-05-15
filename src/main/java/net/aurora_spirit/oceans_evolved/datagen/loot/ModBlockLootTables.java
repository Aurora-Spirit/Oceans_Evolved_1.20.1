package net.aurora_spirit.oceans_evolved.datagen.loot;


import net.aurora_spirit.oceans_evolved.block.ModBlocks;
import net.aurora_spirit.oceans_evolved.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {


    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.add(ModBlocks.SEASHELL_PILE_SAND.get(),
                block -> createSeashellOreDrops(block, ModItems.SEASHELL.get()));
        this.add(ModBlocks.SEASHELL_PILE_GRAVEL.get(),
                block -> createSeashellOreDrops(block, ModItems.SEASHELL.get()));
        this.dropSelf(ModBlocks.GIANT_CONCH.get());
    }

    protected LootTable.Builder createSeashellOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
