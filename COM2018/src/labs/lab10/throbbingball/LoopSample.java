package labs.lab10.throbbingball;

public class LoopSample {
    static void main() {
        LoopSample s = new LoopSample();
        System.out.println("Let's start game...");
        System.out.println("3");
        s.delay(1000);
        System.out.println("2");
        s.delay(1000);
        System.out.println("1");
        s.delay(1000);
        System.out.println("start!");
        boolean b = true;
        while (true) {
            s.delay(330);
            if (b) {
                System.out.println("Even");
            } else {
                System.out.println("Odd");
            }
            b = !b;
        }
    }

    private void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {}
    }
}
