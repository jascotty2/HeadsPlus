package io.github.thatsmusic99.headsplus;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class HeadsPlusConfig {
	private static FileConfiguration messages;
	public static File messagesF;
	
	public static FileConfiguration getMessages() {
		return messages;
	}
	public static void msgEnable() {
		reloadMessages();
		loadMessages();
	}
	
	private static void loadMessages() {
		getMessages().options().header("HeadsPlus by Thatsmusic99");
		getMessages().addDefault("prefix", "&1[&6HeadsPlus&1]");
		getMessages().addDefault("reloading-message", "&3Reloading config...");
		getMessages().addDefault("reload-message", "&3Config has reloaded!");
		getMessages().addDefault("head-interact-message", "&3That is &b%p&3''s head!");
		getMessages().addDefault("head-mhf-interact-message", "&3That is a &b%p''s head!");
		getMessages().addDefault("sell-success", "&3Head sold successfully!");
		getMessages().addDefault("sell-fail", "&cCouldn't sell head!");
		getMessages().addDefault("false-head", "&cThis head cannot be sold!");
		getMessages().options().copyDefaults(true);
		saveMessages();
	}
	public static void reloadMessages() {
		if (messagesF == null) {
			messagesF = new File(HeadsPlus.getInstance().getDataFolder(), "messages.yml");
		}
		messages = YamlConfiguration.loadConfiguration(messagesF);
	}
    public static void saveMessages() {
    	if (messages == null || messagesF == null) {
    		return;
    	}
    	try {
    		messages.save(messagesF);
    	} catch (IOException e) {
    		HeadsPlus.getInstance().log.severe("[HeadsPlus] Couldn't save messages.yml!");
    		e.printStackTrace();
    	}
    }

}