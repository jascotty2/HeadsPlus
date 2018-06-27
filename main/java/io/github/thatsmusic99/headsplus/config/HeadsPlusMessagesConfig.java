package io.github.thatsmusic99.headsplus.config;

import io.github.thatsmusic99.headsplus.HeadsPlus;
import io.github.thatsmusic99.headsplus.locale.Locale;
import io.github.thatsmusic99.headsplus.locale.LocaleManager;
import io.github.thatsmusic99.headsplus.locale.en_uk;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class HeadsPlusMessagesConfig extends ConfigSettings {

	public HeadsPlusMessagesConfig(boolean nullpoint) {
	    this.conName = "messages";
        enable(nullpoint);
    }

	@Override
	public void load(boolean nullpoint) {

		getConfig().options().header("HeadsPlus by Thatsmusic99 \nPlease do NOT change pLocale! This will be used to change the plugin's language in the future!");

		getConfig().addDefault("prefix", "&1[&6HeadsPlus&1]");
		getConfig().addDefault("locale", "en_uk");
		getConfig().addDefault("pLocale", "en_uk");
		getConfig().addDefault("reloading-message", "%h &3Reloading config...");
		getConfig().addDefault("reload-message", "%h &3Config has reloaded!");
		getConfig().addDefault("head-interact-message", "&3That is &b%p&3''s &3head!");
		getConfig().addDefault("head-mhf-interact-message", "&3That is a &b%p&3''s head!");
		getConfig().addDefault("head-mhf-interact-message-2", "&3That is an &b%p&3''s &3head!");
		getConfig().addDefault("sell-success", "&3You successfully sold the head(s) for &b%l &3and now have &b%b!");
		getConfig().addDefault("not-enough-heads", "&cYou don't have enough heads!");
		getConfig().addDefault("no-heads", "&cYou don't have any valid heads in your inventory!");
		getConfig().addDefault("invalid-args", "&cInvalid arguments!");
		getConfig().addDefault("false-head", "&cThis head cannot be sold!");
		getConfig().addDefault("false-item", "&cThis is not a head!");
		getConfig().addDefault("blacklist-head", "&cThis head is blacklisted and cannot be used!");
		getConfig().addDefault("whitelist-head", "&cThis head isn't whitelisted and therefore cannot be used!");
		getConfig().addDefault("full-inv", "&cYour inventory is full!");
		getConfig().addDefault("alpha-names", "&cThis command only handles alphanumeric names!");
		getConfig().addDefault("too-many-args", "&cToo many arguments!");
		getConfig().addDefault("head-too-long", "&cIGN is too long to be valid! Please use an IGN between 3 and 16 characters.");
		getConfig().addDefault("too-short-head", "&cIGN is too short to be valid! Please use an IGN between 3 and 16 characters.");
		getConfig().addDefault("invalid-pg-no", "%h &cInvalid page number!");
		getConfig().addDefault("invalid-input-int", "%h &cYou can only use integers in this command!");
		getConfig().addDefault("no-perm", "&cYou do not have permission to use this command.");
		getConfig().addDefault("head-a-add", "%h &3This head is already added!");
		getConfig().addDefault("head-added-bl", "%h &3%p has been added to the blacklist!");
		getConfig().addDefault("head-a-removed-bl", "%h &3This head is not on the blacklist!");
		getConfig().addDefault("head-removed-bl", "%h &3%p has been removed from the blacklist!");
		getConfig().addDefault("head-added-wl", "%h &3%p has been added to the whitelist!");
		getConfig().addDefault("head-a-removed-wl", "%h &3This head is not on the whitelist!");
		getConfig().addDefault("head-removed-wl", "%h &3%p has been removed from the whitelist!");
		getConfig().addDefault("world-a-add", "%h &3This world is already added!");
		getConfig().addDefault("world-added-bl", "%h &3%w has been added to the world blacklist!");
		getConfig().addDefault("world-a-removed-bl", "%h &3This world is not on the blacklist!");
		getConfig().addDefault("world-removed-bl", "%h &3%w has been removed from the blacklist!");
		getConfig().addDefault("world-added-wl", "%h &3%w has been added to the world whitelist!");
		getConfig().addDefault("world-a-removed-wl", "%h &3This world is not on the whitelist!");
		getConfig().addDefault("world-removed-wl", "%h &3%w has been removed from the whitelist!");
		getConfig().addDefault("bl-on", "%h &3The blacklist has been enabled!");
		getConfig().addDefault("bl-a-on", "%h &3The blacklist is already enabled!");
		getConfig().addDefault("bl-off", "%h &3The blacklist has been disabled!");
		getConfig().addDefault("bl-a-off", "%h &3The blacklist is already disabled!");
		getConfig().addDefault("blw-on", "%h &3The world blacklist has been enabled!");
		getConfig().addDefault("blw-a-on", "%h &3The world blacklist is already enabled!");
		getConfig().addDefault("blw-off", "%h &3The world blacklist has been disabled!");
		getConfig().addDefault("blw-a-off", "%h &3The world blacklist is already disabled!");
		getConfig().addDefault("wl-on", "%h &3The whitelist has been enabled!");
		getConfig().addDefault("wl-a-on", "%h &3The whitelist is already enabled!");
		getConfig().addDefault("wl-off", "%h &3The whitelist has been disabled!");
		getConfig().addDefault("wl-a-off", "%h &3The whitelist is already disabled!");
		getConfig().addDefault("wlw-on", "%h &3The world whitelist has been enabled!");
		getConfig().addDefault("wlw-a-on", "%h &3The world whitelist is already enabled!");
		getConfig().addDefault("wlw-off", "%h &3The world whitelist has been disabled!");
		getConfig().addDefault("wlw-a-off", "%h &3The world whitelist is already disabled!");
		getConfig().addDefault("disabled", "&cThis command is disabled.");
		getConfig().addDefault("empty-bl", "%h &cThe blacklist is empty!");
		getConfig().addDefault("empty-blw", "%h &cThe world blacklist is empty!");
		getConfig().addDefault("empty-wl", "%h &cThe whitelist is empty!");
		getConfig().addDefault("empty-wlw", "%h &cThe world whitelist is empty!");
		getConfig().addDefault("buy-success", "&3You have bought a head for &b%l &3and now have &b%b!");
        getConfig().addDefault("update-found", "%h &3An update has been found for HeadsPlus!");
        getConfig().addDefault("xmas-denied", "&cIt isn't that date yet!");
        getConfig().addDefault("block-place-denied", "&cYou can not place sellable heads!");
        getConfig().addDefault("no-data-lb", "&cNo leaderboard data has been recorded yet!");
        getConfig().addDefault("player-offline", "&cThat player is offline!");
        getConfig().addDefault("challenge-complete", "%h &b%p &3has completed the &b%c &3challenge!");
        getConfig().addDefault("no-data", "&cThere is no data for that player!");
        getConfig().addDefault("cant-complete-challenge", "&cYou can't complete this challenge!");
        getConfig().addDefault("already-complete-challenge", "&cYou've already completed that challenge!");
        getConfig().addDefault("cant-view-data", "&cYou can't view your own data in console!");
        getConfig().addDefault("level-up", "%h &3%p has reached level %lvl&3!");
        getConfig().addDefault("cmd-fail","%h &cFailed to run this command!");
        getConfig().addDefault("plugin-up-to-date", "%h &3Plugin is up to date!");
        getConfig().addDefault("plugin-enabled", "%h &3HeadsPlus has been enabled!");
        getConfig().addDefault("plugin-fail", "%h &cHeadsPlus has failed to start up correctly. An error report has been made in /plugins/HeadsPlus/debug");
        getConfig().addDefault("plugin-disabled", "%h &3HeadsPlus has been disabled!");
        getConfig().addDefault("faulty-theme", "%h &3Faulty theme was put in! No theme changes will be made.");
        getConfig().addDefault("no-vault", "%h &cVault not found! Heads cannot be sold and challenge rewards can not add/remove groups.");
        getConfig().addDefault("no-vault-2", "Vault wasn't found upon startup! Can not add group.");
        getConfig().addDefault("no-name-data", new en_uk().noNameData());
        getConfig().addDefault("no-lore-data", new en_uk().noLoreData());
        getConfig().addDefault("no-mask-data", new en_uk().noMaskData());
        getConfig().addDefault("set-value", new en_uk().setValue());
        getConfig().addDefault("add-value", new en_uk().addedValue());
        getConfig().addDefault("remove-value", new en_uk().removedValue());

        if (!getConfig().getString("locale").equalsIgnoreCase(getConfig().getString("pLocale")) && !nullpoint) {
            getConfig().set("pLocale", getConfig().getString("locale"));
            LocaleManager.getInstance().setupLocale();
            Locale l = LocaleManager.getLocale();
            getConfig().set("reloading-message", l.getReloadingMessage());
            getConfig().set("reload-message", l.getReloadMessage());
            getConfig().set("head-interact-message", l.getHeadInteractMessage());
            getConfig().set("head-mhf-interact-message", l.getHeadMhfInteractMessage());
            getConfig().set("head-mhf-interact-message-2", l.getHeadMhfInteractMessage2());
            getConfig().set("sell-success", l.getSellSuccess());
            getConfig().set("not-enough-heads", l.getNotEnoughHeads());
            getConfig().set("no-heads", l.getNoHeads());
            getConfig().set("invalid-args", l.getInvalidArguments());
            getConfig().set("false-head", l.getFalseHead());
            getConfig().set("false-item", l.getFalseItem());
            getConfig().set("blacklist-head", l.getBlacklistHead());
            getConfig().set("whitelist-head", l.getWhitelistHead());
            getConfig().set("full-inv", l.getFullInventory());
            getConfig().set("alpha-names", l.getAlphaNames());
            getConfig().set("too-many-args", l.getTooManyArguments());
            getConfig().set("head-too-long", l.getHeadTooLong());
            getConfig().set("too-short-head", l.getHeadTooShort());
            getConfig().set("invalid-pg-no", l.getInvalidPageNumber());
            getConfig().set("invalid-input-int", l.getInvalidInputInteger());
            getConfig().set("no-perm", l.getNoPermissions());
            getConfig().set("head-a-add", l.getHeadAlreadyAdded());
            getConfig().set("head-added-bl", l.getHeadAddedBlacklist());
            getConfig().set("head-a-removed-bl", l.getHeadNotOnBlacklist());
            getConfig().set("head-removed-bl", l.getHeadRemovedBlacklist());
            getConfig().set("head-added-wl", l.getHeadAddedWhitelist());
            getConfig().set("head-a-removed-wl", l.getHeadNotOnWhitelist());
            getConfig().set("head-removed-wl", l.getHeadRemovedWhitelist());
            getConfig().set("world-a-added", l.getWorldAlreadyAdded());
            getConfig().set("world-added-bl", l.getWorldAddedBlacklist());
            getConfig().set("world-a-removed-bl", l.getWorldNotOnBlacklist());
            getConfig().set("world-removed-bl", l.getWorldRemovedBlacklist());
            getConfig().set("world-added-wl", l.getWorldAddedWhitelist());
            getConfig().set("world-a-removed-wl", l.getWorldNotOnWhitelist());
            getConfig().set("world-removed-wl", l.getWorldRemovedWhitelist());
            getConfig().set("bl-on", l.getBlacklistOn());
            getConfig().set("bl-a-on", l.getBlacklistAlreadyOn());
            getConfig().set("bl-off", l.getBlacklistOff());
            getConfig().set("bl-a-off", l.getBlacklistAlreadyOff());
            getConfig().set("blw-on", l.getWBlacklistOn());
            getConfig().set("blw-a-on", l.getWBlacklistAlreadyOn());
            getConfig().set("blw-off", l.getWBlacklistOff());
            getConfig().set("blw-a-off", l.getWBlacklistAlreadyOff());
            getConfig().set("wl-on", l.getWhitelistOn());
            getConfig().set("wl-a-on", l.getWhitelistAlreadyOn());
            getConfig().set("wl-off", l.getWhitelistOff());
            getConfig().set("wl-a-off", l.getWhitelistAlreadyOff());
            getConfig().set("wlw-on", l.getWWhitelistOn());
            getConfig().set("wlw-a-on", l.getWWhitelistAlreadyOn());
            getConfig().set("wlw-off", l.getWWhitelistOff());
            getConfig().set("wlw-a-off", LocaleManager.getLocale().getWWhitelistAlreadyOff());
            getConfig().set("disabled", LocaleManager.getLocale().getDisabledCommand());
            getConfig().set("empty-bl", LocaleManager.getLocale().getEmptyBlacklist());
            getConfig().set("empty-blw", LocaleManager.getLocale().getEmptyWBlacklist());
            getConfig().set("empty-wl", LocaleManager.getLocale().getEmptyWhitelist());
            getConfig().set("empty-wlw", LocaleManager.getLocale().getEmptyWWhitelist());
            getConfig().set("buy-success", LocaleManager.getLocale().getBuySuccess());
            getConfig().set("xmas-denied", LocaleManager.getLocale().getChristmasDeniedMessage());
            getConfig().set("block-place-denied", LocaleManager.getLocale().getBlockPlaceDenied());
            getConfig().set("no-data-lb", LocaleManager.getLocale().getNoDataRecorded());
			getConfig().set("update-found", LocaleManager.getLocale().getUpdateFound());
			getConfig().set("player-offline", LocaleManager.getLocale().getPlayerOffline());
			getConfig().set("challenge-complete", LocaleManager.getLocale().chCompleteMessage());
			getConfig().set("no-data", LocaleManager.getLocale().noData());
			getConfig().set("cant-complete-challenge", LocaleManager.getLocale().cantCompleteChallenge());
			getConfig().set("already-complete-challenge", LocaleManager.getLocale().alreadyCompleted());
			getConfig().set("cant-view-data", LocaleManager.getLocale().cantViewData());
			getConfig().set("level-up", LocaleManager.getLocale().getAchievedNextLevel());
			getConfig().set("cmd-fail", LocaleManager.getLocale().getCommandFail());
            getConfig().set("plugin-up-to-date", LocaleManager.getLocale().getPluginUpToDate());
            getConfig().set("plugin-enabled", LocaleManager.getLocale().getEnabled());
            getConfig().set("plugin-fail", LocaleManager.getLocale().getErrorEnabled());
            getConfig().set("plugin-disabled", LocaleManager.getLocale().getDisabled());
            getConfig().set("faulty-theme", LocaleManager.getLocale().badTheme());
            getConfig().set("no-vault", LocaleManager.getLocale().noVault());
            getConfig().addDefault("no-vault-2", LocaleManager.getLocale().noVaultGroup());
            getConfig().addDefault("no-name-data", LocaleManager.getLocale().noNameData());
            getConfig().addDefault("no-lore-data", LocaleManager.getLocale().noLoreData());
            getConfig().addDefault("no-mask-data", LocaleManager.getLocale().noMaskData());
            getConfig().addDefault("set-value", LocaleManager.getLocale().setValue());
            getConfig().addDefault("add-value", LocaleManager.getLocale().addedValue());
            getConfig().addDefault("remove-value", LocaleManager.getLocale().removedValue());
        }
        updateMessages();
		getConfig().options().copyDefaults(true);
		save();
	}

	public String getString(String path) {
	    String str = getConfig().getString(path);
	    if (str == null) return "";
	    str = str.replaceAll("\\{header}", getConfig().getString("prefix"));
	    str = str.replaceAll("''", "'");
	    str = str.replaceAll("^'", "");
	    str = str.replaceAll("'$", "");
	    str = ChatColor.translateAlternateColorCodes('&', str);
        return str;
    }

    private void updateMessages() {
	    for (String s : getConfig().getKeys(false)) {
	        getConfig().set(s, getConfig().getString(s).replaceAll("%h", "{header}"));
	        getConfig().set(s, getConfig().getString(s).replaceAll("%lvl", "{level}"));
            getConfig().set(s, getConfig().getString(s).replaceAll("%p", "{name}"));
            getConfig().set(s, getConfig().getString(s).replaceAll("%d", "{player}"));
            getConfig().set(s, getConfig().getString(s).replaceAll("%l", "{price}"));
	        getConfig().set(s, getConfig().getString(s).replaceAll("%b", "{balance}"));
	        getConfig().set(s, getConfig().getString(s).replaceAll("%w", "{name}"));
	        getConfig().set(s, getConfig().getString(s).replaceAll("%c", "{challenge}"));
	        getConfig().set(s, getConfig().getString(s).replaceAll("%m", "{player}"));
        }
        List<String> a = new ArrayList<>();
	    HeadsPlus hp = HeadsPlus.getInstance();
        for (String s : hp.getConfiguration().getPerks().getStringList("death-messages")) {
	        a.add(s.replaceAll("%p", "{player}").replaceAll("%k", "{killer}"));
        }
        hp.getConfiguration().getPerks().set("death-messages", a);
        hp.getConfiguration().save();
    }

}