package labs.lab10.throbbingball.tobe;

public class ThrobController {
    private ThrobPanel view;
    private ThrobbingBall model;
    private int time;

    public ThrobController(ThrobPanel v, ThrobbingBall m, int delayTime) {
        view = v;
        model = m;
        time = delayTime;
    }

    public void run() {
        while (true) {
            model.throb();
            view.repaint();
            delay();
        }
    }

    private void delay() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }
}
