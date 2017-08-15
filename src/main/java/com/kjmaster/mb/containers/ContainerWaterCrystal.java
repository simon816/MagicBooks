package com.kjmaster.mb.containers;

import com.kjmaster.mb.tileentities.crystals.TileEntityWaterCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by pbill_000 on 06/08/2017.
 */
public class ContainerWaterCrystal extends Container {
    private IInventory playerInv;
    private TileEntityWaterCrystal te;
    private int mana;
    public ContainerWaterCrystal(IInventory playerInv, TileEntityWaterCrystal te) {
        this.te = te;
        this.playerInv = playerInv;
        // Player Inventory, Slot 9-35, Slot IDs 0-26
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }

        // Player Inventory, Slot 0-8, Slot IDs 27-35
        for (int x = 0; x < 9; ++x) {
            this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return !playerIn.isSpectator();
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for(int i = 0; i < this.listeners.size(); i++) {
            IContainerListener icontainerlistener = (IContainerListener) this.listeners.get(i);

            if(this.mana != this.te.getField(0)) {
                icontainerlistener.sendWindowProperty(this, 0, this.te.getField(0));
            }
        }
        this.mana = this.te.storage.getManaStored();
    }


    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int id, int data) {
        super.updateProgressBar(id, data);
        this.te.setField(id, data);
    }
}
