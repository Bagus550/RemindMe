package id.bagus.remindMe.config;

import id.bagus.remindMe.RemindMe;
import id.bagus.remindMe.model.BroadcastGroup;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

public class ConfigManager {
    private final RemindMe plugin;
    private String prefix;
    private final List<BroadcastGroup> broadcastGroups = new ArrayList<>();

    public ConfigManager(RemindMe plugin) {
        this.plugin = plugin;
    }

    public void loadConfig() {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        broadcastGroups.clear();

        this.prefix = plugin.getConfig().getString("settings.prefix", "<bold>[RemindMe]</bold> ");

        ConfigurationSection section = plugin.getConfig().getConfigurationSection("broadcasts");
        if (section == null) return;

        for (String key : section.getKeys(false)) {
            String path = "broadcasts." + key;
            boolean enabled = plugin.getConfig().getBoolean(path + ".enabled", true);
            int interval = plugin.getConfig().getInt(path + ".interval-seconds", 300);
            int minPlayers = plugin.getConfig().getInt(path + ".min-players", 1);
            boolean random = plugin.getConfig().getBoolean(path + ".random", false);
            String displayType = plugin.getConfig().getString(path + ".display-type", "CHAT");
            String sound = plugin.getConfig().getString(path + ".sound", "");
            List<String> targetWorlds = plugin.getConfig().getStringList(path + ".target-worlds");
            List<String> messages = plugin.getConfig().getStringList(path + ".messages");

            broadcastGroups.add(new BroadcastGroup(key, enabled, interval, minPlayers, random, displayType, sound, targetWorlds, messages));
        }
    }

    public String getPrefix() { return prefix; }
    public List<BroadcastGroup> getBroadcastGroups() { return broadcastGroups; }
}