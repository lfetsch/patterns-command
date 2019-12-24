package com.github.lfetsch.patterns.command;

public class Stereo extends Observable {
    private final String description;
    private int volume = 0;
    private Mode mode = Mode.Off;

    public Stereo(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Mode getMode() {
        return mode;
    }

    public void off() {
        mode = Mode.Off;
        notifyObservers("mode", mode);
    }

    public void setCd() {
        mode = Mode.CD;
        notifyObservers("mode", mode);
    }

    public void setDvd() {
        mode = Mode.DVD;
        notifyObservers("mode", mode);
    }

    public void setRadio() {
        mode = Mode.Radio;
        notifyObservers("mode", mode);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume < 1 || volume > 100) {
            throw new IllegalArgumentException("volume must be in the range of [1, 100]");
        }
        this.volume = volume;
        notifyObservers("volume", this.volume);
    }

    @Override
    public String toString() {
        return "Stereo{" +
                "description='" + description + '\'' +
                ", volume=" + volume +
                ", mode=" + mode +
                '}';
    }

    enum Mode {
        CD,
        DVD,
        Radio,
        Off
    }
}
