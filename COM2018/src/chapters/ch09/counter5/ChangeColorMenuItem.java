package chapters.ch09.counter5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeColorMenuItem extends JMenuItem implements ActionListener {
    private Color color;
    private Counter counter;

    public ChangeColorMenuItem(String text, Color c, Counter counter) {
        super(text);
        color = c;
        this.counter = counter;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        counter.setColor(color);
    }
}
