package ho.artisan.nianyefan;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import java.util.function.BiConsumer;

public class NianYeFan implements ModInitializer {
    public static final FoodComponent NIAN_YE_FAN_FOOD = new FoodComponent.Builder()
            .hunger(6)
            .saturationModifier(0.8f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 0.5F)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 200), 0.5F)
            .build();

    public static final FoodComponent MAGMA_FAN_FOOD = new FoodComponent.Builder()
            .hunger(6)
            .saturationModifier(0.8f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 0.5F)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 200), 0.5F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200), 0.5F)
            .build();

    public static final Item NIAN_YE_FAN = new Item(new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON).food(NIAN_YE_FAN_FOOD).recipeRemainder(Items.BOWL));
    public static final Item MAGMA_FAN = new Item(new Item.Settings().maxCount(1).rarity(Rarity.EPIC).food(MAGMA_FAN_FOOD).recipeRemainder(Items.BOWL));

    public static final FabricItemGroupBuilder MAIN = FabricItemGroupBuilder.create(new Identifier("nianyefan", "main"))
            .appendItems(list -> {
                list.add(new ItemStack(NIAN_YE_FAN));
                list.add(new ItemStack(MAGMA_FAN));
            })
            .icon(() -> new ItemStack(NIAN_YE_FAN));

    @Override
    public void onInitialize() {
        BiConsumer<String, Item> registrar = ((id, item) -> Registry.register(Registry.ITEM, new Identifier("nianyefan", id), item));

        registrar.accept("nian_ye_fan", NIAN_YE_FAN);
        registrar.accept("magma_fan", MAGMA_FAN);

        MAIN.build();
    }
}

