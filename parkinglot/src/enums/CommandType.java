package src.enums;

import java.util.HashMap;
import java.util.Map;

public enum CommandType {
    CREATE_PARKING_LOT("create_parking_lot"),
    DISLPAY("display"),
    PARK_VEHICLE("park_vehicle"),
    UNPARK_VEHICLE("upark_vehicle"),
    EXIT("exit");

    private final String command;

    CommandType(String cmd) {
        this.command = cmd;
    }

    public String toString() {
        return this.command;
    }

    private static final Map<String, CommandType> map = new HashMap<>();

    static {
        for(CommandType cmd : values())
            map.put(cmd.command, cmd);
    }

    public static CommandType of(String cmd) {
        return map.get(cmd);
    }
}
