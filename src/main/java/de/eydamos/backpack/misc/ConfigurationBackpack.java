package de.eydamos.backpack.misc;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationBackpack {
    public static final String COMMENT_BORDER = "########################################\n";

    public static Configuration config;

    public static boolean USE_ENDER_EYE;
    public static int MAX_BACKPACK_AMOUNT;
    public static boolean RENDER_BACKPACK_MODEL;
    public static boolean OPEN_ONLY_WORN_BACKPACK;
    public static boolean AIRSHIP_MOD_COMPATIBILITY;
    public static boolean DISABLE_BACKPACKS_S;
    public static boolean DISABLE_BACKPACKS_M;
    public static boolean DISABLE_BACKPACKS_L;
    public static boolean DISABLE_BACKPACKS_WB_S;
    public static boolean DISABLE_BACKPACKS_WB_M;
    public static boolean DISABLE_BACKPACKS_WB_L;
    public static boolean DISABLE_BACKPACKS_E;
    public static String DISALLOW_ITEMS;
    public static String GUI_TEXT_COLOR;

    public static boolean NEISupport = false;
    public static int GUITextColor;

    public static void init(File configFile) {
        if(config == null) {
            config = new Configuration(configFile);
            loadConfiguration();
        }
    }

    public static void loadConfiguration() {
        int value;

        USE_ENDER_EYE = config.get(Configuration.CATEGORY_GENERAL, "useEnderEye", false, getUseEnderEyeComment()).getBoolean(false);
        MAX_BACKPACK_AMOUNT = config.get(Configuration.CATEGORY_GENERAL, "maxBackpackAmount", 0, getMaxBackpackAmountComment()).getInt();

        if((MAX_BACKPACK_AMOUNT < 0) || (MAX_BACKPACK_AMOUNT > 36)) {
            MAX_BACKPACK_AMOUNT = 0;
        }

        RENDER_BACKPACK_MODEL = config.get(Configuration.CATEGORY_GENERAL, "renderBackpackModel", true, getRenderBackpackModelComment()).getBoolean(true);
        OPEN_ONLY_WORN_BACKPACK = config.get(Configuration.CATEGORY_GENERAL, "openOnlyWornBackpacks", false, getOpenOnlyWornBackpacksComment()).getBoolean(false);
        AIRSHIP_MOD_COMPATIBILITY = config.get(Configuration.CATEGORY_GENERAL, "airshipModCompatibility", false, getAirshipModCompatibilityComment()).getBoolean(false);
        DISABLE_BACKPACKS_S = config.get(Configuration.CATEGORY_GENERAL, "disableBackpacksS", false, getDisableBackpacksComment("small")).getBoolean(false);
        DISABLE_BACKPACKS_M = config.get(Configuration.CATEGORY_GENERAL, "disableBackpacksM", false, getDisableBackpacksComment("medium")).getBoolean(false);
        DISABLE_BACKPACKS_L = config.get(Configuration.CATEGORY_GENERAL, "disableBackpacksL", false, getDisableBackpacksComment("large")).getBoolean(false);
        DISABLE_BACKPACKS_WB_S = config.get(Configuration.CATEGORY_GENERAL, "disableBackpacksWorkbenchS", false, getDisableBackpacksComment("small workbench")).getBoolean(false);
        DISABLE_BACKPACKS_WB_M = config.get(Configuration.CATEGORY_GENERAL, "disableBackpacksWorkbenchM", false, getDisableBackpacksComment("medium workbench")).getBoolean(false);
        DISABLE_BACKPACKS_WB_L = config.get(Configuration.CATEGORY_GENERAL, "disableBackpacksWorkbenchL", false, getDisableBackpacksComment("large workbench")).getBoolean(false);
        DISABLE_BACKPACKS_E = config.get(Configuration.CATEGORY_GENERAL, "disableBackpacksEnder", false, getDisableBackpacksComment("ender")).getBoolean(false);
        DISALLOW_ITEMS = config.get(Configuration.CATEGORY_GENERAL, "disallowItems", "", getDisallowItemsComment()).getString();
        GUI_TEXT_COLOR = config.get(Configuration.CATEGORY_GENERAL, "guiTextColor", "0x000000", getGuiTextColorComment()).getString();
        GUITextColor = Integer.decode( GUI_TEXT_COLOR );

        if((GUITextColor < 0x000000) || (GUITextColor > 0xFFFFFF)) {
            GUI_TEXT_COLOR = "0x000000";
            GUITextColor = 0x000000;
        }

        if(config.hasChanged()) {
            config.save();
        }
    }

    private static String getUseEnderEyeComment() {
        return (COMMENT_BORDER + "If true, ender backpacks will require an ender eye instead of ender chest.\n" + COMMENT_BORDER);
    }

    private static String getMaxBackpackAmountComment() {
        return (COMMENT_BORDER + "Number of backpacks players can have in their inventory.\n" + "valid: integers 0-36\n" + "0 = unlimited\n" + COMMENT_BORDER);
    }

    private static String getRenderBackpackModelComment() {
        return (COMMENT_BORDER + "If true, the backpack 3D model will be rendered.\n" + COMMENT_BORDER);
    }

    private static String getOpenOnlyWornBackpacksComment() {
        return (COMMENT_BORDER + "If true, you can only open a backpack being worn in the backpack slot.\n" + COMMENT_BORDER);
    }

    private static String getAirshipModCompatibilityComment() {
        return (COMMENT_BORDER + "If true, the small backpack recipe requires a chest in the middle.\n" + COMMENT_BORDER);
    }

    private static String getDisableBackpacksComment(String tier) {
        return (COMMENT_BORDER + "If true, " + tier + " backpacks are not craftable.\n" + COMMENT_BORDER);
    }

    private static String getDisallowItemsComment() {
        return (COMMENT_BORDER + "Example:\n" + "disallowItems:1,5:2,ingotSilver\n\n" + "This will disallow stone, birch wood planks, and any type of silver ingots in backpacks.\n" + COMMENT_BORDER);
    }

    private static String getGuiTextColorComment() {
        return (COMMENT_BORDER + "Text color used in the various GUI windows.\n" + "Valid: String ('0xRRGGBB')\n" + COMMENT_BORDER);
    }
}

