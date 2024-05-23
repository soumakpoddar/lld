package org.example;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class LogProcessor {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    LogProcessor nextLogProcessor;

    public void log(int logLevel, String message) {
        if (nextLogProcessor != null) {
            nextLogProcessor.log(logLevel, message);
        }
    }
}
