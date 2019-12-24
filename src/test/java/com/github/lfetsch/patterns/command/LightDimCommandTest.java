package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LightDimCommandTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private DimmableLight dimmableLight;
    private LightDimCommand lightDimCommand;

    @Before
    public void setUp() {
        lightDimCommand = new LightDimCommand(dimmableLight);
    }

    @Test
    public void execute() {
        lightDimCommand.execute();
        verify(dimmableLight).setBrightness(eq(5));
    }

    @Test
    public void undo() {
        when(dimmableLight.getBrightness()).thenReturn(20);
        lightDimCommand.execute();

        lightDimCommand.undo();
        verify(dimmableLight).setBrightness(eq(20));
    }
}