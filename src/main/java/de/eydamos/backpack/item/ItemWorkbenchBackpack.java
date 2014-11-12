package de.eydamos.backpack.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.eydamos.backpack.misc.Localizations;
import de.eydamos.backpack.saves.BackpackSave;

public class ItemWorkbenchBackpack extends ItemBackpackBase {
    protected IIcon[] icons;

    public ItemWorkbenchBackpack() {
        super();
        setUnlocalizedName(ItemsBackpack.UNLOCALIZED_NAME_BACKPACK_WORKBENCH);
    }

    /**
     * Gets the icon from the registry.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        icons = new IIcon[3];
        icons[0] = iconRegister.registerIcon("backpack:backpack_workbench_small");
        icons[1] = iconRegister.registerIcon("backpack:backpack_workbench_medium");
        icons[2] = iconRegister.registerIcon("backpack:backpack_workbench_large");
    }

    /**
     * Returns the icon index based on the item damage.
     * 
     * @param damage
     *            The damage to check for.
     * @return The icon index.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage) {
        IIcon result = icons[0];

        if(damage == 117) {
            result = icons[1];
        }
        if(damage == 217) {
            result = icons[2];
        }

        return result;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List information, boolean advancedTooltip) {
        super.addInformation(itemStack, entityPlayer, information, advancedTooltip);
        BackpackSave backpackSave = new BackpackSave(itemStack);
        if(backpackSave.isIntelligent()) {
            information.add(StatCollector.translateToLocal(Localizations.INTELLIGENT));
        }
    }
}

