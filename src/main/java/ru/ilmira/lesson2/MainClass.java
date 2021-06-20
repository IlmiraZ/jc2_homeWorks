package ru.ilmira.lesson2;

public class MainClass {
    public static void main(String[] args) {
        // Размер и содержимое массива соответствует требованиям
        String[][] s1 = {
                {"1", "2", "3", "4"},
                {"50", "60", "70", "80"},
                {"100", "200", "300", "500"},
                {"1000", "5000", "7500", "10000"}
        };
        try {
            checkArraySize(s1);
        } catch (MyArraySizeException e) {
            System.out.println("Недопустимый размер массива!");
        } catch (MyArrayDataException e) {
            System.out.println("Этот массив должен содержать только цифры!");
            e.printStackTrace();
        }

        // Размер массива больше, чем по условию
        String[][] s2 = {
                {"1", "2", "3", "4", "5"},
                {"50", "60", "70", "4", "5"},
                {"100", "200", "300", "500", "300"},
                {"1000", "5000", "7500", "10000", "200"}
        };
        try {
            checkArraySize(s2);
        } catch (MyArraySizeException e) {
            System.out.println("Недопустимый размер массива!");
        } catch (MyArrayDataException e) {
            System.out.println("Этот массив должен содержать только цифры!");
            e.printStackTrace();
        }

        // Размер массива меньше, чем по условию
        String[][] s3 = {
                {"1", "2", "3"},
                {"50", "60", "70"},
                {"100", "200", "300"},
                {"1000", "5000", "7500"}
        };
        try {
            checkArraySize(s3);
        } catch (MyArraySizeException e) {
            System.out.println("Недопустимый размер массива!");
        } catch (MyArrayDataException e) {
            System.out.println("Этот массив должен содержать только цифры!");
            e.printStackTrace();
        }

        // Массив содержит символ или текст вместо числа
        String[][] s4 = {
                {"1", "2", "3", "Символ"},
                {"50", "60", "Ф", "80"},
                {"100", "200", "300", "500"},
                {"1000", "А", "7500", "10000"}
        };
        try {
            checkArraySize(s4);
        } catch (MyArraySizeException e) {
            System.out.println("Недопустимый размер массива!");
        } catch (MyArrayDataException e) {
            System.out.println("Этот массив должен содержать только цифры!");
            e.printStackTrace();
        }
    }

    public static void checkArraySize(String[][] str) throws MyArraySizeException, MyArrayDataException {
        if (str.length != 4 || str[0].length != 4) {
            throw new MyArraySizeException();
        }

        int sum = 0;
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length; j++) {
                if (isNumber(str[i][j])) {
                    sum = sum + Integer.parseInt(str[i][j]);
                } else {
                    throw new MyArrayDataException("Не числовое значение в ячейке " + i + "; " + j);
                }
            }
        }
        System.out.println(sum);
    }

    public static boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


