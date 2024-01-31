package ChainOfResponsibility;

public class ErrorLogger extends Logger {
    ErrorLogger(Logger nextLogger) {
        super(nextLogger);
    }

    static Logger errorLogger;

    public static Logger getErrorLogger() {
        if(errorLogger == null) {
            errorLogger = new ErrorLogger(null);
        }
        return  errorLogger;
    }

    public void log(LogLevel logLevel, String msg) {
        if(logLevel.equals(LogLevel.ERROR))
            System.out.println("[ERROR] " + msg);
        else
            super.log(logLevel, msg);
    }
}
