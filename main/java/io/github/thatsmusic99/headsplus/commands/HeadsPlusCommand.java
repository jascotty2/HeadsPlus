package io.github.thatsmusic99.headsplus.commands;

import io.github.thatsmusic99.headsplus.HeadsPlus;
import io.github.thatsmusic99.headsplus.commands.maincommand.DebugPrint;
import io.github.thatsmusic99.headsplus.commands.maincommand.HelpMenu;
import io.github.thatsmusic99.headsplus.config.HeadsPlusConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HeadsPlusCommand implements CommandExecutor {

    private final HeadsPlusConfig hpc = HeadsPlus.getInstance().getMessagesConfig();
	private final String noPerms = hpc.getString("no-perm");

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        try {
            if ((cmd.getName().equalsIgnoreCase("headsplus")) || (cmd.getName().equalsIgnoreCase("hp"))) {
                if (args.length > 0) {
                    if (getCommandByName(args[0]) != null) {
                        IHeadsPlusCommand command = getCommandByName(args[0]);
                        assert command != null;
                        if (sender.hasPermission(command.getPermission())) {
                            if (command.isMainCommand()) {
                                if (command.isCorrectUsage(args, sender).get(true) != null) {
                                    return command.fire(args, sender);
                                } else {
                                    sender.sendMessage(command.isCorrectUsage(args, sender).get(false));
                                    sender.sendMessage(ChatColor.DARK_RED + "Usage: " + ChatColor.RED + command.getUsage());
                                    if (command.advancedUsages().length != 0) {
                                        sender.sendMessage(ChatColor.DARK_RED + "Further usages:");
                                        for (String s : command.advancedUsages()) {
                                            sender.sendMessage(ChatColor.RED + s);
                                        }
                                    }
                                }
                            } else {
                                new HelpMenu().fire(args, sender);
                            }
                        } else {
                            sender.sendMessage(noPerms);
                        }
                    } else {
                        new HelpMenu().fire(args, sender);
                    }
                } else {
                    new HelpMenu().fire(args, sender);
                }

            }
            return false;
        } catch (Exception e) {
            new DebugPrint(e, "Command (headsplus)", true, sender);
        }
		return false;
	}

	private IHeadsPlusCommand getCommandByName(String name) {
	    for (IHeadsPlusCommand hpc : HeadsPlus.getInstance().getCommands()) {
	        if (hpc.getCmdName().equalsIgnoreCase(name)) {
	            if (hpc.isMainCommand()){
                    return hpc;
                }
            }
        }
        return null;
    }
}