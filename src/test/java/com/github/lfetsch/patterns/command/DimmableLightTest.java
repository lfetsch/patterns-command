package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DimmableLightTest {
    private DimmableLight dimmableLight;

    @Before
    public void setUp() {
        dimmableLight = new DimmableLight("test");
    }

    @Test
    public void setBrightness() {
        int brightness = dimmableLight.getBrightness() + 1;
        dimmableLight.setBrightness(brightness);
        assertEquals(brightness, dimmableLight.getBrightness());
    }

    @Test
    public void testToString() {
        assertNotNull(dimmableLight.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void brightnessTooSmall() {
        dimmableLight.setBrightness(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void brightnessTooBig() {
        dimmableLight.setBrightness(11);
    }
}