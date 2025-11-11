package chapters.ch09.counter1;

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
