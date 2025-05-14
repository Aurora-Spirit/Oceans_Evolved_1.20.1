package net.aurora_spirit.oceans_evolved.util;

import net.aurora_spirit.oceans_evolved.OceansEvolved;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> GRAVEL = tag("gravel");


        @SuppressWarnings("removal")
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(OceansEvolved.MOD_ID, name));
        }
    }

    public static class Items {



        @SuppressWarnings("removal")
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(OceansEvolved.MOD_ID, name));
        }
    }



}
