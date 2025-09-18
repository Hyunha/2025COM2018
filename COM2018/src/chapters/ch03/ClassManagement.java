package chapters.ch03;

import javax.swing.*;

public class ClassManagement {
    public static void main(String[] args) {
        int how_many = 5;
        double total_points = 0.0;
        int count = 0;
        while (count < how_many) {
            // loop invariant : total_points == 지금까지 합산한 점수의 합
            String input = JOptionPane.showInputDialog("다음 시험 점수?");
            int score = Integer.parseInt(input);
            total_points = total_points + score;
            count = count + 1;
            System.out.println("개수 = " + count + ", 누적 점수 = " + total_points);
        }
        System.out.println("평균 점수 = " + total_points / how_many);
    }
}
