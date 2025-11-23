package chapters.ch09.counter5;

import java.awt.*;

public class Counter {
    private int  counter;
    private Color color = Color.RED;

    public Counter(int start) {
        counter = start;
    }

    public void increment() {
        counter++;
    }

    public int countOf() {
        return counter;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color c) {
        color = c;
    }

    public void reset() {
        counter = 0;
    }
}
