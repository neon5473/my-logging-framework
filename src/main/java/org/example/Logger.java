package org.example;

public interface Logger {
    void log(LogLevel logLevel, String message);
    void debug(String message);
    void error(String message);
    void info(String message);
    void warn(String message);
}
