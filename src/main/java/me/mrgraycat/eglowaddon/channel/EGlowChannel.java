package me.mrgraycat.eglowaddon.channel;

import me.mrgraycat.eglowaddon.EGlowAddon;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.UUID;

public class EGlowChannel implements Listener {
	@EventHandler
	public void onPluginMessageReceive(PluginMessageEvent e) {
		if (!e.getTag().equalsIgnoreCase("eglow:bungee"))
			return;

		DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(e.getData()));

		try {
			if ("TABProxyUpdateRequest".equals(dataInputStream.readUTF())) {
				if (EGlowAddon.getInstance().getTabExpansion() != null)
					EGlowAddon.getInstance().getTabExpansion().updateColor(UUID.fromString(dataInputStream.readUTF()), dataInputStream.readUTF());
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
}