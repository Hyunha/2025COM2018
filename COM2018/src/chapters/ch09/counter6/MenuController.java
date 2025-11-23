package chapters.ch09.counter6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {
    private Counter model;
    private CounterFrame view;

    public MenuController(Counter model, CounterFrame view) {
        this.model = model;
        this.view = view;
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if ("빨강".equals(e.getActionCommand())) {
//            model.setColor(Color.RED);
//        } else if ("파랑".equals(e.getActionCommand())) {
//            model.setColor(Color.BLUE);
//        } else if ("노랑".equals(e.getActionCommand())) {
//            model.setColor(Color.YELLOW);
//        } else if ("Help".equals(e.getActionCommand())) {
//            JOptionPane.showMessageDialog(null, "공 찍는 프로그램\nver. 0.1");
//        } else if ("초기화".equals(e.getActionCommand())) {
//            model.reset();
//            view.update();
//        }
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "빨강":
                model.setColor(Color.RED); break;
            case "파랑":
                model.setColor(Color.BLUE); break;
            case "노랑":
                model.setColor(Color.YELLOW); break;
            case "Help":
                String msg = "공 찍는 프로그램\nver. 0.1";
                JOptionPane.showMessageDialog(null, msg);
                break;
            case "초기화":
                model.reset();
                view.update();
                break;
        }
    }
}
