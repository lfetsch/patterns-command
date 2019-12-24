package com.github.lfetsch.patterns.command;

public class StereoCDCommand implements Command {
    private final Stereo stereo;
    private Stereo.Mode previousMode;

    public StereoCDCommand(Stereo stereo) {
        this.stereo = stereo;
        previousMode = stereo.getMode();
    }

    @Override
    public void execute() {
        previousMode = stereo.getMode();
        stereo.setCd();
    }

    @Override
    public void undo() {
        StereoCommand.undoStereoMode(previousMode, stereo);
    }
}
