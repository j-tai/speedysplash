package ca.jtai.speedysplash.mixin;

import net.minecraft.client.gui.screen.SplashScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SplashScreen.class)
public class SplashScreenMixin {
    @Shadow private long applyCompleteTime;

    @Inject(method = "render", at = @At("HEAD"))
    private void onRender(CallbackInfo info) {
        // Disable the fade-out animation of the Mojang logo
        if (applyCompleteTime >= 0) {
            applyCompleteTime = 0;
        }
    }
}
