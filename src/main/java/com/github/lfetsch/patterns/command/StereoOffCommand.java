package com.github.lfetsch.patterns.command;

public class StereoOffCommand implements Command {
    private final Stereo stereo;
    private Stereo.Mode previousMode;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
        previousMode = stereo.getMode();
    }

    @Override
    public void execute() {
        previousMode = stereo.getMode();
        stereo.off();
    }

    @Override
    public void undo() {
        StereoCommand.undoStereoMode(previousMode, stereo);
    }

}
