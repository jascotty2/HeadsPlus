package io.github.thatsmusic99.headsplus.commands.maincommand;

import io.github.thatsmusic99.headsplus.HeadsPlus;
import io.github.thatsmusic99.headsplus.commands.IHeadsPlusCommand;
import io.github.thatsmusic99.headsplus.config.HeadsPlusConfig;
import io.github.thatsmusic99.headsplus.locale.LocaleManager;
import io.github.thatsmusic99.headsplus.util.PagedLists;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.List;

public class WhitelistList implements IHeadsPlusCommand {

    private final HeadsPlusConfig hpc = HeadsPlus.getInstance().getMessagesConfig();

    @Override
    public String getCmdName() {
        return "whitelistl";
    }

    @Override
    public String getPermission() {
        return "headsplus.maincommand.whitelist.list";
    }

    @Override
    public String getCmdDescription() {
        return LocaleManager.getLocale().descWhitelistList();
    }

    @Override
    public String getSubCommand() {
        return "Whitelistl";
    }

    @Override
    public String getUsage() {
        return "/hp whitelistl [Page No.]";
    }

    @Override
    public HashMap<Boolean, String> isCorrectUsage(String[] args, CommandSender sender) {
        HashMap<Boolean, String> h = new HashMap<>();
        h.put(true, "");
        return h;
    }

    @Override
    public boolean isMainCommand() {
        return true;
    }

    @Override
    public boolean fire(String[] args, CommandSender sender) {
        try {
            if (args.length == 1) {
                List<String> bl = HeadsPlus.getInstance().getConfig().getStringList("whitelist");
                if (bl.size() < 1) {
                    sender.sendMessage(hpc.getString("empty-wl"));
                    return true;
                }
                PagedLists<String> pl = new PagedLists<>(bl, 8);
                sender.sendMessage(ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor1")) + "============ " + ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor2")) + "Whitelist: " + ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor3")) + "1/" + pl.getTotalPages() + ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor1")) + " ==========" );
                for (String key : pl.getContentsInPage(1)) {
                    sender.sendMessage(ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor4")) + key);
                }
            } else {
                if (args[1].matches("^[0-9]+$")) {
                    List<String> wl = HeadsPlus.getInstance().getConfig().getStringList("whitelist");
                    int page = Integer.parseInt(args[1]);
                    PagedLists<String> pl = new PagedLists<>(wl, 8);
                    if ((page > pl.getTotalPages()) || (0 >= page)) {
                        sender.sendMessage(hpc.getString("invalid-pg-no"));
                    } else {
                        sender.sendMessage(ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor1")) + "============ " + ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor2")) + "Whitelist: " + ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor3")) + page + "/" + pl.getTotalPages() + ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor1")) + " ==========");

                        for (String key : pl.getContentsInPage(page)) {
                            sender.sendMessage(ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor4")) + key);
                        }
                    }
                } else {
                    sender.sendMessage(hpc.getString("invalid-input-int"));
                }
            }
        } catch (Exception e) {
            new DebugPrint(e, "Subcommand (whitelistl)", true, sender);
        }
        return true;
    }
}
