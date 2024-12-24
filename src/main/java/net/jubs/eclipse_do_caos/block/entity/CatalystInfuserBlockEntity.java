package net.jubs.eclipse_do_caos.block.entity;

import net.jubs.eclipse_do_caos.item.ModItems;
import net.jubs.eclipse_do_caos.screen.CatalystInfuserMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CatalystInfuserBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(7) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot){
                case 0 -> stack.getItem() == ModItems.HUMAN_TOOTH.get();
                case 1 -> stack.getItem() == ModItems.ELF_EAR.get();
                case 2 -> stack.getItem() == ModItems.DEVIL_HORN.get();
                case 3 -> stack.getItem() == ModItems.GOBLIN_EYE.get();
                case 4 -> stack.getItem() == ModItems.ESSENCE.get();
                case 5 -> stack.getItem() == ModItems.CATALYST_EMPTY.get();
                case 6 -> false;
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private static final int INPUT_SLOT_HUMAN = 0;
    private static final int INPUT_SLOT_ELF = 1;
    private static final int INPUT_SLOT_DEVIL = 2;
    private static final int INPUT_SLOT_GOBLIN = 3;
    private static final int INPUT_SLOT_ESSENCE = 4;
    private static final int INPUT_SLOT_BOTTLE = 5;
    private static final int OUTPUT_SLOT = 6;


    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;


    public CatalystInfuserBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.CATALYST_INFUSER_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> CatalystInfuserBlockEntity.this.progress;
                    case 1 -> CatalystInfuserBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> CatalystInfuserBlockEntity.this.progress = pValue;
                    case 1 -> CatalystInfuserBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("Catalyst Infuser");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerinventory, Player player) {
        return new CatalystInfuserMenu(pContainerId, pPlayerinventory, this, this.data);
    }


    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if (side == null) {
                return lazyItemHandler.cast();
            }

            if (side == Direction.DOWN) {
                return LazyOptional.of(() -> new OutputItemHandler(itemHandler)).cast();
            } else {
                return LazyOptional.of(() -> new InputItemHandler(itemHandler)).cast();
            }
        }
        return super.getCapability(cap, side);
    }

    private static class OutputItemHandler implements IItemHandler {
        private final ItemStackHandler handler;

        public OutputItemHandler(ItemStackHandler handler) {
            this.handler = handler;
        }

        @Override
        public int getSlots() {
            return 1;
        }

        @Override
        public @NotNull ItemStack getStackInSlot(int slot) {
            return handler.getStackInSlot(OUTPUT_SLOT);
        }

        @Override
        public @NotNull ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
            return stack;
        }

        @Override
        public @NotNull ItemStack extractItem(int slot, int amount, boolean simulate) {
            if (slot != 0) return ItemStack.EMPTY;
            return handler.extractItem(OUTPUT_SLOT, amount, simulate);
        }

        @Override
        public int getSlotLimit(int slot) {
            return handler.getSlotLimit(OUTPUT_SLOT);
        }

        @Override
        public boolean isItemValid(int i, @NotNull ItemStack itemStack) {
            return false;
        }
    }

    private static class InputItemHandler implements IItemHandler {
        private final ItemStackHandler handler;

        public InputItemHandler(ItemStackHandler handler) {
            this.handler = handler;
        }

        @Override
        public int getSlots() {
            return handler.getSlots();
        }

        @Override
        public @NotNull ItemStack getStackInSlot(int slot) {
            return handler.getStackInSlot(slot);
        }

        @Override
        public @NotNull ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
            if (!handler.isItemValid(slot, stack)) {
                return stack;
            }
            return handler.insertItem(slot, stack, simulate);
        }

        @Override
        public @NotNull ItemStack extractItem(int slot, int amount, boolean simulate) {
            return ItemStack.EMPTY;
        }

        @Override
        public int getSlotLimit(int slot) {
            return handler.getSlotLimit(slot);
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return handler.isItemValid(slot, stack);
        }
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("catalyst_infuser.progress", progress);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));

    }

    public void tick(Level level, BlockPos pPos, BlockState pState) {
        if (isOutputSlotEmptyOrReceivable() && hasRecipe()) {
            increaseCraftingProcess();
            setChanged(level, pPos, pState);

            if (hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void craftItem() {
        this.itemHandler.extractItem(INPUT_SLOT_HUMAN, 1, false);
        this.itemHandler.extractItem(INPUT_SLOT_ELF, 1, false);
        this.itemHandler.extractItem(INPUT_SLOT_DEVIL, 1, false);
        this.itemHandler.extractItem(INPUT_SLOT_GOBLIN, 1, false);
        this.itemHandler.extractItem(INPUT_SLOT_ESSENCE, 1, false);
        this.itemHandler.extractItem(INPUT_SLOT_BOTTLE, 1, false);

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(ModItems.CATALYST.get(),
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + 1));
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private boolean hasProgressFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProcess() {
        this.progress++;
    }

    private boolean hasRecipe() {
        ItemStack slot0 = this.itemHandler.getStackInSlot(INPUT_SLOT_HUMAN);
        ItemStack slot1 = this.itemHandler.getStackInSlot(INPUT_SLOT_ELF);
        ItemStack slot2 = this.itemHandler.getStackInSlot(INPUT_SLOT_DEVIL);
        ItemStack slot3 = this.itemHandler.getStackInSlot(INPUT_SLOT_GOBLIN);
        ItemStack slot4 = this.itemHandler.getStackInSlot(INPUT_SLOT_ESSENCE);
        ItemStack slot5 = this.itemHandler.getStackInSlot(INPUT_SLOT_BOTTLE);

        // Verifica se todos os itens estão nos slots corretos
        boolean hasIngredients = !slot0.isEmpty() && slot0.getItem() == ModItems.HUMAN_TOOTH.get()
                && !slot1.isEmpty() && slot1.getItem() == ModItems.ELF_EAR.get()
                && !slot2.isEmpty() && slot2.getItem() == ModItems.DEVIL_HORN.get()
                && !slot3.isEmpty() && slot3.getItem() == ModItems.GOBLIN_EYE.get()
                && !slot4.isEmpty() && slot4.getItem() == ModItems.ESSENCE.get()
                && !slot5.isEmpty() && slot5.getItem() == ModItems.CATALYST_EMPTY.get();

        return hasIngredients && canInsertAmountIntoOutputSlot(1) && canInsertItemIntoOutputSlot(new ItemStack(ModItems.CATALYST.get()));
    }

    private boolean hasRecipeItemInInputSlot() {
        return !itemHandler.getStackInSlot(INPUT_SLOT_HUMAN).isEmpty()
                && itemHandler.getStackInSlot(INPUT_SLOT_HUMAN).getItem() == ModItems.HUMAN_TOOTH.get()
                && !itemHandler.getStackInSlot(INPUT_SLOT_ELF).isEmpty()
                && itemHandler.getStackInSlot(INPUT_SLOT_ELF).getItem() == ModItems.ELF_EAR.get()
                && !itemHandler.getStackInSlot(INPUT_SLOT_DEVIL).isEmpty()
                && itemHandler.getStackInSlot(INPUT_SLOT_DEVIL).getItem() == ModItems.DEVIL_HORN.get()
                && !itemHandler.getStackInSlot(INPUT_SLOT_GOBLIN).isEmpty()
                && itemHandler.getStackInSlot(INPUT_SLOT_GOBLIN).getItem() == ModItems.GOBLIN_EYE.get()
                && !itemHandler.getStackInSlot(INPUT_SLOT_ESSENCE).isEmpty()
                && itemHandler.getStackInSlot(INPUT_SLOT_ESSENCE).getItem() == ModItems.ESSENCE.get()
                && !itemHandler.getStackInSlot(INPUT_SLOT_BOTTLE).isEmpty()
                && itemHandler.getStackInSlot(INPUT_SLOT_BOTTLE).getItem() == ModItems.CATALYST_EMPTY.get();
    }


    private boolean canInsertItemIntoOutputSlot(ItemStack result) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getItem() == result.getItem() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(int amount) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + amount <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ||
                this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() < this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }


}
