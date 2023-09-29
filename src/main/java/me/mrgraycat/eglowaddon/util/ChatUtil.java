package me.mrgraycat.eglowaddon.util;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

public class ChatUtil {
	private static BaseComponent[] format(String msg) {
		return TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', msg));
	}

	public static void sendToConsole(String msg) {
		ProxyServer.getInstance().getConsole().sendMessage(format(msg));
	}
}