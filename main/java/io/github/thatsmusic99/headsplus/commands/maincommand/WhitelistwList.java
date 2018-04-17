package io.github.thatsmusic99.headsplus.commands.maincommand;

import io.github.thatsmusic99.headsplus.HeadsPlus;
import io.github.thatsmusic99.headsplus.commands.IHeadsPlusCommand;
import io.github.thatsmusic99.headsplus.config.HeadsPlusConfig;
import io.github.thatsmusic99.headsplus.locale.LocaleManager;
import io.github.thatsmusic99.headsplus.util.DebugFileCreator;
import io.github.thatsmusic99.headsplus.util.PagedLists;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class WhitelistwList implements IHeadsPlusCommand {

    private final HeadsPlusConfig hpc = HeadsPlus.getInstance().getMessagesConfig();

    @Override
    public String getCmdName() {
        return "whitelistwl";
    }

    @Override
    public String getPermission() {
        return "headsplus.maincommand.whitelistw.list";
    }

    @Override
    public String getCmdDescription() {
        return LocaleManager.getLocale().descWhitelistwList();
    }

    @Override
    public String getSubCommand() {
        return "Whitelistwl";
    }

    @Override
    public String getUsage() {
        return "/hp whitelistwl [Page No.]";
    }

    @Override
    public boolean isCorrectUsage(String[] args, CommandSender sender) {
        return false;
    }

    @Override
    public boolean isMainCommand() {
        return true;
    }

    @Override
    public boolean fire(String[] args, CommandSender sender) {
        try {
            if (args.length == 1) {
                List<String> bl = HeadsPlus.getInstance().getConfig().getStringList("whitelistw");
                if (bl.size() < 1) {
                    sender.sendMessage(hpc.getString("empty-wlw"));
                    return true;
                }
                PagedLists<String> pl = new PagedLists<>(bl, 8);
                sender.sendMessage(ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor1")) + "============ " + ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor2")) + "World Whitelist: " + ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor3")) + "1/" + pl.getTotalPages() + ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor1")) + " ==========" );

                for (String key : pl.getContentsInPage(1)) {
                    sender.sendMessage(ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor4")) + key);
                }
            } else {
                if (args[1].matches("^[0-9]+$")) {
                    List<String> bl = HeadsPlus.getInstance().getConfig().getStringList("whitelistw");
                    int page = Integer.parseInt(args[1]);
                    PagedLists<String> pl = new PagedLists<>(bl, 8);

                    if ((page > pl.getTotalPages()) || (0 >= page)) {
                        sender.sendMessage(hpc.getString("invalid-pg-no"));
                    } else {
                        sender.sendMessage(ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor1")) + "============ " + ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor2")) + "World Whitelist: "
                                + ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor3")) + page + "/" + pl.getTotalPages()
                                + ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor1")) + " ==========");

                        for (String key : pl.getContentsInPage(page)) {
                            sender.sendMessage(ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor4")) + key);
                        }
                    }
                } else {
                    sender.sendMessage(hpc.getString("invalid-input-int"));
                }
            }
        } catch (Exception e) {
            if (HeadsPlus.getInstance().getConfig().getBoolean("debug.print-stacktraces-in-console")) {
                e.printStackTrace();
            }
            if (HeadsPlus.getInstance().getConfig().getBoolean("debug.create-debug-files")) {
                Logger log = HeadsPlus.getInstance().getLogger();
                log.severe("HeadsPlus has failed to execute this command. An error report has been made in /plugins/HeadsPlus/debug");
                try {
                    String s = new DebugFileCreator().createReport(e, "Subcommand (whitelistwl)");
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

        return true;
    }
}
