package me.mrgraycat.eglowaddon;

import lombok.Getter;
import lombok.Setter;
import me.mrgraycat.eglowaddon.channel.EGlowChannel;
import me.mrgraycat.eglowaddon.expansions.TABExpansion;
import me.mrgraycat.eglowaddon.util.ChatUtil;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public final class EGlowAddon extends Plugin {
	@Getter
	public static EGlowAddon instance;

	@Getter
	@Setter
	private TABExpansion tabExpansion;

	@Override
	public void onEnable() {
		ChatUtil.sendToConsole("&f[&eeGlow-Addon&f] Enabling ProxyExtension.");
		instance = this;
		ProxyServer.getInstance().getPluginManager().registerListener(this, new EGlowChannel());
		ProxyServer.getInstance().registerChannel("eglow:bungee");

		if (ProxyServer.getInstance().getPluginManager().getPlugin("TAB") != null)
			setTabExpansion(new TABExpansion());
	}
}