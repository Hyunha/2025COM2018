package labs.lab10.throbbingball.asis;

import javax.swing.*;
import java.awt.*;

public class ThrobPanel extends JPanel {
	private int location, ballSize;
	private Color c = Color.RED;
	private ThrobbingBall ball;
	
	public ThrobPanel(ThrobbingBall b) {
		int size = 180;
		location = size / 2; 
		ballSize = size / 3;
		ball = b;
		setSize(size, size);
	}

    public void update() {
        throbBall();
        repaint();
    }

	public Color getColor() { 
		return c; 
	}
	
	public void setColor(Color new_color) { 
		c = new_color; 
	}	

    public void throbBall() {
        if (ball.isLarge()) {
            ball.throb();
        } else {
            if (c == Color.RED) {
                setColor(Color.BLUE);
            } else {
                setColor(Color.RED);
            }
            ball.throb();
        }
    }

	public void paintComponent(Graphics g) { 
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 180, 180);
		g.setColor(c); 
		if (ball.isLarge())
			g.fillOval(location- ballSize /2,location- ballSize /2, ballSize, ballSize);
		else 
			g.fillOval(location- ballSize /4,location- ballSize /4, ballSize /2, ballSize /2);
	}
}
