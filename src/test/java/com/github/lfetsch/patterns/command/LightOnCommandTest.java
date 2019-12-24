package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

public class LightOnCommandTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private Light light;
    private LightOnCommand lightOnCommand;

    @Before
    public void setUp() {
        lightOnCommand = new LightOnCommand(light);
    }

    @Test
    public void execute() {
        lightOnCommand.execute();
        verify(light).on();
    }

    @Test
    public void undo() {
        lightOnCommand.undo();
        verify(light).off();
    }
}