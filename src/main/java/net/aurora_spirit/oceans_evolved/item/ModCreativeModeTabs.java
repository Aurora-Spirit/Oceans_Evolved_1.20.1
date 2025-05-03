package net.aurora_spirit.oceans_evolved.item;

import net.aurora_spirit.oceans_evolved.OceansEvolved;
import net.aurora_spirit.oceans_evolved.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OceansEvolved.MOD_ID);



    public static final RegistryObject<CreativeModeTab> OCEANS_EVOLVED = CREATIVE_MODE_TABS.register("oceans_evolved",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SEASHELL.get()))
                    .title(Component.translatable("creativetab.oceans_evolved"))
                    .displayItems((pParameters,pOutput) -> {
                        ModItems.addModCreative(pParameters,pOutput);
                        ModBlocks.addModCreative(pParameters,pOutput);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
