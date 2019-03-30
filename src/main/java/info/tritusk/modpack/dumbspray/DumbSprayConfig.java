package info.tritusk.modpack.dumbspray;

import net.minecraftforge.common.config.Config;

@Config(modid = "dumb_spray", name = "DumbSpray")
public final class DumbSprayConfig {

    @Config.Comment("Set it to false if you want to remove the default recipes for Potion of Dumbness.")
    @Config.LangKey("config.dumb_spray.enable_brewing_recipes")
    @Config.Name("EnableBrewingRecipes")
    @Config.RequiresMcRestart
    public static boolean addBrewingRecipes = true;

}
