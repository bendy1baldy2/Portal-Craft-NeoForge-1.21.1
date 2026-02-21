package com.bendy1baldy222.portalcraft.item;

import com.bendy1baldy222.portalcraft.PortalCraft;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PortalGunItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PortalCraft.MOD_ID);

    public static final DeferredItem<Item> PORTALGUNBLUE = ITEMS.register("portalgunblue",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PORTALGUNORANGE = ITEMS.register("portalgunorange",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}