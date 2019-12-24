package com.github.lfetsch.patterns.command;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NoCommandTest {
    private NoCommand noCommand = new NoCommand();

    @Test
    public void execute() {
        // NoCommand does nothing so there is no execution to test.
        noCommand.execute();
        assertTrue(true);
    }

    @Test
    public void undo() {
        // NoCommand does nothing so there is no undo test.
        noCommand.undo();
        assertTrue(true);
    }
}