package labs.lab02;

import javax.swing.*;

public class DivisibleBy9Easy {
    public static void main(String[] args) {
        int value = Integer.parseInt(JOptionPane.showInputDialog("정수를 주세요."));
        int value_abs = Math.abs(value);
        JOptionPane.showMessageDialog(null, "정수 " + value_abs + "은(는) 9로 나누어 떨어지나? " + (value_abs % 9 == 0));
    }
}
