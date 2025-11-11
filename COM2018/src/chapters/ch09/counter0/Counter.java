package chapters.ch09.counter0;

import java.awt.event.ActionEvent;

public class Counter {
    private int  counter;

    public Counter(int start) {
        counter = start;
    }

    public void increment() {
        counter++;
    }

    public int countOf() {
        return counter;
    }
}
