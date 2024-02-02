package src.enums;

import java.util.HashMap;
import java.util.Map;

public enum DisplayCommand {
    FREE_COUNT("free_count"),
    OCCUPIED_SLOTS("occurpied_slots");

    private final String command;

    DisplayCommand(String command) {
        this.command = command;
    }

    private static final Map<String, DisplayCommand> map = new HashMap<>();

    static {
        for(DisplayCommand cmd : values()) map.put(cmd.command, cmd);
    }

    public static DisplayCommand of(String cmd) {
        return map.get(cmd);
    }
}
