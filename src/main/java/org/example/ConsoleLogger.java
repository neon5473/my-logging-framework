package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogger implements  Logger {
    private final LogLevel minLevel;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    ConsoleLogger(LogLevel minLevel) {
        this.minLevel = minLevel;
    }

    private void printLog(LogLevel logLevel, String message) {
        if(logLevel.ordinal() >= minLevel.ordinal()) {
            System.out.printf("[%s] [%s] %s %n", LocalDateTime.now().format(formatter), logLevel, message);
        }
    }

    @Override
    public void log(LogLevel level, String message) {
        printLog(level, message);
    }

    @Override
    public void debug(String message) {
        printLog(LogLevel.DEBUG, message);
    }

    @Override
    public void error(String message) {
        printLog(LogLevel.ERROR, message);
    }

    @Override
    public void info(String message) {
        printLog(LogLevel.INFO, message);
    }

    @Override
    public void warn(String message) {
        printLog(LogLevel.WARN, message);
    }
}
