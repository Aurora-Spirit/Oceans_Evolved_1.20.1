package net.aurora_spirit.oceans_evolved.item;

import net.aurora_spirit.oceans_evolved.OceansEvolved;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OceansEvolved.MOD_ID);


    public static final RegistryObject<Item> SEASHELL = ITEMS.register("seashell",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        //add items to vanilla creative inventory tabs
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(SEASHELL);
        }
    }

    public static void addModCreative(CreativeModeTab.ItemDisplayParameters pParameters, CreativeModeTab.Output pOutput) {
        //add items to the mod's creative tab
        pOutput.accept(SEASHELL.get());
    }


}
