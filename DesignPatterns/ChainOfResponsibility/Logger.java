package ChainOfResponsibility;

public class Logger {
    Logger nextLogger;
    Logger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void log(LogLevel logLevel, String msg) {
        if(nextLogger != null)
            nextLogger.log(logLevel, msg);
    }
}
