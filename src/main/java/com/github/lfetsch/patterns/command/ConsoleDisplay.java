package com.github.lfetsch.patterns.command;

import java.util.function.Consumer;

public class ConsoleDisplay implements DisplayElement {
    private final Consumer<String> action;

    public ConsoleDisplay(Consumer<String> action) {
        if (action == null) {
            throw new IllegalArgumentException("action cannot be null");
        }
        this.action = action;
    }

    @Override
    public void display(String message) {
        action.accept(message);
    }
}
