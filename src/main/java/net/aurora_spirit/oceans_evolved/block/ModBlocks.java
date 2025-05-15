package net.aurora_spirit.oceans_evolved.block;

import net.aurora_spirit.oceans_evolved.OceansEvolved;
import net.aurora_spirit.oceans_evolved.block.custom.GiantConchBlock;
import net.aurora_spirit.oceans_evolved.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, OceansEvolved.MOD_ID);


    public static final RegistryObject<Block> SEASHELL_PILE_SAND = registerBlock("seashell_pile_sand",
            () -> new FallingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.SNARE).strength(0.3F).sound(SoundType.SUSPICIOUS_SAND).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SEASHELL_PILE_GRAVEL = registerBlock("seashell_pile_gravel",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(SEASHELL_PILE_SAND.get()).sound(SoundType.SUSPICIOUS_GRAVEL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> GIANT_CONCH = registerBlock("giant_conch",
            () -> new GiantConchBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.HARP).sound(SoundType.STONE).strength(0.3F)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        //add items to vanilla creative inventory tabs
    }

    public static void addModCreative(CreativeModeTab.ItemDisplayParameters pParameters, CreativeModeTab.Output pOutput) {
        //add items to the mod's creative tab
        pOutput.accept(SEASHELL_PILE_SAND.get());
        pOutput.accept(SEASHELL_PILE_GRAVEL.get());
        pOutput.accept(GIANT_CONCH.get());
    }

}
