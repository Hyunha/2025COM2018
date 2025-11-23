package chapters.ch09.counter5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpMenuItem extends JMenuItem implements ActionListener {
    public HelpMenuItem() {
        super("Help");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "공 찍는 프로그램\nver. 0.1");
    }
}
