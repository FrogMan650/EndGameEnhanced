package net.Lucas.tutorialmod.loot.condition;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.Lucas.tutorialmod.item.custom.InfernalPickaxe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.Serializer;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;

import java.util.Set;

public class InfernalPickaxeCondition implements LootItemCondition {
    public InfernalPickaxeCondition() {

    }

    public Set<LootContextParam<?>> getReferencedContextParams() {
        return ImmutableSet.of(LootContextParams.TOOL);
    }

    @Override
    public LootItemConditionType getType() {
        return null;
    }

    @Override
    public boolean test(LootContext lootContext) {
        ItemStack itemStack = lootContext.getParamOrNull(LootContextParams.TOOL);
        return itemStack != null && itemStack.getItem() instanceof InfernalPickaxe;
    }

    public static LootItemCondition.Builder builder() {
        return InfernalPickaxeCondition::new;
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<InfernalPickaxeCondition> {

        @Override
        public void serialize(JsonObject pJson, InfernalPickaxeCondition pValue, JsonSerializationContext pSerializationContext) {

        }

        @Override
        public InfernalPickaxeCondition deserialize(JsonObject pJson, JsonDeserializationContext pSerializationContext) {
            return null;
        }
    }
}
