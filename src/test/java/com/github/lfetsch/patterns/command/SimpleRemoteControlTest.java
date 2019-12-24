package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class SimpleRemoteControlTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private NoCommand noCommand1;
    @Mock
    private NoCommand noCommand2;
    private SimpleRemoteControl simpleRemoteControl;

    @Before
    public void setUp() {
        simpleRemoteControl = new SimpleRemoteControl(2);
    }

    @Test
    public void getSlotCount() {
        assertEquals(2, simpleRemoteControl.getSlotCount());
    }

    @Test
    public void setSlot() {
        simpleRemoteControl.setSlot(0, noCommand1);
        assertSame(noCommand1, simpleRemoteControl.getSlot(0));
    }

    @Test
    public void buttonWasPressed() {
        simpleRemoteControl.setSlot(0, noCommand1);
        simpleRemoteControl.buttonWasPressed(0);
        verify(noCommand1).execute();
    }

    @Test
    public void undoButtonWasPressed() {
        simpleRemoteControl.setSlot(1, noCommand2);
        simpleRemoteControl.buttonWasPressed(1);

        assertSame(noCommand2, simpleRemoteControl.getUndo());
        simpleRemoteControl.undoButtonWasPressed();
        verify(noCommand2).undo();
    }

    @Test
    public void testToString() {
        assertNotNull(simpleRemoteControl.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void slotsTooSmall() {
        new SimpleRemoteControl(-1);
    }

    @Test
    public void setSlotNoNull() {
        simpleRemoteControl.setSlot(0, null);
        assertNotNull(simpleRemoteControl.getSlot(0));
        assertEquals(NoCommand.class, simpleRemoteControl.getSlot(0).getClass());
    }
}