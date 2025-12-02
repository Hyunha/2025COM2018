package labs.lab10.throbbingball.tobe;

import javax.swing.*;
import java.awt.*;

public class ThrobPanel extends JPanel {
	private int location, ballSize;
	private ThrobbingBall ball;
	
	public ThrobPanel(ThrobbingBall b) {
		int size = 180;
		location = size / 2;
		ballSize = size / 3;
		ball = b;
		setSize(size, size);
	}

    public void update() {
        ball.flipColor();
        repaint();
    }

	public void paintComponent(Graphics g) { 
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 180, 180);
		g.setColor(ball.getColor());
		if (ball.isLarge())
			g.fillOval(location- ballSize /2,location- ballSize /2, ballSize, ballSize);
		else 
			g.fillOval(location- ballSize /4,location- ballSize /4, ballSize /2, ballSize /2);
	}
}
