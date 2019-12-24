package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

public class LightOffCommandTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private Light light;
    private LightOffCommand lightOffCommand;

    @Before
    public void setUp() {
        lightOffCommand = new LightOffCommand(light);
    }

    @Test
    public void execute() {
        lightOffCommand.execute();
        verify(light).off();
    }

    @Test
    public void undo() {
        lightOffCommand.undo();
        verify(light).on();
    }
}