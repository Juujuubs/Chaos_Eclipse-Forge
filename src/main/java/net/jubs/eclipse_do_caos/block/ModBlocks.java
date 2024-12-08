package net.jubs.eclipse_do_caos.block;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.block.custom.EyeBlock;
import net.jubs.eclipse_do_caos.block.custom.TeethBlock;
import net.jubs.eclipse_do_caos.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EclipseDoCaos.MOD_ID);


    public static final RegistryObject<Block> ESSENCE_ORE_BLOCK = registerBlock("essence_ore_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).sound(SoundType.DECORATED_POT)
                    .requiresCorrectToolForDrops(), UniformInt.of(2,5)));

    public static final RegistryObject<Block> ESSENCE_BLOCK = registerBlock("essence_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.SCULK)));
    public static final RegistryObject<Block> MEAT_BLOCK = registerBlock("meat_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).sound(SoundType.SLIME_BLOCK)));

    public static final RegistryObject<Block> TEETH_BLOCK = registerBlock("teeth_block",
            () -> new TeethBlock(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).sound(SoundType.BONE_BLOCK)));

    public static final RegistryObject<Block> EYE_BLOCK = registerBlock("eye_block",
            () -> new EyeBlock(BlockBehaviour.Properties.copy(Blocks.HONEYCOMB_BLOCK).sound(SoundType.WART_BLOCK)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
