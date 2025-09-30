package labs.lab04.mvc;

import javax.swing.*;
import java.text.DecimalFormat;

public class View {
    public int getRadius() {
        return Integer.parseInt(JOptionPane.showInputDialog("반지름을 입력하세요."));
    }

    public void showArea(int radius, double area) {
        DecimalFormat df = new DecimalFormat("#.##");
        String result = "반지름이 " + radius + "인 원의 면적은 " + df.format(area) + "입니다.";
        JOptionPane.showMessageDialog(null, result);
    }
}
