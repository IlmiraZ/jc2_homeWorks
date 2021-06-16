package ru.ilmira.lesson1;

public class Human implements Runnable, Jumpable {
    private final String name;
    private final int runDistance;
    private final int jumpHeight;

    public Human(String name, int runDistance, int jumpHeight) {
        this.name = name;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public String getName() {
        return name;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    @Override
    public boolean jump(int height) {
        return getJumpHeight() >= height;
    }

    @Override
    public boolean run(int distance) {
        return getRunDistance() >= distance;
    }

    @Override
    public String toString() {
        return "Человек " + getName();
    }
}
