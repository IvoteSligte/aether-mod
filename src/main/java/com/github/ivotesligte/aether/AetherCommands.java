package com.github.ivotesligte.aether;

import net.minecraft.server.world.ServerWorld;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import com.mojang.brigadier.context.CommandContext;
import java.util.Set;

import static net.minecraft.server.command.CommandManager.literal;

public class AetherCommands {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("aether-teleport")
                .executes(AetherCommands::aetherTeleport)
            );
        });
    }

    private static int aetherTeleport(CommandContext<ServerCommandSource> context) {
        ServerPlayerEntity player = context.getSource().getPlayer();
        ServerWorld world = context.getSource().getServer().getWorld(AetherMod.AETHER_DIMENSION_WORLD);
        if (world == null) {
            AetherMod.LOGGER.error("Tried to teleport, but the Aether world is null.");
        }
        player.teleport(world, 0.0, 0.0, 0.0, Set.of(), 0.0f, 0.0f, true);
        AetherMod.LOGGER.info("Teleported to the aether.");
        return 1;
    }
}
