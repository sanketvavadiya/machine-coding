package ChainOfResponsibility;

public class Main {
    public static void main(String [] args) {
        Logger logger = new InfoLogger(new WarnLogger(new ErrorLogger(null)));
        logger.log(LogLevel.INFO, "Info log");
        logger.log(LogLevel.WARN, "Warn log");
        logger.log(LogLevel.ERROR, "Error log");
    }
}
