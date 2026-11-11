package id.bagus.remindMe;

import id.bagus.remindMe.command.RemindMeCommand;
import id.bagus.remindMe.config.ConfigManager;
import id.bagus.remindMe.model.BroadcastGroup;
import id.bagus.remindMe.task.AnnouncementTask;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public final class RemindMe extends JavaPlugin {
    private ConfigManager configManager;
    private final List<BukkitTask> activeTasks = new ArrayList<>();

    @Override
    public void onEnable() {
        this.configManager = new ConfigManager(this);
        this.configManager.loadConfig();

        // Register Command
        PluginCommand cmd = getCommand("remindme");
        if (cmd != null) {
            RemindMeCommand handler = new RemindMeCommand(this);
            cmd.setExecutor(handler);
            cmd.setTabCompleter(handler);
        }

        startBroadcastTasks();
        getLogger().info("RemindMe berhasil diaktifkan!");
    }

    @Override
    public void onDisable() {
        stopBroadcastTasks();
        getLogger().info("RemindMe telah dinonaktifkan.");
    }

    public void reloadPlugin() {
        stopBroadcastTasks();
        configManager.loadConfig();
        startBroadcastTasks();
    }

    private void startBroadcastTasks() {
        for (BroadcastGroup group : configManager.getBroadcastGroups()) {
            if (!group.isEnabled()) continue;

            long ticks = group.getIntervalSeconds() * 20L;
            BukkitTask task = Bukkit.getScheduler().runTaskTimer(this, new AnnouncementTask(this, group), ticks, ticks);
            activeTasks.add(task);
        }
    }

    private void stopBroadcastTasks() {
        for (BukkitTask task : activeTasks) {
            task.cancel();
        }
        activeTasks.clear();
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}