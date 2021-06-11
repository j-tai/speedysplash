package ca.jtai.speedysplash.mixin;

import net.minecraft.client.gui.screen.SplashScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SplashScreen.class)
public class SplashScreenMixin {
    @Shadow private long reloadCompleteTime;

    @Inject(method = "render", at = @At("HEAD"))
    private void onRender(CallbackInfo info) {
        // Disable the fade-out animation of the Mojang logo
        if (reloadCompleteTime >= 0) {
            reloadCompleteTime = 0;
        }
    }
}
