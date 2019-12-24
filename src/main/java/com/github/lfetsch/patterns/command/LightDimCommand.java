package com.github.lfetsch.patterns.command;

public class LightDimCommand implements Command {
    private final DimmableLight dimmableLight;
    int previousBrightness;

    public LightDimCommand(DimmableLight dimmableLight) {
        this.dimmableLight = dimmableLight;
        previousBrightness = dimmableLight.getBrightness();
    }

    @Override
    public void execute() {
        previousBrightness = dimmableLight.getBrightness();
        dimmableLight.setBrightness(5);
    }

    @Override
    public void undo() {
        dimmableLight.setBrightness(previousBrightness);
    }
}
