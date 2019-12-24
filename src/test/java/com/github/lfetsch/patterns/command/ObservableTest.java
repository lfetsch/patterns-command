package com.github.lfetsch.patterns.command;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class ObservableTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private Observer observer1;
    @Mock
    private Observer observer2;
    private Observable observable = new Observable();

    @Test
    public void registration() {
        observable.register(observer1);
        observable.register(observer2);
        observable.unregister(observer1);
        observable.notifyObservers("key", "value");
        verify(observer2).update(same(observable), eq("key"), eq("value"));
        verifyNoMoreInteractions(observer1);
    }
}