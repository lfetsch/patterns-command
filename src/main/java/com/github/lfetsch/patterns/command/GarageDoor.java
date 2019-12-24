package com.github.lfetsch.patterns.command;

public class GarageDoor extends Observable {
    private final String description;
    private boolean isUp = false;
    private boolean isLightOn = false;

    public GarageDoor(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isUp() {
        return this.isUp;
    }

    public void up() {
        isUp = true;
        notifyObservers("isUp", Boolean.TRUE);
    }

    public boolean isDown() {
        return !this.isUp;
    }

    public void down() {
        isUp = false;
        notifyObservers("isUp", Boolean.FALSE);
    }

    public boolean isLightOn() {
        return this.isLightOn;
    }

    public void lightOn() {
        isLightOn = true;
        notifyObservers("isLightOn", Boolean.TRUE);
    }

    public void lightOff() {
        isLightOn = false;
        notifyObservers("isLightOn", Boolean.FALSE);
    }

    @Override
    public String toString() {
        return "GarageDoor{" +
                "description='" + description + '\'' +
                ", isUp=" + isUp +
                ", isLightOn=" + isLightOn +
                '}';
    }
}
