package net.jubs.eclipse_do_caos.util;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> DELS_UNKNOWN_BLOCKS = tag("dels_unknown_blocks");
        public static final TagKey<Block> PAXEL_MINEABLE = tag("paxel/mineable");
        public static final TagKey<Block> SAW_EATER_MINEABLE = tag("saw_eater/mineable");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(EclipseDoCaos.MOD_ID, name));
        }

    }

    public static class Items {

        public static final TagKey<Item> LOST_WEAPONS = tag("lost_weapons");
        public static final TagKey<Item> NOT_FROM_THIS_WORLD = tag("not_from_this_world");
        public static final TagKey<Item> GRIMOIRES = tag("grimoires");
        public static final TagKey<Item> STAFFS = tag("staffs");
        public static final TagKey<Item> RANGED_WEAPONS = tag("ranged_weapons");
        public static final TagKey<Item> SHIELDS = tag("shields");
        public static final TagKey<Item> GUNS = tag("guns");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(EclipseDoCaos.MOD_ID, name));
        }

    }
}
