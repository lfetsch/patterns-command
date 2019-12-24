package com.github.lfetsch.patterns.command;

public class StereoCommand {
    static void undoStereoMode(Stereo.Mode previousMode, Stereo stereo) {
        switch (previousMode) {
            case Radio:
                stereo.setRadio();
                break;
            case CD:
                stereo.setCd();
                break;
            case DVD:
                stereo.setDvd();
                break;
            case Off:
                stereo.off();
                break;
            default:
                assert (false);
        }
    }
}
