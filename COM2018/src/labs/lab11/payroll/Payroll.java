package labs.lab11.payroll;

import labs.lab11.payroll.controller.PayrollController;
import labs.lab11.payroll.view.DialogReader;

import javax.swing.*;

public class Payroll {
    static void main() {
//        String nameIn = JOptionPane.showInputDialog("입력 파일명");
//        String nameOut = JOptionPane.showInputDialog("출력 파일명");
        String nameIn = "payroll.csv";
        String nameOut = "payroll.out.csv";

        PayrollController controller = new PayrollController();
        if (nameIn != null && nameOut != null) {
                    // 급여정산
                    controller.processPayroll(nameIn, nameOut);
        }
    }
}
