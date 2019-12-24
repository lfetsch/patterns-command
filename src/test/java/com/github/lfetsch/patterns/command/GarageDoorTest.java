package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GarageDoorTest {
    private GarageDoor garageDoor;

    @Before
    public void setUp() {
        garageDoor = new GarageDoor("test");
    }

    @Test
    public void description() {
        assertEquals("test", garageDoor.getDescription());
    }

    @Test
    public void up() {
        garageDoor.up();
        assertTrue(garageDoor.isUp());
        assertFalse(garageDoor.isDown());
    }

    @Test
    public void down() {
        garageDoor.down();
        assertTrue(garageDoor.isDown());
        assertFalse(garageDoor.isUp());
    }

    @Test
    public void lightOn() {
        garageDoor.lightOn();
        assertTrue(garageDoor.isLightOn());
    }

    @Test
    public void lightOff() {
        garageDoor.lightOff();
        assertFalse(garageDoor.isLightOn());
    }

    @Test
    public void testToString() {
        assertNotNull(garageDoor.toString());
    }
}