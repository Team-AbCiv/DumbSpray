package info.tritusk.modpack.dumbspray;

import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreIngredient;

import java.util.Objects;

@Mod(modid = "dumb_spray", name = "DumbSpray", version = "0.1.0", useMetadata = true)
@Mod.EventBusSubscriber
public final class DumbSprayMod {

    @SubscribeEvent
    public static void potionReg(RegistryEvent.Register<Potion> event) {
        event.getRegistry().registerAll(
                new RegularDumbPotion().setPotionName("effect.dumb_spray.regular_dumbness").setRegistryName("dumb_spray", "regular_dumbness"),
                new SuperDumbPotion().setPotionName("effect.dumb_spray.super_dumbness").setRegistryName("dumb_spray", "super_dumbness")
        );
    }

    @SubscribeEvent
    public static void potionTypeReg(RegistryEvent.Register<PotionType> event) {
        Potion regularDumb = ForgeRegistries.POTIONS.getValue(new ResourceLocation("dumb_spray", "regular_dumbness"));
        Potion superDumb = ForgeRegistries.POTIONS.getValue(new ResourceLocation("dumb_spray", "super_dumbness"));
        event.getRegistry().registerAll(
                new PotionType("regular_dumbness", new PotionEffect(Objects.requireNonNull(regularDumb, "Can't find Regular Dumbness Potion"), 1)).setRegistryName("dumb_spray", "regular_dumbness"),
                new PotionType("super_dumbness", new PotionEffect(Objects.requireNonNull(superDumb, "Can't find Super Dumbness Potion"), 1)).setRegistryName("dumb_spray", "super_dumbness")
        );
    }

    @SubscribeEvent
    public static void crafting(RegistryEvent.Register<IRecipe> event) {
        if (DumbSprayConfig.addBrewingRecipes) {
            PotionType regularDumb = ForgeRegistries.POTION_TYPES.getValue(new ResourceLocation("dumb_spray", "regular_dumbness"));
            PotionHelper.addMix(PotionTypes.AWKWARD, Items.SLIME_BALL, Objects.requireNonNull(regularDumb, "Can't find Regular Dumbness PotionType"));
            PotionType superDumb = ForgeRegistries.POTION_TYPES.getValue(new ResourceLocation("dumb_spray", "super_dumbness"));
            PotionHelper.addMix(regularDumb, new OreIngredient("gemEmerald"), Objects.requireNonNull(superDumb, "Can't find Super Dumbness PotionType"));
        }
    }

}
