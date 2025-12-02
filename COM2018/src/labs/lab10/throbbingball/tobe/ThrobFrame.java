package labs.lab10.throbbingball.tobe;

import javax.swing.*;
import java.awt.*;

public class ThrobFrame extends JFrame {
	
	public ThrobFrame(ThrobPanel p, ColorButton b) {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(p, BorderLayout.CENTER);
		cp.add(b, BorderLayout.SOUTH);
		setTitle("Throb");
        int size = 180;
		setSize(size, size+40);
		setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
