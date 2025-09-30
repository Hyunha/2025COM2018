package labs.lab04;

import javax.swing.*;
import java.text.DecimalFormat;

public class Circle {

    // initial main code
//    public static void main(String[] args) {
//        int radius = 5;
//        double area = Math.PI * radius * radius;
//        DecimalFormat df = new DecimalFormat("#.##");
//        System.out.println("Area of circle: " + df.format(area));
//    }

    // 4-1
    public double area(int raidus) {
        return Math.PI * raidus * raidus;
    }

    // 4-1
//    public static void main(String[] args) {
//        int radius = 5;
//        Circle c = new Circle();
//        double area = c.area(radius);
//        DecimalFormat df = new DecimalFormat("#.##");
//        System.out.println("Area of circle: " + df.format(area));
//    }

    // 4-2
    public static void main(String[] args) {
        int radius = Integer.parseInt(JOptionPane.showInputDialog("반지름을 입력하세요."));
        Circle c = new Circle();
        double area = c.area(radius);
        DecimalFormat df = new DecimalFormat("#.##");
        String result = "반지름이 " + radius + "인 원의 면적은 " + df.format(area) + "입니다.";
        JOptionPane.showMessageDialog(null, result);
    }
}
