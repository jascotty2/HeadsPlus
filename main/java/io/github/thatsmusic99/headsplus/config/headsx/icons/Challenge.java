package io.github.thatsmusic99.headsplus.config.headsx.icons;

import io.github.thatsmusic99.headsplus.HeadsPlus;
import io.github.thatsmusic99.headsplus.commands.maincommand.DebugPrint;
import io.github.thatsmusic99.headsplus.config.HeadsPlusMessagesConfig;
import io.github.thatsmusic99.headsplus.config.headsx.Icon;
import io.github.thatsmusic99.headsplus.util.InventoryManager;
import io.github.thatsmusic99.headsplus.util.MaterialTranslator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Challenge implements Icon {
    private final HeadsPlusMessagesConfig hpc = HeadsPlus.getInstance().getMessagesConfig();
    @Override
    public String getIconName() {
        return "challenge";
    }

    @Override
    public void onClick(Player p, InventoryManager im, InventoryClickEvent e) {
io.github.thatsmusic99.headsplus.api.Challenge challenge = HeadsPlus.getInstance().getAPI().getChallenge(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));
        try {
            if (challenge != null) {
                if (!challenge.isComplete(p)) {
                    if (challenge.canComplete(p)) {
                        challenge.complete(p, e.getInventory(), e.getSlot());
                    } else {
                        p.sendMessage(hpc.getString("cant-complete-challenge"));
                    }
                } else {
                    p.sendMessage(hpc.getString("already-complete-challenge"));
                }
            }
        }catch (NullPointerException ignored) {
        } catch (SQLException ex) {
            new DebugPrint(ex, "Completing challenge", false, p);
        }
    }

    @Override
    public Material getDefaultMaterial() {
        return HeadsPlus.getInstance().getNMS().getColouredBlock(MaterialTranslator.BlockType.TERRACOTTA, 15).getType();
    }

    public Material getCompleteMaterial() {
        return HeadsPlus.getInstance().getNMS().getColouredBlock(MaterialTranslator.BlockType.TERRACOTTA, 5).getType();
    }

    @Override
    public List<String> getDefaultLore() {
        return new ArrayList<>(Collections.singleton("{challenge-lore}"));
    }

    @Override
    public String getDefaultDisplayName() {
        return "{challenge-name}";
    }
}
