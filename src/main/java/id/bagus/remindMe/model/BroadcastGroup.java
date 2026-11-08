package id.bagus.remindMe.model;

import java.util.List;

public class BroadcastGroup {
    private final String id;
    private final boolean enabled;
    private final int intervalSeconds;
    private final int minPlayers;
    private final boolean random;
    private final String displayType;
    private final String sound;
    private final List<String> targetWorlds;
    private final List<String> messages;

    public BroadcastGroup(String id, boolean enabled, int intervalSeconds, int minPlayers,
                          boolean random, String displayType, String sound,
                          List<String> targetWorlds, List<String> messages) {
        this.id = id;
        this.enabled = enabled;
        this.intervalSeconds = intervalSeconds;
        this.minPlayers = minPlayers;
        this.random = random;
        this.displayType = displayType;
        this.sound = sound;
        this.targetWorlds = targetWorlds;
        this.messages = messages;
    }

    public String getId() { return id; }
    public boolean isEnabled() { return enabled; }
    public int getIntervalSeconds() { return intervalSeconds; }
    public int getMinPlayers() { return minPlayers; }
    public boolean isRandom() { return random; }
    public String getDisplayType() { return displayType; }
    public String getSound() { return sound; }
    public List<String> getTargetWorlds() { return targetWorlds; }
    public List<String> getMessages() { return messages; }
}