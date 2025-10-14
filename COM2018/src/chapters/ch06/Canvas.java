package chapters.ch06;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    public Canvas() {
        JFrame frame = new JFrame();
        frame.setTitle("Canvas");
        frame.setSize(300, 200);
        frame.getContentPane().add(this);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void paintComponent(Graphics g) {
        // draw string
//        g.setColor(Color.RED);
//        g.drawString("Java!", 100, 60);

        // draw a rectangle and oval
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 300, 200);
        g.setColor(Color.MAGENTA);
        g.drawRect(100, 60, 90, 60);
        g.fillOval(100, 60, 50, 50);
    }

    // test code
    public static void main(String[] args) {
        new Canvas();
    }
}
