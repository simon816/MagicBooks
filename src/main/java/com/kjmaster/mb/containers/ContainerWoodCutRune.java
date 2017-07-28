package com.kjmaster.mb.containers;


import com.kjmaster.mb.tileentities.TileEntityWoodCutRune;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nullable;

/**
 * Created by pbill_000 on 27/07/2017.
 */
public class ContainerWoodCutRune extends Container {

    private TileEntityWoodCutRune te;
    private IItemHandler handler;

    public ContainerWoodCutRune(IInventory playerInv, TileEntityWoodCutRune te) {
        this.te = te;
        this.handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        this.addSlotToContainer(new SlotItemHandler(handler, 0, 80, 35));
        int xPos = 8;
        int yPos = 84;

        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, xPos + x * 18, yPos + y * 18));
            }
        }
        for (int x = 0; x < 9; ++x) {
            this.addSlotToContainer(new Slot(playerInv, x, xPos + x * 18, yPos + 58));
        }


    }
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return !playerIn.isSpectator();
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
        ItemStack previous = ItemStack.EMPTY;
        Slot slot = (Slot) this.inventorySlots.get(fromSlot);

        if (slot != null && slot.getHasStack()) {
            ItemStack current = slot.getStack();
            previous = current.copy();

            if (fromSlot < this.handler.getSlots()) {
                if (!this.mergeItemStack(current, handler.getSlots(), handler.getSlots() + 36, true))
                    return ItemStack.EMPTY;
            } else {
                if (!this.mergeItemStack(current, 0, handler.getSlots(), false))
                    return ItemStack.EMPTY;
            }

            if (current.getCount() == 0) //Use func_190916_E() instead of stackSize 1.11 only 1.11.2 use getCount()
                slot.putStack(ItemStack.EMPTY); //Use ItemStack.field_190927_a instead of (ItemStack)null for a blank item stack. In 1.11.2 use ItemStack.EMPTY
            else
                slot.onSlotChanged();

            if (current.getCount() == previous.getCount())
                return null;
            slot.onTake(playerIn, current);
        }
        return previous;
    }

    @Nullable
    @Override
    public Slot getSlotFromInventory(IInventory inv, int slotIn) {
        return super.getSlotFromInventory(inv, slotIn);
    }

    @Override
    public Slot getSlot(int slotId) {
        return super.getSlot(slotId);
    }

    @Override
    public boolean getCanCraft(EntityPlayer player) {
        return false;
    }

}
