package labs.lab10.throbbingball.tobe;

import java.awt.*;

public class ThrobbingBall {
	private boolean isLarge = true;
	private Color color;

    public ThrobbingBall() {
        color = Color.RED;
    }

	public void throb() {
		isLarge = !isLarge;
	}

    public boolean isLarge() {
        return isLarge;
    }

    public void flipColor() {
        if (color == Color.RED) {
            color = Color.BLUE;
        } else {
            color = Color.RED;
        }
    }

    public Color getColor() {
        return color;
    }
}
