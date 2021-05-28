package ca.jtai.speedysplash.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Redirect(
        method = "<init>",
        at = @At(value = "NEW", target = "net/minecraft/client/gui/screen/TitleScreen")
    )
    private TitleScreen newTitleScreenProxy(boolean doBackgroundFade) {
        // Never do the background fade when creating a title screen
        return new TitleScreen(false);
    }
}
