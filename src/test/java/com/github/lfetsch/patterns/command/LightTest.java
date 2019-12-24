package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LightTest {
    private Light light;

    @Before
    public void setUp() {
        light = new Light("test");
    }

    @Test
    public void description() {
        assertEquals("test", light.getDescription());
    }

    @Test
    public void on() {
        light.on();
        assertTrue(light.isOn());
    }

    @Test
    public void off() {
        light.off();
        assertFalse(light.isOn());
    }

    @Test
    public void testToString() {
        assertNotNull(light.toString());
    }
}