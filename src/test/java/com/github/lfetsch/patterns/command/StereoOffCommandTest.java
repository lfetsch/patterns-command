package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StereoOffCommandTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private Stereo stereo;
    private StereoOffCommand stereoOffCommand;

    @Before
    public void setUp() {
        stereoOffCommand = new StereoOffCommand(stereo);
    }

    @Test
    public void execute() {
        stereoOffCommand.execute();
        verify(stereo).off();
    }

    @Test
    public void undo() {
        when(stereo.getMode()).thenReturn(Stereo.Mode.DVD);
        stereoOffCommand.execute();

        stereoOffCommand.undo();
        verify(stereo).setDvd();
    }
}