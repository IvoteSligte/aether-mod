package com.github.ivotesligte.aether;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AetherMod implements ModInitializer {
	public static final String MOD_ID = "aether";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final RegistryKey<DimensionOptions> AETHER_DIMENSION_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            Identifier.of(AetherMod.MOD_ID, "aether_dimension"));
    public static final RegistryKey<World> AETHER_DIMENSION_WORLD = RegistryKey.of(RegistryKeys.WORLD,
            Identifier.of(AetherMod.MOD_ID, "aether_dimension"));
    public static final RegistryKey<DimensionType> AETHER_DIMENSION_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            Identifier.of(AetherMod.MOD_ID, "aether_dimension"));
    
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Initializing.");
        AetherCommands.register();
        CustomPortalBuilder.beginPortal()  
            .frameBlock(Blocks.GOLD_BLOCK)
            .destDimID(AETHER_DIMENSION_KEY.getValue())  
            .tintColor(45,65,101)
            .registerPortal();
        
        LOGGER.info("Finished initializing.");
	}
}
