package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

public class GarageDoorDownCommandTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private GarageDoor garageDoor;
    private GarageDoorDownCommand garageDoorDownCommand;

    @Before
    public void setUp() {
        garageDoorDownCommand = new GarageDoorDownCommand(garageDoor);
    }

    @Test
    public void execute() {
        garageDoorDownCommand.execute();
        verify(garageDoor).down();
    }

    @Test
    public void undo() {
        garageDoorDownCommand.undo();
        verify(garageDoor).up();
    }
}