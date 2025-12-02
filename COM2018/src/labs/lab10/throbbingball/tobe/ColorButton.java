package labs.lab10.throbbingball.tobe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButton extends JButton implements ActionListener {
	private ThrobPanel view;
	
	public ColorButton(ThrobPanel p) {
		super("OK");
		view = p;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		view.update();
	}
}
