package com.github.lfetsch.patterns.command;

public class HotTub extends Observable {
    private final String description;
    private boolean isOn = false;
    private boolean jetsOn = false;
    private int temperature = 95;

    public HotTub(String description) {
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
        notifyObservers("isOn", true);
    }

    public void off() {
        isOn = false;
        notifyObservers("isOn", false);
    }

    public void jetsOn() {
        jetsOn = true;
        notifyObservers("jetsOn", true);
    }

    public void jetsOff() {
        jetsOn = false;
        notifyObservers("jetsOn", false);
    }

    public boolean areJetsOn() {
        return jetsOn;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        if (temperature < 90 || temperature > 110) {
            throw new IllegalArgumentException("temperature must be in the range [90, 110]");
        }
        this.temperature = temperature;
        notifyObservers("temperature", temperature);
    }

    @Override
    public String toString() {
        return "HotTub{" +
                "description='" + description + '\'' +
                ", isOn=" + isOn +
                ", jetsOn=" + jetsOn +
                ", temperature=" + temperature +
                '}';
    }
}
