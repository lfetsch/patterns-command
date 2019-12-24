package com.github.lfetsch.patterns.command;

public class HotTubHighTempCommand implements Command {
    private final HotTub hotTub;
    private int previousTemperature;

    public HotTubHighTempCommand(HotTub hotTub) {
        this.hotTub = hotTub;
        previousTemperature = hotTub.getTemperature();
    }

    @Override
    public void execute() {
        previousTemperature = hotTub.getTemperature();
        hotTub.setTemperature(101);
    }

    @Override
    public void undo() {
        hotTub.setTemperature(previousTemperature);
    }
}
