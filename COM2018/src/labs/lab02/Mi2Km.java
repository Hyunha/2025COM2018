package labs.lab02;

import javax.swing.*;
import java.text.DecimalFormat;

public class Mi2Km {
    public static void main(String[] args) {
        int mile = Integer.parseInt(JOptionPane.showInputDialog("거리가 몇 마일입니까?"));
        double km = mile * 1.60934;
        DecimalFormat formatter = new DecimalFormat("0.0");
        JOptionPane.showMessageDialog(null, "" + mile + " 마일은 " + formatter.format(km) + " 킬로미터 입니다.");
    }
}
