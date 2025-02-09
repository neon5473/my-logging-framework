package org.example;

public class LoggerFactory {
    private static Logger getConsoleLogger(LogLevel minLevel) {
        return new ConsoleLogger(minLevel);
    }

    private static Logger getFileLogger(LogLevel minLevel, String filePath) {
        return new FileLogger(minLevel, filePath);
    }
}
