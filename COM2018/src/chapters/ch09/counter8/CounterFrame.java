package chapters.ch09.counter8;

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
        JMenu functionMenu = new JMenu("기능");
        JMenuItem reset = new JMenuItem("초기화");
        reset.addActionListener(e -> reset());
        functionMenu.add(reset);
        JMenu changeColor = new JMenu("색 바꾸기");
        JMenuItem changeColorRed = new JMenuItem("빨강");
        changeColorRed.addActionListener(e -> count.setColor(Color.RED));
        JMenuItem changeColorBlue = new JMenuItem("파랑");
        changeColorBlue.addActionListener(e -> count.setColor(Color.BLUE));
        JMenuItem changeColorYellow = new JMenuItem("노랑");
        changeColorYellow.addActionListener(e -> count.setColor(Color.YELLOW));
        changeColor.add(changeColorRed);
        changeColor.add(changeColorBlue);
        changeColor.add(changeColorYellow);
        functionMenu.add(changeColor);

        JMenu helpMenu = new JMenu("도움말");
        JMenuItem help = new JMenuItem("Help");
        help.addActionListener(e -> JOptionPane.showMessageDialog(null, "공 찍는 프로그램\nver. 0.1"));
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

    private void reset() {
        count.reset();
        update();
    }
}
