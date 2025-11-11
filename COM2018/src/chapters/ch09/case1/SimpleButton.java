package chapters.ch09.case1;

import javax.swing.*;
import java.awt.*;

public class SimpleButton extends JFrame {

    public SimpleButton() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        JLabel label = new JLabel("OK 버튼 누르세요!");
        cp.add(label);
        JButton button = new JButton("OK");
        cp.add(button);
        setTitle("Button");
        setSize(200, 65);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SimpleButton();
    }
}
