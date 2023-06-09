package org.lessons.java.bonus;

public class Cycle {
    private int[] numbers;
    private int current;

    public Cycle(int[] numbers) {
        this.numbers = numbers;
        this.current = 0;
    }

    public boolean hasMoreElements() {
        return current < numbers.length;
    }

    public int getNextElement() {
        int element = numbers[current];
        current++;
        return element;
    }
}
