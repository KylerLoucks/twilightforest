package twilightforest.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.DownloadTerrainScreen;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import twilightforest.world.TFDimensions;

@OnlyIn(Dist.CLIENT)
public class LoadingScreenListener {

	private final Minecraft client = Minecraft.getInstance();
	private RegistryKey<World> lastDimension = World.field_234918_g_; //overworld

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END && event.player == client.player) {
			lastDimension = event.player.getEntityWorld().func_234923_W_();
		}
	}

	@SubscribeEvent
	public void onOpenGui(GuiOpenEvent event) {
		if (event.getGui() instanceof DownloadTerrainScreen && client.player != null) {
			RegistryKey<World> tfDimension = TFDimensions.twilight_forest_world;
			if (client.player.getEntityWorld().func_234923_W_() == tfDimension || lastDimension == tfDimension) {
				GuiTwilightForestLoading guiLoading = new GuiTwilightForestLoading();
				guiLoading.setEntering(client.player.getEntityWorld().func_234923_W_() == tfDimension);
				event.setGui(guiLoading);
			}
		}
	}
}
