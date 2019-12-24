package com.github.lfetsch.patterns.command;

public class HotTubOffCommand implements Command {
    private final HotTub hotTub;

    public HotTubOffCommand(HotTub hotTub) {
        this.hotTub = hotTub;
    }

    @Override
    public void execute() {
        hotTub.off();
    }

    @Override
    public void undo() {
        hotTub.on();
    }
}
