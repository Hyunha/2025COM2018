package chapters.ch04.clock.mvc;

import javax.swing.*;
import java.time.LocalTime;

public class View {
    public void show(LocalTime t) {
        System.out.println(t);
    }

    public void showSwing(LocalTime t) {
        JOptionPane.showMessageDialog(null, t);
    }
}
