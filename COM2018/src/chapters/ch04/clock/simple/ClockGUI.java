package chapters.ch04.clock.simple;

import javax.swing.*;
import java.time.LocalTime;

public class ClockGUI {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, LocalTime.now());
    }
}
