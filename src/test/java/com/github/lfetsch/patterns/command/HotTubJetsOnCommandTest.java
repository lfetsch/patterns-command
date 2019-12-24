package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

public class HotTubJetsOnCommandTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private HotTub hotTub;
    private HotTubJetsOnCommand hotTubJetsOnCommand;

    @Before
    public void setUp() {
        hotTubJetsOnCommand = new HotTubJetsOnCommand(hotTub);
    }

    @Test
    public void execute() {
        hotTubJetsOnCommand.execute();
        verify(hotTub).jetsOn();
    }

    @Test
    public void undo() {
        hotTubJetsOnCommand.undo();
        verify(hotTub).jetsOff();
    }
}