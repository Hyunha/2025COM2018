package chapters.ch09.counter5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetMenuItem extends JMenuItem implements ActionListener {
    private Counter count;
    private CounterFrame frame;

    public ResetMenuItem(Counter c, CounterFrame f) {
        super("초기화");
        count = c;
        frame = f;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count.reset();
        frame.update();
    }
}
