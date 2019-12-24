package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

public class MacroCommandTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private NoCommand noCommand1;
    @Mock
    private NoCommand noCommand2;
    private Command[] commands;
    private MacroCommand macroCommand;

    @Before
    public void setUp() {
        commands = new Command[]{noCommand1, noCommand2};
        macroCommand = new MacroCommand(commands);
    }

    @Test
    public void execute() {
        macroCommand.execute();
        verify(noCommand1).execute();
        verify(noCommand2).execute();
    }

    @Test
    public void undo() {
        macroCommand.undo();
        verify(noCommand1).undo();
        verify(noCommand2).undo();
    }
}