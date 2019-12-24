package com.github.lfetsch.patterns.command;

public class DimmableLight extends Light {
    private int brightness = 0;

    public DimmableLight(String description) {
        super(description);
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        if (brightness < 1 || brightness > 10) {
            throw new IllegalArgumentException("brightness must be in range of [1, 10]");
        }
        this.brightness = brightness;
        notifyObservers("brightness", brightness);
    }

    @Override
    public String toString() {
        return super.toString()
                .replace("Light", "DimmableLight")
                .replace("}", ", brightness=" + brightness + '}');
    }
}
