package labs.lab09.throbbingball.asis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorButton extends JButton implements ActionListener {
	private ThrobPanel view;
	
	public ColorButton(ThrobPanel f) {
		super("OK");
		view = f;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Color c = view.getColor();
		if (c == Color.RED) {
            view.setColor(Color.BLUE);
        } else {
            view.setColor(Color.RED);
        }
        view.throbBall();
        view.repaint();
	}
}
