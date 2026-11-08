package id.bagus.remindMe.command;

import id.bagus.remindMe.RemindMe;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class RemindMeCommand implements CommandExecutor {
    private final RemindMe plugin;
    private final MiniMessage miniMessage = MiniMessage.miniMessage();

    public RemindMeCommand(RemindMe plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("remindme.admin")) {
                sender.sendMessage(miniMessage.deserialize("<red>Anda tidak memiliki izin untuk perintah ini!</red>"));
                return true;
            }

            plugin.reloadPlugin();
            sender.sendMessage(miniMessage.deserialize("<green>Konfigurasi RemindMe berhasil diperbarui!</green>"));
            return true;
        }

        sender.sendMessage(miniMessage.deserialize("<gradient:#ff7e5f:#feb47b><bold>RemindMe</bold></gradient> <gray>v1.0.0 oleh Bagus</gray>"));
        sender.sendMessage(miniMessage.deserialize("<gray>Gunakan <green>/remindme reload</green> untuk memuat ulang konfigurasi.</gray>"));
        return true;
    }
}