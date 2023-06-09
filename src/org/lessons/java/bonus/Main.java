package org.lessons.java.bonus;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Cycle cyclable = new Cycle(numbers);

        while (cyclable.hasMoreElements()) {
            System.out.println(cyclable.getNextElement());
        }
    }
}
