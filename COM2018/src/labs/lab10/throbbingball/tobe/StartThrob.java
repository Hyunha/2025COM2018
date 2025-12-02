package labs.lab10.throbbingball.tobe;

public class StartThrob {

	public static void main(String[] args) {
        int pauseTime = 500;
		ThrobbingBall b = new ThrobbingBall();
		ThrobPanel p = new ThrobPanel(b);
		new ThrobFrame(p, new ColorButton(p));
        new ThrobController(p, b, pauseTime).run();
	}
}
