package labs.lab09.throbbingball.asis;

import java.awt.*;
import javax.swing.*;

public class ThrobPanel extends JPanel {
	private int location, ball_size;
	private Color c = Color.RED;
	private ThrobbingBall ball;
	
	public ThrobPanel(ThrobbingBall b) {
		int size = 180;
		location = size / 2; 
		ball_size = size / 3; 
		ball = b;
		setSize(size, size);
	}
	
	public Color getColor() { 
		return c; 
	}
	
	public void setColor(Color new_color) { 
		c = new_color; 
	}	

    public void throbBall() {
        ball.throb();
    }

	public void paintComponent(Graphics g) { 
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 180, 180);
		g.setColor(c); 
		if (ball.isLarge())
			g.fillOval(location-ball_size/2,location-ball_size/2,ball_size,ball_size); 
		else 
			g.fillOval(location-ball_size/4,location-ball_size/4,ball_size/2,ball_size/2); 
	}
}
