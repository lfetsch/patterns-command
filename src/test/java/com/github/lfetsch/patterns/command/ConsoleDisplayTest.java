package com.github.lfetsch.patterns.command;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.function.Consumer;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class ConsoleDisplayTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    Consumer<String> test;

    @Test
    public void display() {
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(test);
        consoleDisplay.display("test");
        verify(test).accept(eq("test"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNull() {
        new ConsoleDisplay(null);
    }
}