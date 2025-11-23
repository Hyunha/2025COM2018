package chapters.ch09.counter4;

import javax.swing.*;
import java.awt.*;

public class Drawing extends JPanel {
    private Counter count;

    public Drawing(Counter m) {
        count = m;
        setSize(200, 200);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 200, 200);
        g.setColor(Color.RED);
        int x = 0, y = 0;
        for (int i = 0; i != count.countOf(); i++) {
            g.fillOval(x * 25, y * 25, 20, 20);
            x++;
            if (x > 7) {
                x = 0;
                y++;
            }
        }
    }
}
