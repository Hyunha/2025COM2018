package chapters.ch03;

import javax.swing.*;

public class ClassManagementOther {
    public static void main(String[] args) {
        double total_points = 0.0;
        int count = 0;
        boolean processing = true;
        while (processing) {
            // loop invariant : total_points == 지금까지 합산한 점수의 합
            String message = "다음 시험 점수? (입력 완료시 Cancel 버튼 누름)";
            String input = JOptionPane.showInputDialog(message);
            if (input == null) // Cancel 버튼을 눌렀음
                processing = false;
            else {
                int score = Integer.parseInt(input);
                total_points = total_points + score;
                count = count + 1;
            }
            System.out.println("개수 = " + count + ", 누적 점수 = " + total_points);
        }
        if (count == 0)
            throw new RuntimeException("computeAverage error: 계산할 점수가 없습니다.");

        System.out.println("평균 점수 = " + total_points / count);
    }
}
