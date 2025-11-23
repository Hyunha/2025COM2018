package chapters.ch09.counter4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterButton extends JButton implements ActionListener {
    private CounterFrame view;
    private Counter model;

    public CounterButton(String label, Counter m, CounterFrame v) {
        super(label);
        view = v;
        model = m;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.increment();
        view.update();
    }
}
