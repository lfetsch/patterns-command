package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StereoTest {
    private Stereo stereo;

    @Before
    public void setUp() {
        stereo = new Stereo("test");
    }

    @Test
    public void description() {
        assertEquals("test", stereo.getDescription());
    }

    @Test
    public void getMode() {
        assertEquals(Stereo.Mode.Off, stereo.getMode());
    }

    @Test
    public void off() {
        stereo.off();
        assertEquals(Stereo.Mode.Off, stereo.getMode());
    }

    @Test
    public void setCd() {
        stereo.setCd();
        assertEquals(Stereo.Mode.CD, stereo.getMode());
    }

    @Test
    public void setDvd() {
        stereo.setDvd();
        assertEquals(Stereo.Mode.DVD, stereo.getMode());
    }

    @Test
    public void setRadio() {
        stereo.setRadio();
        assertEquals(Stereo.Mode.Radio, stereo.getMode());
    }

    @Test
    public void getVolume() {
    }

    @Test
    public void setVolume() {
        int volume = stereo.getVolume() + 1;
        stereo.setVolume(volume);
        assertEquals(volume, stereo.getVolume());
    }

    @Test
    public void testToString() {
        assertNotNull(stereo.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void volumeTooLow() {
        stereo.setVolume(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void volumeTooHigh() {
        stereo.setVolume(101);
    }
}