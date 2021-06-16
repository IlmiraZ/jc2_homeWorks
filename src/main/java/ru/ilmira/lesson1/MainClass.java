package ru.ilmira.lesson1;

import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        Random random = new Random();
        // Участники
        ParticipantExtend[] participantExtends = new ParticipantExtend[] {
                new ParticipantExtend(new Human("Вася", random.nextInt(10), random.nextInt(5))),
                new ParticipantExtend(new Cat("Мурзик", random.nextInt(10), random.nextInt(3))),
                new ParticipantExtend(new Robot("Бот", random.nextInt(10), random.nextInt(2)))
        };

        // Препятствия
        Object[] obstacles = new Object[]{new Track(random.nextInt(10)), new Wall(random.nextInt(10))};

        for (ParticipantExtend participantExtend : participantExtends) {
            for (Object obstacle : obstacles) {
                if (obstacle instanceof Track) {
                    run(participantExtend, (Track) obstacle);
                } else if (obstacle instanceof Wall) {
                    jump(participantExtend, (Wall) obstacle);
                }
            }
        }
    }

    private static void run(ParticipantExtend participantExtend, Track track) {
        if (participantExtend.isOut()) return;

        if (((Runnable) participantExtend.getParticipant()).run(track.getDistance())) {
            System.out.println(participantExtend.getParticipant() + " успешно преодолел дистанцию длиной " + track.getDistance() + " км.");
        } else {
            System.out.println(participantExtend.getParticipant() + " выбыл, т.к. не смог преодолеть дистанцию длиной " + track.getDistance() + " км.");
            participantExtend.setOut(true);
        }
    }

    private static void jump(ParticipantExtend participantExtend, Wall wall) {
        if (participantExtend.isOut()) return;

        if (((Jumpable) participantExtend.getParticipant()).jump(wall.getHeight())) {
            System.out.println(participantExtend.getParticipant() + " успешно преодолел барьер высотой " + wall.getHeight() + " м.");
        } else {
            System.out.println(participantExtend.getParticipant() + " выбыл, т.к. не смог преодолеть барьер высотой " + wall.getHeight() + " м.");
            participantExtend.setOut(true);
        }
    }
}

