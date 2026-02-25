package com.github.ivotesligte.aether;

import com.github.ivotesligte.aether.AetherMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.attribute.EnvironmentAttributeMap;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;

public class AetherDimension {
    public static final RegistryKey<DimensionOptions> AETHER_DIMENSION_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            Identifier.of(AetherMod.MOD_ID, "aether_dimension"));
    public static final RegistryKey<World> AETHER_DIMENSION_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            Identifier.of(AetherMod.MOD_ID, "aether_dimension"));
    public static final RegistryKey<DimensionType> AETHER_DIMENSION_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            Identifier.of(AetherMod.MOD_ID, "aether_dimension_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(AETHER_DIMENSION_TYPE, new DimensionType(
            true, // hasFixedTime
            false, // hasSkylight
            false, // hasCeiling
            1.0, // coordinateScale
            0, // minY
            256, // height
            256, // logicalHeight
            BlockTags.INFINIBURN_OVERWORLD, // infiniburn
            1.0f, // ambientLight
            new DimensionType.MonsterSettings(UniformIntProvider.create(0, 0), 0), // monsterSettings
            DimensionType.Skybox.OVERWORLD, // skybox
DimensionType.CardinalLightType.DEFAULT, // cardinalLightType
EnvironmentAttributeMap.EMPTY, // attributes
RegistryEntryList.empty() // timelines
        ));
    }
}
