package com.github.lfetsch.patterns.command;

public class Monitor implements Observer {
    private final DisplayElement displayElement;

    public Monitor(DisplayElement displayElement) {
        this.displayElement = displayElement;
    }

    public void add(Observable observable) {
        observable.register(this);
    }

    @Override
    public void update(Observable observable, String key, Object value) {
        displayElement.display(String.format("%s: %s=%s", observable, key, value));
    }
}
