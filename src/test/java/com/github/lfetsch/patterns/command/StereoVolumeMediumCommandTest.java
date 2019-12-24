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

public class StereoVolumeMediumCommandTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private Stereo stereo;
    private StereoVolumeMediumCommand stereoVolumeMediumCommand;

    @Before
    public void setUp() {
        stereoVolumeMediumCommand = new StereoVolumeMediumCommand(stereo);
    }

    @Test
    public void execute() {
        stereoVolumeMediumCommand.execute();
        verify(stereo).setVolume(eq(50));
    }

    @Test
    public void undo() {
        when(stereo.getVolume()).thenReturn(22);
        stereoVolumeMediumCommand.execute();

        stereoVolumeMediumCommand.undo();
        verify(stereo).setVolume(eq(22));
    }
}