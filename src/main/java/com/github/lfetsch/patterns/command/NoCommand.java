package com.github.lfetsch.patterns.command;

/**
 * Null object that can be used when you don't have a meaningful object to return.
 */
public class NoCommand implements Command {
    @Override
    public void execute() {
        // Nothing to do
    }

    @Override
    public void undo() {
        // Nothing to do
    }
}
