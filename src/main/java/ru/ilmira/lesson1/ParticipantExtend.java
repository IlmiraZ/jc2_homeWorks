package ru.ilmira.lesson1;

// Класс содержит расширенную информацию об участнике

public class ParticipantExtend {
    private Object participant;
    private boolean isOut = false;

    public ParticipantExtend(Object participant) {
        this.participant = participant;
    }

    public Object getParticipant() {
        return participant;
    }

    public boolean isOut() {
        return isOut;
    }

    public void setOut(boolean out) {
        isOut = out;
    }
}
