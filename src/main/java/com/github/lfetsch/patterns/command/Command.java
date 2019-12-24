package com.github.lfetsch.patterns.command;

public interface Command {
    void execute();

    void undo();
}
