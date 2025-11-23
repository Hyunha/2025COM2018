package labs.lab09.throbbingball.tobe;

public class StartThrob {

	public static void main(String[] args) {
		ThrobbingBall b = new ThrobbingBall();
		ThrobPanel p = new ThrobPanel(b);
		new ThrobFrame(p, new ColorButton(p));
	}
}
