package labs.lab03;

import javax.swing.*;

public class PyramidPrinterWhile {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("높이를 입력하세요."));
        int i = 0;
        while (i < n) {
            int j = 0;
            while (j <= i) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
