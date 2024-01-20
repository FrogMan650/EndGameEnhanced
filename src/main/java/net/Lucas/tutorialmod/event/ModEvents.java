package net.Lucas.tutorialmod.event;

import com.mojang.datafixers.util.Either;
import net.Lucas.tutorialmod.TutorialMod;
import net.Lucas.tutorialmod.entity.custom.LeviathansAxeEntity;
import net.Lucas.tutorialmod.item.ModItems;
import net.Lucas.tutorialmod.item.custom.UnkemptHarold;
import net.Lucas.tutorialmod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.monster.ElderGuardian;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.GravelBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.swing.text.Element;
import javax.xml.transform.Result;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onLivingHurtDamageFixes(LivingHurtEvent event) {
        LivingEntity damagedMob = event.getEntity();
        float initialDamage = event.getAmount();
        if (event.getSource().getEntity() instanceof Player player) {
            if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.SCYTHE_OF_VITUR.get())) {
                if (initialDamage == 1) {
                    if (damagedMob.isBaby()) {
                        event.setAmount(0);
                    } else event.setAmount(12);
                }
            }
        }
    }

    //attempt at rewriting the damage when having certain enchantments
//            if (player.isHolding(ModItems.TIDE_BREAKER.get()) && damagedMob.isInWaterOrRain()) {
//                int impalingLevel = player.getMainHandItem().getEnchantmentLevel(Enchantments.IMPALING);
//                int riptideLevel = player.getMainHandItem().getEnchantmentLevel(Enchantments.RIPTIDE);
//                event.setAmount(16 + (impalingLevel * 2f) + (riptideLevel * 1.5f));
//            }
//            if (player.isHolding(ModItems.SCULK_BLADE.get()) || player.isHolding(ModItems.END_BLADE.get()) || player.isHolding(ModItems.NETHER_BLADE.get())) {
//                int sharpnessLevel = player.getMainHandItem().getEnchantmentLevel(Enchantments.SHARPNESS);
//                int smiteLevel = player.getMainHandItem().getEnchantmentLevel(Enchantments.SMITE);
//                int arthropodLevel = player.getMainHandItem().getEnchantmentLevel(Enchantments.BANE_OF_ARTHROPODS);
//                if (damagedMob.getMobType() == MobType.UNDEAD) {
//                    if (initialDamage == ((12 + 6 + (smiteLevel * 2.5)) * 1.5f)) {
//                        event.setAmount((12 + 6 + (smiteLevel * 4)) * 1.5f);
//                    } else if (initialDamage == ((12 + 3 + (smiteLevel * 2.5)) * 1.5f)) {
//                        event.setAmount((12 + 3 + (smiteLevel * 4)) * 1.5f);
//                    } else if (initialDamage == ((12 + (smiteLevel * 2.5)) * 1.5f)) {
//                        event.setAmount((12 + (smiteLevel * 4)) * 1.5f);
//                    } else if (initialDamage == (12 + 6 + (smiteLevel * 2.5))) {
//                        event.setAmount(12 + 6 + (smiteLevel * 4));
//                    } else if (initialDamage == (12 + 3 + (smiteLevel * 2.5))) {
//                        event.setAmount(12 + 3 + (smiteLevel * 4));
//                    } else if (initialDamage == (12 + (smiteLevel * 2.5))) {
//                        event.setAmount(12 + (smiteLevel * 4));
//                    }
//                } else if (damagedMob.getMobType() == MobType.ARTHROPOD) {
//                    if (initialDamage == ((12 + 6 + (arthropodLevel * 2.5)) * 1.5f)) {
//                        event.setAmount((12 + 6 + (arthropodLevel * 4)) * 1.5f);
//                    } else if (initialDamage == ((12 + 3 + (arthropodLevel * 2.5)) * 1.5f)) {
//                        event.setAmount((12 + 3 + (arthropodLevel * 4)) * 1.5f);
//                    } else if (initialDamage == ((12 + (arthropodLevel * 2.5)) * 1.5f)) {
//                        event.setAmount((12 + (arthropodLevel * 4)) * 1.5f);
//                    } else if (initialDamage == (12 + 6 + (arthropodLevel * 2.5))) {
//                        event.setAmount(12 + 6 + (arthropodLevel * 4));
//                    } else if (initialDamage == (12 + 3 + (arthropodLevel * 2.5))) {
//                        event.setAmount(12 + 3 + (arthropodLevel * 4));
//                    } else if (initialDamage == (12 + (arthropodLevel * 2.5))) {
//                        event.setAmount(12 + (arthropodLevel * 4));
//                    }
//                } else {
//                    if (initialDamage == ((12 + 6 + (sharpnessLevel * 0.5 + 0.5)) * 1.5f)) {
//                        event.setAmount((12 + 6 + (sharpnessLevel * 2)) * 1.5f);
//                    } else if (initialDamage == ((12 + 3 + (sharpnessLevel * 0.5 + 0.5)) * 1.5f)) {
//                        event.setAmount((12 + 3 + (sharpnessLevel * 2)) * 1.5f);
//                    } else if (initialDamage == ((12 + (sharpnessLevel * 0.5 + 0.5)) * 1.5f)) {
//                        event.setAmount((12 + (sharpnessLevel * 2)) * 1.5f);
//                    } else if (initialDamage == (12 + 6 + (sharpnessLevel * 0.5 + 0.5))) {
//                        event.setAmount(12 + 6 + (sharpnessLevel * 2));
//                    } else if (initialDamage == (12 + 3 + (sharpnessLevel * 0.5 + 0.5))) {
//                        event.setAmount(12 + 3 + (sharpnessLevel * 2));
//                    } else if (initialDamage == (12 + (sharpnessLevel * 0.5 + 0.5))) {
//                        event.setAmount(12 + (sharpnessLevel * 2));
//                    }
//                }
//            }
//        }
//    }
    @SubscribeEvent
    public static void onLivingHurtWarden(LivingHurtEvent event) {
        if (event.getEntity() instanceof Warden) {
            if (event.getSource().getEntity() instanceof Player player) {
                String weaponName = player.getItemInHand(InteractionHand.MAIN_HAND).toString();
                String[] weaponNameSplit = weaponName.split(" ");
                player.sendSystemMessage(Component.literal(weaponNameSplit[1] + " damage: " + event.getAmount()));
            }
        }
    }

    @SubscribeEvent
    public static void onLivingHurtCow(LivingHurtEvent event) {
        if (event.getEntity() instanceof Cow) {
            if (event.getSource().getEntity() instanceof Player player) {
                String weaponName = player.getItemInHand(InteractionHand.MAIN_HAND).toString();
                String[] weaponNameSplit = weaponName.split(" ");
                player.sendSystemMessage(Component.literal(weaponNameSplit[1] + " damage: " + event.getAmount()));
            }
        }
    }

    @SubscribeEvent
    public static void onLivingHurtElderGuardian(LivingHurtEvent event) {
        if (event.getEntity() instanceof ElderGuardian) {
            if (event.getSource().getEntity() instanceof Player player) {
                String weaponName = player.getItemInHand(InteractionHand.MAIN_HAND).toString();
                String[] weaponNameSplit = weaponName.split(" ");
                player.sendSystemMessage(Component.literal(weaponNameSplit[1] + " damage: " + event.getAmount()));
            }
        }
    }

    @SubscribeEvent
    public static void changeTooltipComponents(ItemTooltipEvent event) {
        final List<Component> tooltipElements = event.getToolTip();
        if (event.getItemStack().is(ModItems.SCULK_BLADE.get()) || event.getItemStack().is(ModItems.NETHER_BLADE.get())
                || event.getItemStack().is(ModItems.END_BLADE.get()) || event.getItemStack().is(ModItems.TIDE_BREAKER.get())
                || event.getItemStack().is(ModItems.LEVIATHANS_AXE.get()) || event.getItemStack().is(ModItems.SCYTHE_OF_VITUR.get())
                || event.getItemStack().is(ModItems.UNKEMPT_HAROLD.get())) {
            if (!event.getFlags().isAdvanced()) {
                for (int i = 0; i < 4; i++) {
                    tooltipElements.remove(tooltipElements.size() - 1);
                }
            }
            if (event.getFlags().isAdvanced()) {
                String durabilityCheck = String.valueOf(tooltipElements.get(tooltipElements.size() - 3));
                boolean containsDurability = durabilityCheck.contains("item.durability");
                if (containsDurability) {
                    for (int i = 0; i < 4; i++) {
                        tooltipElements.remove(tooltipElements.size() - 4);
                    }
                } else {
                    for (int i = 0; i < 4; i++) {
                        tooltipElements.remove(tooltipElements.size() - 3);
                    }

                }

            }
        }
    }

    @SubscribeEvent
    public static void changeTooltipSize(RenderTooltipEvent.GatherComponents event) {
        event.setMaxWidth(200);
    }

    @SubscribeEvent
    public static void TestingShovelTech(PlayerInteractEvent.LeftClickBlock event) {
        BlockPos blockPos = event.getPos();
        BlockState blockState = event.getLevel().getBlockState(blockPos);
        Block block = blockState.getBlock();
        Level level = event.getLevel();
        Player player = event.getEntity();
        Direction blockDirection = event.getFace();
        String facing = blockDirection.getName();
        int blockPosX = blockPos.getX();
        int blockPosY = blockPos.getY();
        int blockPosZ = blockPos.getZ();
        if (player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == ModItems.UNKEMPT_HAROLD.get()) {
            if (level.getBlockState(blockPos).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                if (block.onDestroyedByPlayer(blockState, level, blockPos, player, true, block.getFluidState(blockState))) {
                    if (facing.equals("north") || facing.equals("south")) {
                        int[] newblockX = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
                        int[] newblockY = {1, 1, 1, 0, -1, -1, -1, 0, 0};
                        BlockPos blockToDestroy0 = new BlockPos(newblockX[0] + blockPosX, newblockY[0] + blockPosY, blockPosZ);
                        BlockPos blockToDestroy1 = new BlockPos(newblockX[1] + blockPosX, newblockY[1] + blockPosY, blockPosZ);
                        BlockPos blockToDestroy2 = new BlockPos(newblockX[2] + blockPosX, newblockY[2] + blockPosY, blockPosZ);
                        BlockPos blockToDestroy3 = new BlockPos(newblockX[3] + blockPosX, newblockY[3] + blockPosY, blockPosZ);
                        BlockPos blockToDestroy4 = new BlockPos(newblockX[4] + blockPosX, newblockY[4] + blockPosY, blockPosZ);
                        BlockPos blockToDestroy5 = new BlockPos(newblockX[5] + blockPosX, newblockY[5] + blockPosY, blockPosZ);
                        BlockPos blockToDestroy6 = new BlockPos(newblockX[6] + blockPosX, newblockY[6] + blockPosY, blockPosZ);
                        BlockPos blockToDestroy7 = new BlockPos(newblockX[7] + blockPosX, newblockY[7] + blockPosY, blockPosZ);
                        BlockPos blockToDestroy8 = new BlockPos(newblockX[8] + blockPosX, newblockY[8] + blockPosY, blockPosZ);
                        if (level.getBlockState(blockToDestroy0).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy0, true);
                        }
                        if (level.getBlockState(blockToDestroy1).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy1, true);
                        }
                        if (level.getBlockState(blockToDestroy2).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy2, true);
                        }
                        if (level.getBlockState(blockToDestroy3).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy3, true);
                        }
                        if (level.getBlockState(blockToDestroy4).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy4, true);
                        }
                        if (level.getBlockState(blockToDestroy5).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy5, true);
                        }
                        if (level.getBlockState(blockToDestroy6).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy6, true);
                        }
                        if (level.getBlockState(blockToDestroy7).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy7, true);
                        }
                        if (level.getBlockState(blockToDestroy8).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy8, true);
                        }
                    }
                    if (facing.equals("east") || facing.equals("west")) {
                        int[] newblockZ = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
                        int[] newblockY = {1, 1, 1, 0, -1, -1, -1, 0, 0};
                        BlockPos blockToDestroy0 = new BlockPos(blockPosX, newblockY[0] + blockPosY, newblockZ[0] + blockPosZ);
                        BlockPos blockToDestroy1 = new BlockPos(blockPosX, newblockY[1] + blockPosY, newblockZ[1] + blockPosZ);
                        BlockPos blockToDestroy2 = new BlockPos(blockPosX, newblockY[2] + blockPosY, newblockZ[2] + blockPosZ);
                        BlockPos blockToDestroy3 = new BlockPos(blockPosX, newblockY[3] + blockPosY, newblockZ[3] + blockPosZ);
                        BlockPos blockToDestroy4 = new BlockPos(blockPosX, newblockY[4] + blockPosY, newblockZ[4] + blockPosZ);
                        BlockPos blockToDestroy5 = new BlockPos(blockPosX, newblockY[5] + blockPosY, newblockZ[5] + blockPosZ);
                        BlockPos blockToDestroy6 = new BlockPos(blockPosX, newblockY[6] + blockPosY, newblockZ[6] + blockPosZ);
                        BlockPos blockToDestroy7 = new BlockPos(blockPosX, newblockY[7] + blockPosY, newblockZ[7] + blockPosZ);
                        BlockPos blockToDestroy8 = new BlockPos(blockPosX, newblockY[8] + blockPosY, newblockZ[8] + blockPosZ);
                        if (level.getBlockState(blockToDestroy0).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy0, true);
                        }
                        if (level.getBlockState(blockToDestroy1).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy1, true);
                        }
                        if (level.getBlockState(blockToDestroy2).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy2, true);
                        }
                        if (level.getBlockState(blockToDestroy3).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy3, true);
                        }
                        if (level.getBlockState(blockToDestroy4).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy4, true);
                        }
                        if (level.getBlockState(blockToDestroy5).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy5, true);
                        }
                        if (level.getBlockState(blockToDestroy6).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy6, true);
                        }
                        if (level.getBlockState(blockToDestroy7).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy7, true);
                        }
                        if (level.getBlockState(blockToDestroy8).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy8, true);
                        }
                    }
                    if (facing.equals("up") || facing.equals("down")) {
                        int[] newblockX = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
                        int[] newblockZ = {1, 1, 1, 0, -1, -1, -1, 0, 0};
                        BlockPos blockToDestroy0 = new BlockPos(newblockX[0] + blockPosX, blockPosY, newblockZ[0] + blockPosZ);
                        BlockPos blockToDestroy1 = new BlockPos(newblockX[1] + blockPosX, blockPosY, newblockZ[1] + blockPosZ);
                        BlockPos blockToDestroy2 = new BlockPos(newblockX[2] + blockPosX, blockPosY, newblockZ[2] + blockPosZ);
                        BlockPos blockToDestroy3 = new BlockPos(newblockX[3] + blockPosX, blockPosY, newblockZ[3] + blockPosZ);
                        BlockPos blockToDestroy4 = new BlockPos(newblockX[4] + blockPosX, blockPosY, newblockZ[4] + blockPosZ);
                        BlockPos blockToDestroy5 = new BlockPos(newblockX[5] + blockPosX, blockPosY, newblockZ[5] + blockPosZ);
                        BlockPos blockToDestroy6 = new BlockPos(newblockX[6] + blockPosX, blockPosY, newblockZ[6] + blockPosZ);
                        BlockPos blockToDestroy7 = new BlockPos(newblockX[7] + blockPosX, blockPosY, newblockZ[7] + blockPosZ);
                        BlockPos blockToDestroy8 = new BlockPos(newblockX[8] + blockPosX, blockPosY, newblockZ[8] + blockPosZ);
                        if (level.getBlockState(blockToDestroy0).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy0, true);
                        }
                        if (level.getBlockState(blockToDestroy1).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy1, true);
                        }
                        if (level.getBlockState(blockToDestroy2).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy2, true);
                        }
                        if (level.getBlockState(blockToDestroy3).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy3, true);
                        }
                        if (level.getBlockState(blockToDestroy4).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy4, true);
                        }
                        if (level.getBlockState(blockToDestroy5).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy5, true);
                        }
                        if (level.getBlockState(blockToDestroy6).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy6, true);
                        }
                        if (level.getBlockState(blockToDestroy7).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy7, true);
                        }
                        if (level.getBlockState(blockToDestroy8).is(BlockTags.MINEABLE_WITH_SHOVEL)) {
                            level.destroyBlock(blockToDestroy8, true);
                        }
                    }
                }
            }
        }
    }
}

