package org.example;

public class Fibonnacci {
    public int get_fibonnacci_position(int position) {
        if (position < 0) throw new IllegalArgumentException("Position can't be negative");
        if (position == 0) return 0;
        if (position == 1) return 1;

        int first = 0, second = 1, next;
        for (int i=2; i<position; i++) {
            next = first + second;
            first = second;
            second = next;
        }

        return second;
    }
}
