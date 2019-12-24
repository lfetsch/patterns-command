package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StereoCDCommandTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private Stereo stereo;
    private StereoCDCommand stereoCdCommand;

    @Before
    public void setUp() {
        stereoCdCommand = new StereoCDCommand(stereo);
    }

    @Test
    public void execute() {
        stereoCdCommand.execute();
        verify(stereo).setCd();
    }

    @Test
    public void undo() {
        when(stereo.getMode()).thenReturn(Stereo.Mode.Off);
        stereoCdCommand.execute();

        stereoCdCommand.undo();
        verify(stereo).off();
    }

}