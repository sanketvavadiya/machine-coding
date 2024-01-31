package ChainOfResponsibility;

public class InfoLogger extends Logger {
    InfoLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(LogLevel logLevel, String msg) {
        if(logLevel.equals(LogLevel.INFO))
            System.out.println("[INFO] " + msg);
        else
            super.log(logLevel, msg);
    }
}
