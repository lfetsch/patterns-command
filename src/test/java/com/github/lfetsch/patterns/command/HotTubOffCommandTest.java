package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

public class HotTubOffCommandTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private HotTub hotTub;
    private HotTubOffCommand hotTubJOffCommand;

    @Before
    public void setUp() {
        hotTubJOffCommand = new HotTubOffCommand(hotTub);
    }

    @Test
    public void execute() {
        hotTubJOffCommand.execute();
        verify(hotTub).off();
    }

    @Test
    public void undo() {
        hotTubJOffCommand.undo();
        verify(hotTub).on();
    }
}