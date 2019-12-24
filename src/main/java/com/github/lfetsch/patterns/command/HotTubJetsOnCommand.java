package com.github.lfetsch.patterns.command;

public class HotTubJetsOnCommand implements Command {
    private final HotTub hotTub;

    public HotTubJetsOnCommand(HotTub hotTub) {
        this.hotTub = hotTub;
    }

    @Override
    public void execute() {
        hotTub.jetsOn();
    }

    @Override
    public void undo() {
        hotTub.jetsOff();
    }
}
