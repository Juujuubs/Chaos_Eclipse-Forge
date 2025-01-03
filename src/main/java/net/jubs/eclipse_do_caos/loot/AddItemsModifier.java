package net.jubs.eclipse_do_caos.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class AddItemsModifier extends LootModifier {
    public static final Supplier<Codec<AddItemsModifier>> CODEC = Suppliers.memoize(
            () -> RecordCodecBuilder.create(inst -> codecStart(inst).and(
                    Codec.list(ItemEntry.CODEC).fieldOf("items").forGetter(m -> m.items)
            ).and(Codec.INT.fieldOf("totalItemCount").forGetter(m -> m.totalItemCount)
            ).and(Codec.FLOAT.fieldOf("chance").forGetter(m -> m.chance)
            ).apply(inst, AddItemsModifier::new)));

    private final List<ItemEntry> items;
    private final int totalItemCount;
    private final float chance;

    public AddItemsModifier(LootItemCondition[] conditionsIn, List<ItemEntry> items, int totalItemCount, float chance) {
        super(conditionsIn);
        this.items = items;
        this.totalItemCount = totalItemCount;
        this.chance = chance;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        for (LootItemCondition condition : this.conditions) {
            if (!condition.test(context)) {
                return generatedLoot;
            }
        }

        Random random = new Random();
        if (random.nextFloat() < this.chance) {
            int maxItemsToDrop = random.nextInt(this.totalItemCount) + 1;
            int remainingItemCount = maxItemsToDrop;

            while (remainingItemCount > 0 && !items.isEmpty()) {
                int itemIndex = random.nextInt(items.size());
                Item item = items.get(itemIndex).item;
                int count = Math.min(remainingItemCount, item.getMaxStackSize());

                generatedLoot.add(new ItemStack(item, count));
                remainingItemCount -= count;
            }
        }

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }

    public static class ItemEntry {
        public static final Codec<ItemEntry> CODEC = RecordCodecBuilder.create(inst -> inst.group(
                ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(e -> e.item)
        ).apply(inst, ItemEntry::new));

        public final Item item;

        public ItemEntry(Item item) {
            this.item = item;
        }
    }
}
