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
import java.util.function.Supplier;

public class AddItemsModifier extends LootModifier {
    public static final Supplier<Codec<AddItemsModifier>> CODEC = Suppliers.memoize(
            () -> RecordCodecBuilder.create(inst -> codecStart(inst).and(
                    Codec.list(ItemEntry.CODEC).fieldOf("items").forGetter(m -> m.items)
            ).apply(inst, AddItemsModifier::new)));

    private final List<ItemEntry> items;

    public AddItemsModifier(LootItemCondition[] conditionsIn, List<ItemEntry> items) {
        super(conditionsIn);
        this.items = items;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        for (LootItemCondition condition : this.conditions) {
            if (!condition.test(context)) {
                return generatedLoot;
            }
        }

        for (ItemEntry entry : items) {
            if (context.getRandom().nextFloat() < entry.chance) {
                generatedLoot.add(new ItemStack(entry.item, entry.count));
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
                ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(e -> e.item),
                Codec.FLOAT.fieldOf("chance").forGetter(e -> e.chance),
                Codec.INT.fieldOf("count").forGetter(e -> e.count)
        ).apply(inst, ItemEntry::new));

        public final Item item;
        public final float chance;
        public final int count;

        public ItemEntry(Item item, float chance, int count) {
            this.item = item;
            this.chance = chance;
            this.count = count;
        }
    }
}
