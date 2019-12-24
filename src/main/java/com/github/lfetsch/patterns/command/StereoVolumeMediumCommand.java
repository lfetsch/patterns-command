package com.github.lfetsch.patterns.command;

public class StereoVolumeMediumCommand implements Command {
    private final Stereo stereo;
    private int previousVolume;

    public StereoVolumeMediumCommand(Stereo stereo) {
        this.stereo = stereo;
        previousVolume = stereo.getVolume();
    }

    @Override
    public void execute() {
        previousVolume = stereo.getVolume();
        stereo.setVolume(50);
    }

    @Override
    public void undo() {
        stereo.setVolume(previousVolume);
    }
}
