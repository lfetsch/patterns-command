package com.github.lfetsch.patterns.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MonitorTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private DisplayElement displayElement;
    @Mock
    private Observable observable;
    private Monitor monitor;

    @Before
    public void setUp() {
        monitor = new Monitor(displayElement);
    }

    @Test
    public void add() {
        monitor.add(observable);
        verify(observable).register(same(monitor));
    }

    @Test
    public void update() {
        when(observable.toString()).thenReturn("test");
        monitor.update(observable, "prop1", "val1");
        verify(displayElement).display(eq("test: prop1=val1"));
    }
}