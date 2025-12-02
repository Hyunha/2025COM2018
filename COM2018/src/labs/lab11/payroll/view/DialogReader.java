package labs.lab11.payroll.view;

import javax.swing.*;

public class DialogReader {
    public static String readString(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    public static int readInt(String prompt) {
        int n;
        String input = readString(prompt);
        try {
            n = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " 정수가 아닙니다.");
            n = readInt(prompt);    // 재시도
        }
        return n;
    }

    public static double readDouble(String prompt) {
        double n;
        String input = readString(prompt);
        try {
            n = Double.parseDouble(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " 실수가 아닙니다.");
            n = readDouble(prompt); // 재시도
        }
        return n;
    }
}
