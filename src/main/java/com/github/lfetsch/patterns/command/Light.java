package com.github.lfetsch.patterns.command;

public class Light extends Observable {
    private final String description;
    private boolean isOn = false;

    public Light(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isOn() {
        return isOn;
    }

    public void on() {
        isOn = true;
        notifyObservers("isOn", Boolean.TRUE);
    }

    public void off() {
        isOn = false;
        notifyObservers("isOn", Boolean.FALSE);
    }

    @Override
    public String toString() {
        return "Light{" +
                "description='" + description + '\'' +
                ", isOn=" + isOn +
                '}';
    }
}
