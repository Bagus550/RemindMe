package id.bagus.remindMe.task;

import id.bagus.remindMe.RemindMe;
import id.bagus.remindMe.model.BroadcastGroup;
import net.kyori.adventure.key.InvalidKeyException;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AnnouncementTask implements Runnable {
    private final RemindMe plugin;
    private final BroadcastGroup group;
    private final MiniMessage miniMessage = MiniMessage.miniMessage();
    private final Random random = new Random();
    private final Sound soundEffect;
    private int messageIndex = 0;

    public AnnouncementTask(RemindMe plugin, BroadcastGroup group) {
        this.plugin = plugin;
        this.group = group;
        this.soundEffect = buildSound();
    }

    /**
     * Membuat objek Sound sekali saja saat task dibuat.
     * ID sound dipakai apa adanya (titik tetap titik), contoh: block.note_block.chime
     */
    private Sound buildSound() {
        String raw = group.getSound();
        if (raw == null || raw.isBlank()) return null;

        try {
            return Sound.sound(Key.key(raw.trim().toLowerCase()), Sound.Source.PLAYER, 1.0f, 1.0f);
        } catch (InvalidKeyException e) {
            plugin.getLogger().warning("Grup '" + group.getId() + "': format ID sound tidak valid -> '"
                    + raw + "'. Suara dinonaktifkan untuk grup ini.");
            return null;
        }
    }

    @Override
    public void run() {
        if (!group.isEnabled() || group.getMessages().isEmpty()) return;

        // Filter pemain yang berada di world yang ditargetkan
        List<Player> targetPlayers = Bukkit.getOnlinePlayers().stream()
                .filter(p -> group.getTargetWorlds().contains(p.getWorld().getName()))
                .collect(Collectors.toList());

        // Cek syarat minimal pemain
        if (targetPlayers.size() < group.getMinPlayers()) return;

        // Tentukan pesan yang akan dikirim (rotasi atau acak)
        String rawMessage;
        if (group.isRandom()) {
            rawMessage = group.getMessages().get(random.nextInt(group.getMessages().size()));
        } else {
            rawMessage = group.getMessages().get(messageIndex);
            messageIndex = (messageIndex + 1) % group.getMessages().size();
        }

        Component prefixComp = miniMessage.deserialize(plugin.getConfigManager().getPrefix());
        Component msgComp = miniMessage.deserialize(rawMessage);
        Component fullMessage = prefixComp.append(msgComp);

        for (Player player : targetPlayers) {
            // Tampilkan pesan sesuai mode (CHAT, ACTIONBAR, TITLE)
            switch (group.getDisplayType().toUpperCase()) {
                case "ACTIONBAR":
                    player.sendActionBar(fullMessage);
                    break;
                case "TITLE":
                    Title title = Title.title(fullMessage, Component.empty(),
                            Title.Times.times(Duration.ofMillis(500), Duration.ofSeconds(3), Duration.ofMillis(500)));
                    player.showTitle(title);
                    break;
                case "CHAT":
                default:
                    player.sendMessage(fullMessage);
                    break;
            }

            // Mainkan suara notifikasi jika ada
            if (soundEffect != null) {
                player.playSound(soundEffect);
            }
        }
    }
}
