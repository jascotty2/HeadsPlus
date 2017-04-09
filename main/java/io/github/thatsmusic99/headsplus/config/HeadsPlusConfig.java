package io.github.thatsmusic99.headsplus.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import io.github.thatsmusic99.headsplus.HeadsPlus;

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
		getMessages().addDefault("reload-fail", "&cConfig failed to reload.");
		getMessages().addDefault("head-interact-message", "&3That is &b%p&3''s &3head!");
		getMessages().addDefault("head-mhf-interact-message", "&3That is a &b%p&3''s &3head!");
		getMessages().addDefault("sell-success", "&3Head sold successfully!");
		getMessages().addDefault("sell-fail", "&cCouldn''t sell head!");
		getMessages().addDefault("false-head", "&cThis head cannot be sold!");
		getMessages().addDefault("false-item", "&cThis is not a head!");
		getMessages().addDefault("blacklist-head", "&cThis head is blacklisted and cannot be used!");
		getMessages().addDefault("full-inv", "&cYour inventory is full!");
		getMessages().addDefault("alpha-names", "&cThis command only handles alphanumeric names!");
		getMessages().addDefault("too-many-args", "&cToo many arguments!");
		getMessages().addDefault("head-too-long", "&cIGN is too long to be valid! Please use an IGN between 3 and 16 characters.");
		getMessages().addDefault("too-short-head", "&cIGN is too short to be valid! Please use an IGN between 3 and 16 characters.");
		getMessages().addDefault("invalid-pg-no", "&cInvalid page number!");
		getMessages().addDefault("invalid-input-int", "&cYou can only use integers in this command!");
		getMessages().addDefault("purged-data", "&3Data has been purged.");
		getMessages().addDefault("purge-fail", "&cFailed to purge data.");
		getMessages().addDefault("no-perm", "&cYou do not have permission to use this command.");
		getMessages().addDefault("head-a-add", "&3This head is already added!");
		getMessages().addDefault("head-added", "&3%p has been added to the blacklist!");
		getMessages().addDefault("head-a-removed", "&3This head is not on the blacklist!");
		getMessages().addDefault("head-removed", "&3%p has been removed from the blacklist!");
		getMessages().addDefault("world-a-add", "&3This world is already added!");
		getMessages().addDefault("world-added", "&3%w has been added to the world blacklist!");
		getMessages().addDefault("world-a-removed", "&3This world is not on the blacklist!");
		getMessages().addDefault("world-removed", "&3%w has been removed from the blacklist!");
		getMessages().addDefault("disabled", "&cThis command is disabled.");
		getMessages().options().copyDefaults(true);
		saveMessages();
		
		// TODO Finish messages.
	}
	public static void reloadMessages() {
		if (messagesF == null) {
			messagesF = new File(HeadsPlus.getInstance().getDataFolder(), "messages.yml");
		}
		messages = YamlConfiguration.loadConfiguration(messagesF);
		loadMessages();
		saveMessages();
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
