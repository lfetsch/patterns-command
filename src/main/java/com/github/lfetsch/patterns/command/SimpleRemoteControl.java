package com.github.lfetsch.patterns.command;

public class SimpleRemoteControl {
    private Command[] slots;
    private Command lastCommand;

    public SimpleRemoteControl(int slotCount) {
        if (slotCount < 1) {
            throw new IllegalArgumentException("slotCount must be greater than or equal to 1");
        }
        Command noCommand = new NoCommand();
        slots = new Command[slotCount];
        for (int i = 0; i < slotCount; i++) {
            slots[i] = noCommand;
        }
        lastCommand = noCommand;
    }

    public int getSlotCount() {
        return slots.length;
    }

    public Command getSlot(int slot) {
        return slots[slot];
    }

    public void setSlot(int slot, Command command) {
        slots[slot] = command == null ? new NoCommand() : command;
    }

    public void buttonWasPressed(int slot) {
        slots[slot].execute();
        lastCommand = slots[slot];
    }

    public Command getUndo() {
        return lastCommand;
    }

    public void undoButtonWasPressed() {
        lastCommand.undo();
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("\n-------------- Remote Control ------------\n");
        for (int i = 0; i < slots.length; i++) {
            stringBuffer.append(String.format("[slot %d] %s\n", i, slots[i].getClass().getSimpleName()));
        }
        stringBuffer.append(String.format("[undo] %s\n", lastCommand.getClass().getSimpleName()));
        return stringBuffer.toString();
    }
}
