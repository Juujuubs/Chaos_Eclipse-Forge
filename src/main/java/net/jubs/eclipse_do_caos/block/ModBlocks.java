package net.jubs.eclipse_do_caos.block;

import net.jubs.eclipse_do_caos.EclipseDoCaos;
import net.jubs.eclipse_do_caos.block.custom.*;
import net.jubs.eclipse_do_caos.item.ModItems;
import net.jubs.eclipse_do_caos.util.ModWoodTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
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

    public static final RegistryObject<Block> BROMELIAD = registerBlock("bromeliad",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 10, BlockBehaviour.Properties.copy(Blocks.POPPY)));
    public static final RegistryObject<Block> POTTED_BROMELIAD = BLOCKS.register("potted_bromeliad",
            () -> new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), BROMELIAD, BlockBehaviour.Properties.copy(Blocks.POTTED_POPPY)));


    public static final RegistryObject<Block> EDEN_LOG = registerBlock("eden_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> EDEN_WOOD = registerBlock("eden_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_EDEN_LOG = registerBlock("stripped_eden_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_EDEN_WOOD = registerBlock("stripped_eden_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> EDEN_PLANKS = registerBlock("eden_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> EDEN_LEAVES = registerBlock("eden_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> EDEN_SAPLING = registerBlock("eden_sapling",
            () -> new SaplingBlock(null, BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> EDEN_SLAB = registerBlock("eden_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> EDEN_STAIRS = registerBlock("eden_stairs",
            () -> new StairBlock(() -> ModBlocks.EDEN_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> EDEN_BUTTON = registerBlock("eden_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.OAK, 10, true));
    public static final RegistryObject<Block> EDEN_PRESSURE_PLATE = registerBlock("eden_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));

    public static final RegistryObject<Block> EDEN_FENCE = registerBlock("eden_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> EDEN_FENCE_GATE = registerBlock("eden_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> EDEN_DOOR = registerBlock("eden_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Block> EDEN_TRAPDOOR = registerBlock("eden_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));

    public static final RegistryObject<Block> EDEN_SIGN = BLOCKS.register("eden_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.EDEN));
    public static final RegistryObject<Block> EDEN_WALL_SIGN = BLOCKS.register("eden_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.EDEN));
    public static final RegistryObject<Block> EDEN_HANGING_SIGN = BLOCKS.register("eden_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.EDEN));
    public static final RegistryObject<Block> EDEN_HANGING_WALL_SIGN = BLOCKS.register("eden_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.EDEN));

    public static final RegistryObject<Block> BEAN_CROP = BLOCKS.register("bean_crop",
            () -> new BeanCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noCollission().noOcclusion()));

    public static final RegistryObject<Block> SAMARA_PLUSHIE = registerBlock("samara_plushie",
            () -> new SamaraPlushieBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).sound(SoundType.SNOW).noOcclusion()));

    public static final RegistryObject<Block> RADIO_ANNOUNCER = registerBlock("radio_announcer",
            () -> new RadioAnnouncerBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).sound(SoundType.COPPER).noOcclusion()));


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
