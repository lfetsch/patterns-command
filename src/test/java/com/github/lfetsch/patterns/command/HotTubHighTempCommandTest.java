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

public class HotTubHighTempCommandTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private HotTub hotTub;
    private HotTubHighTempCommand hotTubHighTempCommand;

    @Before
    public void setUp() {
        hotTubHighTempCommand = new HotTubHighTempCommand(hotTub);
    }

    @Test
    public void execute() {
        hotTubHighTempCommand.execute();
        verify(hotTub).setTemperature(eq(101));
    }

    @Test
    public void undo() {
        when(hotTub.getTemperature()).thenReturn(99);
        hotTubHighTempCommand.execute();

        hotTubHighTempCommand.undo();

        verify(hotTub).setTemperature(eq(99));
    }
}