package com.github.lfetsch.patterns.command;

public class StereoRadioCommand implements Command {
    private final Stereo stereo;
    private Stereo.Mode previousMode;

    public StereoRadioCommand(Stereo stereo) {
        this.stereo = stereo;
        previousMode = stereo.getMode();
    }

    @Override
    public void execute() {
        previousMode = stereo.getMode();
        stereo.setRadio();
    }

    @Override
    public void undo() {
        StereoCommand.undoStereoMode(previousMode, stereo);
    }
}
