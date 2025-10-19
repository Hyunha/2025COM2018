package labs.lab06;

import java.awt.*;
import javax.swing.*;

public class GrowingEgg extends JPanel {

    private final int NET_SIZE;
    private int egg_width = 60;
    private int egg_height = 40;
    private int x;
    private int y;

    public GrowingEgg(int size) {
        NET_SIZE = size;
        x = NET_SIZE / 2 - egg_width / 2;
        y = NET_SIZE / 2 - egg_height / 2;
        JFrame f = new JFrame();
        f.setTitle("Egg");
        f.setSize(NET_SIZE, NET_SIZE);
        f.getContentPane().add(this);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, NET_SIZE, NET_SIZE);
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, egg_width, egg_height);
        egg_width += 60;
        egg_height += 40;
        x -= 30;
        y -= 20;
    }

    public static void main(String[] args) {
        new GrowingEgg(600);
    }
}