package com.github.lfetsch.patterns.command;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        SimpleRemoteControl remoteControl = new SimpleRemoteControl(13);

        Light kitchenLight = new Light("Kitchen Light");
        Light livingRoomLight = new Light("Living Room Light");
        DimmableLight hotTubLight = new DimmableLight("HotTub Light");
        GarageDoor garageDoor = new GarageDoor("Garage Door");
        Stereo stereo = new Stereo("Stereo");
        HotTub hotTub = new HotTub("HotTub");

        List<Command> partyOnCommands = new ArrayList<>();
        partyOnCommands.add(new StereoCDCommand(stereo));
        partyOnCommands.add(new LightDimCommand(hotTubLight));
        partyOnCommands.add(new HotTubOnCommand(hotTub));
        partyOnCommands.add(new HotTubJetsOnCommand(hotTub));
        partyOnCommands.add(new HotTubHighTempCommand(hotTub));

        List<Command> partyOffCommands = new ArrayList<>();
        partyOffCommands.add(new StereoOffCommand(stereo));
        partyOffCommands.add(new LightOffCommand(hotTubLight));
        partyOffCommands.add(new HotTubOffCommand(hotTub));

        Monitor monitor = new Monitor(new ConsoleDisplay(System.out::println));
        monitor.add(kitchenLight);
        monitor.add(livingRoomLight);
        monitor.add(garageDoor);
        monitor.add(hotTub);
        monitor.add(hotTubLight);
        monitor.add(stereo);

        remoteControl.setSlot(0, new LightOnCommand(kitchenLight));
        remoteControl.setSlot(1, new LightOffCommand(kitchenLight));
        remoteControl.setSlot(2, new LightOnCommand(livingRoomLight));
        remoteControl.setSlot(3, new LightOffCommand(livingRoomLight));
        remoteControl.setSlot(4, new GarageDoorUpCommand(garageDoor));
        remoteControl.setSlot(5, new GarageDoorDownCommand(garageDoor));
        remoteControl.setSlot(6, new StereoCDCommand(stereo));
        remoteControl.setSlot(7, new StereoRadioCommand(stereo));
        remoteControl.setSlot(8, new StereoOffCommand(stereo));
        remoteControl.setSlot(9, new MacroCommand(partyOnCommands.toArray(new Command[0])));
        remoteControl.setSlot(10, new MacroCommand(partyOffCommands.toArray(new Command[0])));

        System.out.println(remoteControl);

        remoteControl.buttonWasPressed(0);
        remoteControl.buttonWasPressed(1);
        remoteControl.buttonWasPressed(2);
        remoteControl.buttonWasPressed(3);
        remoteControl.buttonWasPressed(4);
        remoteControl.buttonWasPressed(5);
        remoteControl.buttonWasPressed(6);
        remoteControl.buttonWasPressed(7);
        remoteControl.buttonWasPressed(8);
        remoteControl.buttonWasPressed(9);
        remoteControl.buttonWasPressed(10);

        System.out.println(remoteControl);

        remoteControl.undoButtonWasPressed();
    }
}
