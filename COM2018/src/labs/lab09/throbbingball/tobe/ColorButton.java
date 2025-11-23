package labs.lab09.throbbingball.tobe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButton extends JButton implements ActionListener {
	private ThrobPanel view;
	
	public ColorButton(ThrobPanel f) {
		super("OK");
		view = f;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
        view.throbBall();
        view.repaint();
	}
}
