package io.github.thatsmusic99.headsplus.commands;

import io.github.thatsmusic99.headsplus.locale.LocaleManager;
import io.github.thatsmusic99.headsplus.util.DebugFileCreator;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import io.github.thatsmusic99.headsplus.HeadsPlus;
import io.github.thatsmusic99.headsplus.config.HeadsPlusConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;

public class Head implements CommandExecutor, IHeadsPlusCommand {

    private final HeadsPlusConfig hpc = HeadsPlus.getInstance().getMessagesConfig();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        return fire(args, sender);
    }

	private static void giveHead(Player p, String n) {
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        HeadsPlus.getInstance().getNMS().setSkullOwner(HeadsPlus.getInstance().getNMS().getOfflinePlayer(n), meta);

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', HeadsPlus.getInstance().getHeadsConfig().getConfig().getString("player.display-name").replaceAll("%d", n)));
        skull.setItemMeta(meta);
        Location playerLoc = (p).getLocation();
        double playerLocY = playerLoc.getY() + 1;
        playerLoc.setY(playerLocY);
        World world = (p).getWorld();
        world.dropItem(playerLoc, skull).setPickupDelay(0);
	}

	private void giveH(String[] args, Player sender, Player p) {
        HeadsPlus.getInstance().saveConfig();
        List<String> bl = new ArrayList<>();
        for (String str : HeadsPlus.getInstance().getConfig().getStringList("blacklist")) {
            bl.add(str.toLowerCase());
        }
        List<String> wl = new ArrayList<>();
        for (String str : HeadsPlus.getInstance().getConfig().getStringList("whitelist")) {
            wl.add(str.toLowerCase());
        }

        boolean blacklistOn = HeadsPlus.getInstance().getConfig().getBoolean("blacklistOn");
        boolean wlOn = HeadsPlus.getInstance().getConfig().getBoolean("whitelistOn");
        String head = args[0].toLowerCase();
        if (p.getInventory().firstEmpty() == -1) {
            sender.sendMessage(hpc.getString("full-inv"));
            return;
        }
        if (wlOn) {
            if (blacklistOn) {
                if (wl.contains(head)) {
                    if (!bl.contains(head)) {
                        giveHead(p, args[0]);
                    } else if (sender.hasPermission("headsplus.bypass.blacklist")) {
                        giveHead(p, args[0]);
                    } else {
                        sender.sendMessage(hpc.getString("blacklist-head"));
                    }
                } else if (sender.hasPermission("headsplus.bypass.whitelist")) {
                    if (!bl.contains(head)) {
                        giveHead(p, args[0]);
                    } else if (sender.hasPermission("headsplus.bypass.blacklist")) {
                        giveHead(p, args[0]);
                    } else {
                        sender.sendMessage(hpc.getString("blacklist-head"));
                    }
                } else {
                    sender.sendMessage(hpc.getString("whitelist-head"));
                }
            } else {
                if (wl.contains(head)) {
                    giveHead(p, args[0]);
                } else if (sender.hasPermission("headsplus.bypass.whitelist")){
                    giveHead(p, args[0]);
                } else {
                    sender.sendMessage(hpc.getString("whitelist-head"));
                }
            }
        } else {
            if (blacklistOn) {
                if (!bl.contains(head)) {
                    giveHead(p, args[0]);
                } else if (sender.hasPermission("headsplus.bypass.blacklist")){
                    giveHead(p, args[0]);
                } else {
                    sender.sendMessage(hpc.getString("blacklist-head"));
                }
            } else {
                giveHead(p, args[0]);
            }
        }
    }

    @Override
    public String getCmdName() {
        return "head";
    }

    @Override
    public String getPermission() {
        return "headsplus.head";
    }

    @Override
    public String getCmdDescription() {
        return LocaleManager.getLocale().descHead();
    }

    @Override
    public String getSubCommand() {
        return "Head";
    }

    @Override
    public String getUsage() {
        return "/head <IGN|Player giving head to> [IGN]";
    }

    @Override
    public boolean isCorrectUsage(String[] args, CommandSender sender) {
        return false;
    }

    @Override
    public boolean isMainCommand() {
        return false;
    }

    @Override
    public boolean fire(String[] args, CommandSender sender) {
	    try {
            if (sender instanceof Player){
                if (sender.hasPermission("headsplus.head")) {
                    if (args.length == 0) {
                        sender.sendMessage(ChatColor.DARK_RED + "Usage: " + ChatColor.RED + getUsage());
                        return true;
                    }
                    if ((args.length == 1) && !(args[0].matches("^[A-Za-z0-9_]+$"))) {
                        sender.sendMessage(hpc.getString("alpha-names"));
                        return true;
                    }
                    if (args.length > 2) {
                        sender.sendMessage(hpc.getString("too-many-args"));
                        sender.sendMessage(ChatColor.DARK_RED + "Usage: " + ChatColor.RED + getUsage());
                        return true;
                    }
                    if (args[0].length() > 16) {
                        sender.sendMessage(hpc.getString("head-too-long"));
                        return true;
                    }
                    if (args[0].length() < 3) {
                        sender.sendMessage(hpc.getString("too-short-head"));
                        return true;
                    }
                    if (args.length == 2) {
                        if (sender.hasPermission("headsplus.head.others")) {
                            if (HeadsPlus.getInstance().getNMS().getPlayer(args[0]) != null) {
                                if (args[1].matches("^[A-Za-z0-9_]+$") && (3 < args[1].length()) && (args[1].length() < 16)) {
                                    String[] s = new String[2];
                                    s[0] = args[1];
                                    s[1] = args[0];
                                    giveH(s, (Player) sender, HeadsPlus.getInstance().getNMS().getPlayer(args[0]));
                                    return true;
                                } else if (!args[1].matches("^[A-Za-z0-9_]+$")) {
                                    sender.sendMessage(hpc.getString("alpha-names"));
                                    return true;
                                } else if (args[1].length() < 3) {
                                    sender.sendMessage(hpc.getString("too-short-head"));
                                    return true;
                                } else {
                                    sender.sendMessage(hpc.getString("head-too-long"));
                                    return true;
                                }
                            } else {
                                sender.sendMessage(hpc.getString("player-offline"));
                                return true;
                            }
                        } else {
                            sender.sendMessage(hpc.getString("no-perms"));
                            return false;
                        }
                    }
                    if (args[0].matches("^[A-Za-z0-9_]+$") && (3 < args[0].length()) && (args[0].length() < 16)) {
                        giveH(args, (Player) sender, (Player) sender);
                        return true;
                    }
                } else {
                    sender.sendMessage(hpc.getString("no-perms"));
                    return false;
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You must be a player to run this command!");
                return false;
            }
        } catch (Exception e) {
	        if (HeadsPlus.getInstance().getConfig().getBoolean("debug.print-stacktraces-in-console")) {
                e.printStackTrace();
            }
            if (HeadsPlus.getInstance().getConfig().getBoolean("debug.create-debug-files")) {
                Logger log = HeadsPlus.getInstance().getLogger();
                log.severe("HeadsPlus has failed to execute this command. An error report has been made in /plugins/HeadsPlus/debug");
                try {
                    String s = new DebugFileCreator().createReport(e, "Command (head)");
                    log.severe("Report name: " + s);
                    log.severe("Please submit this report to the developer at one of the following links:");
                    log.severe("https://github.com/Thatsmusic99/HeadsPlus/issues");
                    log.severe("https://discord.gg/nbT7wC2");
                    log.severe("https://www.spigotmc.org/threads/headsplus-1-8-x-1-12-x.237088/");
                } catch (IOException e1) {
                    if (HeadsPlus.getInstance().getConfig().getBoolean("debug.print-stacktraces-in-console")) {
                        e1.printStackTrace();
                    }
                }
            }
        }

        return false;
    }
}
	
