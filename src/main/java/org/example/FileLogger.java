package org.example;

import java.awt.dnd.DragGestureEvent;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements Logger {
    private LogLevel minLevel;
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final String filePath;

    FileLogger(LogLevel logLevel, String filePath) {
        this.minLevel = logLevel;
        this.filePath = filePath;
    }

    private void writeLog(LogLevel level, String message) {
        if(level.ordinal() >= minLevel.ordinal()) {
            String logMessage = String.format("[%s] [%s] %s%n", LocalDateTime.now().format(formatter), level, message);
            try (FileWriter writer = new FileWriter(filePath, true)) {
                writer.write(logMessage);
            } catch (Exception e) {
                System.err.println("Failed to write log : " + e.getMessage());
            }
        }
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        writeLog(logLevel, message);
    }

    @Override
    public void debug(String message) {
        writeLog(LogLevel.DEBUG, message);
    }

    @Override
    public void error(String message) {
        writeLog(LogLevel.ERROR, message);
    }

    @Override
    public void info(String message) {
        writeLog(LogLevel.INFO, message);
    }

    @Override
    public void warn(String message) {
        writeLog(LogLevel.WARN, message);
    }
}
