package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

public class HotTubJetsOffCommandTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private HotTub hotTub;
    private HotTubJetsOffCommand hotTubJetsOffCommand;

    @Before
    public void setUp() {
        hotTubJetsOffCommand = new HotTubJetsOffCommand(hotTub);
    }

    @Test
    public void execute() {
        hotTubJetsOffCommand.execute();
        verify(hotTub).jetsOff();
    }

    @Test
    public void undo() {
        hotTubJetsOffCommand.undo();
        verify(hotTub).jetsOn();
    }
}