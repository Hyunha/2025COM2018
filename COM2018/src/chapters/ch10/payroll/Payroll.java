package chapters.ch10.payroll;

import javax.swing.*;

public class Payroll {
    static void main() {
        String nameIn = JOptionPane.showInputDialog("입력 파일명");
        String nameOut = JOptionPane.showInputDialog("출력 파일명");
        if (nameIn != null && nameOut != null) {
            new PayrollController().processPayroll(nameIn, nameOut);
        }
    }
}
