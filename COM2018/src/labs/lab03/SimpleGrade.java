package labs.lab03;

import javax.swing.*;

public class SimpleGrade {
    public static void main(String[] args) {
        int score = Integer.parseInt(JOptionPane.showInputDialog("총점을 입력하세요."));
        char grade;
        String message;
        if (score > 100 || score < 0) {
            message = "잘못된 점수입니다.";
        } else {
            score = score / 10;
            switch (score) {
                case 10:
                case 9:
                    grade = 'A';
                    break;
                case 8:
                    grade = 'B';
                    break;
                case 7:
                    grade = 'C';
                    break;
                case 6:
                    grade = 'D';
                    break;
                default:
                    grade = 'F';
                    break;
            }
            message = "당신의 학점은 " + grade + "입니다.";
        }
        JOptionPane.showMessageDialog(null, message);
    }
}
