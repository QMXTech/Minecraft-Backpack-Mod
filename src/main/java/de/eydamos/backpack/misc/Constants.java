package de.eydamos.backpack.misc;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.util.ResourceLocation;
import de.eydamos.backpack.model.ModelBackpack;

public class Constants {
    public static final String MOD_ID = "QMXBackpacks";
    public static final String MOD_NAME = "QMXBackpacks";
    public static final String MOD_VERSION = "1.0.0";
    public static final String FINGERPRINT = "@FINGERPRINT@";

    public static final String DOMAIN = "backpack";

    public static final String RECIPE_RECOLOR = DOMAIN + ":recolorBackpack";
    public static final String RECIPE_INTELLIGENT = DOMAIN + ":intelligentWorkbench";

    public static final String CLASS_PROXY_CLIENT = "de.eydamos.backpack.proxy.ClientProxy";
    public static final String CLASS_PROXY_SERVER = "de.eydamos.backpack.proxy.ServerProxy";
    public static final String CLASS_GUI_FACTORY = "de.eydamos.backpack.factory.FactoryConfigurationGui";

    public static final String UPDATE_FILE = "http://www.eydamos.de/minecraft/backpack/version.json";

    public static final ResourceLocation guiCombined = new ResourceLocation(DOMAIN, "textures/gui/guiCombined.png");
    public static final ResourceLocation modelTexture = new ResourceLocation(DOMAIN, "textures/model/backpack.png");

    public static final ModelBiped model = new ModelBackpack();

    public class Guis {
        public static final byte OPEN_PERSONAL_BACKPACK = 0;
        public static final byte OPEN_PERSONAL_SLOT = 1;
    }

    public class GuiCommands {
        public static final byte CLEAR = 1;
        public static final byte SAVE = 2;
        public static final byte PREV = 3;
        public static final byte NEXT = 4;
    }

    public class NBT {
        public static final String INVENTORIES = "backpackInventories";
        public static final String INVENTORY_BACKPACK = "backpack";
        public static final String INVENTORY_PERSONAL_BACKPACK = "personalBackpack";
        public static final String INVENTORY_PICKUP_ITEMS = "pickupItems";
        public static final String INVENTORY_CRAFTING_GRID = "craftingGrid";
        public static final String INVENTORY_RECIPES = "recipes";
        public static final String INVENTORY_RECIPE = "recipe-";
        public static final String UID = "backpack-UID";
        public static final String NAME = "name";
        public static final String CUSTOM_NAME = "customName";
        public static final String SIZE = "size";
        public static final String SLOT = "slot";
        public static final String SLOTS_PER_ROW = "slotsPerRow";
        public static final String INTELLIGENT = "intelligent";
        public static final String TYPE = "type";
        public static final String PERSONAL_BACKPACK_OPEN = "personalBackpackOpen";
    }

    public class NBTTypes extends net.minecraftforge.common.util.Constants.NBT {}
}

