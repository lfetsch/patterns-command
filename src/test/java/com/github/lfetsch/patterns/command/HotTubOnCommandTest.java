package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

public class HotTubOnCommandTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private HotTub hotTub;
    private HotTubOnCommand hotTubOnCommand;

    @Before
    public void setUp() {
        hotTubOnCommand = new HotTubOnCommand(hotTub);
    }

    @Test
    public void execute() {
        hotTubOnCommand.execute();
        verify(hotTub).on();
    }

    @Test
    public void undo() {
        hotTubOnCommand.undo();
        verify(hotTub).off();
    }
}