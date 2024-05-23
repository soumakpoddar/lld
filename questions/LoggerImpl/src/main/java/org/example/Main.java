package org.example;

public class Main {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logProcessor.log(LogProcessor.INFO, "This is an info message");
        logProcessor.log(LogProcessor.DEBUG, "This is a debug message");
        logProcessor.log(LogProcessor.ERROR, "This is an error message");
    }
}