package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HotTubTest {
    private HotTub hotTub;

    @Before
    public void setUp() {
        hotTub = new HotTub("test");
    }

    @Test
    public void description() {
        assertEquals("test", hotTub.getDescription());
    }

    @Test
    public void on() {
        hotTub.on();
        assertTrue(hotTub.isOn());
    }

    @Test
    public void off() {
        hotTub.off();
        assertFalse(hotTub.isOn());
    }

    @Test
    public void jetsOn() {
        hotTub.jetsOn();
        assertTrue(hotTub.areJetsOn());
    }

    @Test
    public void jetsOff() {
        hotTub.jetsOff();
        assertFalse(hotTub.areJetsOn());
    }

    @Test
    public void setTemperature() {
        int temperature = hotTub.getTemperature() + 1;
        hotTub.setTemperature(temperature);
        assertEquals(temperature, hotTub.getTemperature());
    }

    @Test
    public void testToString() {
        assertNotNull(hotTub.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void temperatureTooSmall() {
        hotTub.setTemperature(89);
    }

    @Test(expected = IllegalArgumentException.class)
    public void temperatureTooBig() {
        hotTub.setTemperature(111);
    }
}