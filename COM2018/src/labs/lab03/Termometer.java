package labs.lab03;

import javax.swing.*;

public class Termometer {
    public static void main(String[] args) {
        Double temp = Double.parseDouble(JOptionPane.showInputDialog("체온을 입력하세요."));
        String message = "정상체온";
        if (temp < 35.0) {
            message = "저체온";
        } else if (temp > 37.5) {
            message = "고열";
        }
        JOptionPane.showMessageDialog(null, message);
    }
}
