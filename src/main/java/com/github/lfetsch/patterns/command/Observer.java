package com.github.lfetsch.patterns.command;

public interface Observer {
    void update(Observable observable, String key, Object value);
}
