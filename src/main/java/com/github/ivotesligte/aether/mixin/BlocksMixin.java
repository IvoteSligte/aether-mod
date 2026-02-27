package com.github.ivotesligte.aether.mixin;

import java.util.function.Function;

import com.github.ivotesligte.aether.AetherMod;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Blocks.class)
public abstract class BlocksMixin {
    @Inject(
        method = "register(Lnet/minecraft/registry/RegistryKey;Ljava/util/function/Function;Lnet/minecraft/block/AbstractBlock$Settings;Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfoReturnable;)Lnet/minecraft/block/Block;",
        at = @At("HEAD"),
        cancellable = false
    )
    private static void onRegister(RegistryKey<Block> key, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings, CallbackInfoReturnable<Block> cir) {
        if (key.getValue().equals(Identifier.ofVanilla("bedrock"))) {
            settings = settings.hardness(1.0F);
            AetherMod.LOGGER.info("Changed bedrock hardness.");
        }
    }
}
