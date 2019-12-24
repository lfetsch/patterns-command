package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

public class GarageDoorUpCommandTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private GarageDoor garageDoor;
    private GarageDoorUpCommand garageDoorUpCommand;

    @Before
    public void setUp() {
        garageDoorUpCommand = new GarageDoorUpCommand(garageDoor);
    }

    @Test
    public void execute() {
        garageDoorUpCommand.execute();
        verify(garageDoor).up();
    }

    @Test
    public void undo() {
        garageDoorUpCommand.undo();
        verify(garageDoor).down();
    }
}