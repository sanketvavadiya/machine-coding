package ChainOfResponsibility;

public class WarnLogger extends Logger {
    WarnLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(LogLevel logLevel, String msg) {
        if(logLevel.equals(LogLevel.WARN))
            System.out.println("[WARN] " + msg);
        else
            super.log(logLevel, msg);
    }
}
