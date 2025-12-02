package chapters.ch09.counter10;

import java.awt.*;

public class Counter {
    private int  counter;
    private Color color = Color.RED;
    private Color[] balls;

    public Counter(int start) {
        counter = start;
        balls = new Color[100];
    }

    public void increment() {
        balls[counter++] = color;
    }

    public int countOf() {
        return counter;
    }

    public Color getColor() {
        return color;
    }

    public Color getColor(int i) {
        if (0 <= i && i < counter) {
            return balls[i];
        } else {
            return null;
        }
    }

    public void setColor(Color c) {
        color = c;
    }

    public void reset() {
        counter = 0;
        balls =  new Color[100];
    }
}
