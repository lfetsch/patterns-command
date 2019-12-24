package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StereoRadioCommandTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private Stereo stereo;
    private StereoRadioCommand stereoRadioCommand;

    @Before
    public void setUp() {
        stereoRadioCommand = new StereoRadioCommand(stereo);
    }

    @Test
    public void execute() {
        stereoRadioCommand.execute();
        verify(stereo).setRadio();
    }

    @Test
    public void undo() {
        when(stereo.getMode()).thenReturn(Stereo.Mode.CD);
        stereoRadioCommand.execute();

        stereoRadioCommand.undo();
        verify(stereo).setCd();
    }
}