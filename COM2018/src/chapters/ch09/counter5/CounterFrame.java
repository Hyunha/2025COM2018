package chapters.ch09.counter5;

import javax.swing.*;
import java.awt.*;

public class CounterFrame extends JFrame {
    private Counter count;
    private JLabel label = new JLabel("count = 0");
    private JPanel drawing;

    public CounterFrame(Counter c, JPanel p) {
        count = c;
        drawing = p;

        JMenuBar menuBar = new JMenuBar();
        // 기능
        JMenu functionMenu = new JMenu("기능");
        ResetMenuItem reset = new ResetMenuItem(count, this);
        functionMenu.add(reset);
        JMenu changeColor = new JMenu("색 바꾸기");
        ChangeColorMenuItem changeColorRed = new ChangeColorMenuItem("빨강", Color.RED, count);
        ChangeColorMenuItem changeColorBlue = new ChangeColorMenuItem("파랑", Color.BLUE, count);
        ChangeColorMenuItem changeColorYellow = new ChangeColorMenuItem("노랑", Color.YELLOW, count);
        changeColor.add(changeColorRed);
        changeColor.add(changeColorBlue);
        changeColor.add(changeColorYellow);
        functionMenu.add(changeColor);

        JMenu helpMenu = new JMenu("도움말");
        HelpMenuItem help = new HelpMenuItem();
        helpMenu.add(help);

        menuBar.add(functionMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        JPanel p1 = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new FlowLayout());

        p1.add(label);
        CounterButton button = new CounterButton("OK", count, this);
        p2.add(button);
        ExitButton exit = new ExitButton();
        p2.add(exit);

        cp.add(p1, BorderLayout.NORTH);
        cp.add(drawing, BorderLayout.CENTER);
        cp.add(p2, BorderLayout.SOUTH);

        setTitle("Counter");
        setSize(200, 280);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void update() {
        label.setText("count = " + count.countOf());
        drawing.repaint();
    }
}
