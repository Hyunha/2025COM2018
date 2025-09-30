package labs.lab03;

import javax.swing.*;

public class PyramidPrinterFor {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("높이를 입력하세요."));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
