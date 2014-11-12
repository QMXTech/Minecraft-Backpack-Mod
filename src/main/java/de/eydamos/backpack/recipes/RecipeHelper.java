package de.eydamos.backpack.recipes;

import de.eydamos.backpack.misc.Constants;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import de.eydamos.backpack.item.ItemsBackpack;
import de.eydamos.backpack.misc.ConfigurationBackpack;

public class RecipeHelper {
    public static void registerRecipes() {
        ItemStack backpackStack;
        ItemStack boundLeatherStack = new ItemStack(ItemsBackpack.boundLeather);
        String[] dyes = { "dyeBlack", "dyeRed", "dyeGreen", "dyeBrown", "dyeBlue", "dyePurple", "dyeCyan", "dyeLightGray",
                          "dyeGray", "dyePink", "dyeLime", "dyeYellow", "dyeLightBlue", "dyeMagenta", "dyeOrange", "dyeWhite" };

        if(!ConfigurationBackpack.DISABLE_BACKPACKS_S) {
            // small backpacks
            for(int i = 0; i < 17; i++) {
                backpackStack = new ItemStack(ItemsBackpack.backpack, 1, i);

                if((i == 0) && ConfigurationBackpack.AIRSHIP_MOD_COMPATIBILITY) {
                    GameRegistry.addRecipe(backpackStack, "LLL", "LCL", "LLL", 'L', Items.leather, 'C', Blocks.chest);
                } else if(i == 0) {
                    GameRegistry.addRecipe(backpackStack, "LLL", "L L", "LLL", 'L', Items.leather);
                } else {
                    GameRegistry.addRecipe(new ShapedOreRecipe(backpackStack, "LLL", "LDL", "LLL", 'L', Items.leather, 'D', dyes[i - 1]));
                }
            }
        }

        if(!ConfigurationBackpack.DISABLE_BACKPACKS_M) {
            // medium backpacks
            for(int i = 100; i < 117; i++) {
                backpackStack = new ItemStack(ItemsBackpack.backpack, 1, i);

                if(i == 100) {
                    GameRegistry.addRecipe(backpackStack, "LTL", "T T", "LTL", 'L', Items.leather, 'T', ItemsBackpack.tannedLeather);
                } else {
                    GameRegistry.addRecipe(new ShapedOreRecipe(backpackStack, "LTL", "TDT", "LTL", 'L', Items.leather, 'T', ItemsBackpack.tannedLeather, 'D', dyes[i - 101]));
                }
            }
        }

        if(!ConfigurationBackpack.DISABLE_BACKPACKS_L) {
            // large backpacks
            for(int i = 200; i < 217; i++) {
                backpackStack = new ItemStack(ItemsBackpack.backpack, 1, i);

                if(i == 200) {
                    GameRegistry.addRecipe(backpackStack, "TTT", "T T", "TTT", 'T', ItemsBackpack.tannedLeather);
                } else {
                    GameRegistry.addRecipe(new ShapedOreRecipe(backpackStack, "TTT", "TDT", "TTT", 'T', ItemsBackpack.tannedLeather, 'D', dyes[i - 201]));
                }
            }
        }

        if(!ConfigurationBackpack.DISABLE_BACKPACKS_WB_S) {
            // small workbench backpack
            backpackStack = new ItemStack(ItemsBackpack.workbenchBackpack, 1, 17);
            GameRegistry.addRecipe(backpackStack, "LLL", "LWL", "LLL", 'L', Items.leather, 'W', Blocks.crafting_table);
        }

        if(!ConfigurationBackpack.DISABLE_BACKPACKS_WB_M) {
            // medium workbench backpack
            backpackStack = new ItemStack(ItemsBackpack.workbenchBackpack, 1, 117);
            GameRegistry.addRecipe(backpackStack, "LTL", "TWT", "LTL", 'L', Items.leather, 'T', ItemsBackpack.tannedLeather, 'W', Blocks.crafting_table);
        }

        if(!ConfigurationBackpack.DISABLE_BACKPACKS_WB_L) {
            // large workbench backpack
            backpackStack = new ItemStack(ItemsBackpack.workbenchBackpack, 1, 217);
            GameRegistry.addRecipe(backpackStack, "TTT", "TWT", "TTT", 'T', ItemsBackpack.tannedLeather, 'W', Blocks.crafting_table);
        }

        if(!ConfigurationBackpack.DISABLE_BACKPACKS_E) {
            // ender backpack
            if(!ConfigurationBackpack.USE_ENDER_EYE) {
                backpackStack = new ItemStack(ItemsBackpack.backpack, 1, ItemsBackpack.ENDERBACKPACK);
                GameRegistry.addRecipe(backpackStack, "LLL", "LEL", "LLL", 'L', Items.leather, 'E', Blocks.ender_chest);
            } else {
                backpackStack = new ItemStack(ItemsBackpack.backpack, 1, ItemsBackpack.ENDERBACKPACK);
                GameRegistry.addRecipe(backpackStack, "LLL", "LEL", "LLL", 'L', Items.leather, 'E', Items.ender_eye);
            }
        }

        // bound leather
        GameRegistry.addRecipe(boundLeatherStack, "SSS", "LSL", "SSS", 'S', Items.string, 'L', Items.leather);

        // tanned leather
        ItemStack tannedLeatherStack = new ItemStack(ItemsBackpack.tannedLeather);
        GameRegistry.addSmelting(ItemsBackpack.boundLeather, tannedLeatherStack, 0.1f);

        // recolor backpack
        GameRegistry.addRecipe(new RecipeRecolorBackpack());

        // intelligent workbench backpack
        GameRegistry.addRecipe(new RecipeIntelligentWorkbenchBackpack());

        RecipeSorter.register(Constants.RECIPE_RECOLOR, RecipeRecolorBackpack.class, RecipeSorter.Category.SHAPELESS, "");
        RecipeSorter.register(Constants.RECIPE_INTELLIGENT, RecipeIntelligentWorkbenchBackpack.class, RecipeSorter.Category.SHAPELESS, "");
    }
}

