package com.github.lfetsch.patterns.command;

public class HotTubJetsOffCommand implements Command {
    private final HotTub hotTub;

    public HotTubJetsOffCommand(HotTub hotTub) {
        this.hotTub = hotTub;
    }

    @Override
    public void execute() {
        hotTub.jetsOff();
    }

    @Override
    public void undo() {
        hotTub.jetsOn();
    }
}
