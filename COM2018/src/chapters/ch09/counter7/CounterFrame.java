package chapters.ch09.counter7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterFrame extends JFrame implements ActionListener {
    private Counter count;
    private JLabel label = new JLabel("count = 0");
    private JPanel drawing;
    private JMenuItem changeColorRed;
    private JMenuItem changeColorBlue;
    private JMenuItem changeColorYellow;
    private JMenuItem help;
    private JMenuItem reset;

    public CounterFrame(Counter c, JPanel p) {
        count = c;
        drawing = p;

        JMenuBar menuBar = new JMenuBar();
        JMenu functionMenu = new JMenu("기능");
        reset = new JMenuItem("초기화");
        reset.addActionListener(this);
        functionMenu.add(reset);
        JMenu changeColor = new JMenu("색 바꾸기");
        changeColorRed = new JMenuItem("빨강");
        changeColorRed.addActionListener(this);
        changeColorBlue = new JMenuItem("파랑");
        changeColorBlue.addActionListener(this);
        changeColorYellow = new JMenuItem("노랑");
        changeColorYellow.addActionListener(this);
        changeColor.add(changeColorRed);
        changeColor.add(changeColorBlue);
        changeColor.add(changeColorYellow);
        functionMenu.add(changeColor);

        JMenu helpMenu = new JMenu("도움말");
        help = new JMenuItem("Help");
        help.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changeColorRed) {
            count.setColor(Color.RED);
        } else if (e.getSource() == changeColorBlue) {
            count.setColor(Color.BLUE);
        } else if (e.getSource() == changeColorYellow) {
            count.setColor(Color.YELLOW);
        } else if (e.getSource() == help) {
            JOptionPane.showMessageDialog(null, "공 찍는 프로그램\nver. 0.1");
        } else if (e.getSource() == reset) {
            count.reset();
            update();
        }
    }

    public void update() {
        label.setText("count = " + count.countOf());
        drawing.repaint();
    }
}
