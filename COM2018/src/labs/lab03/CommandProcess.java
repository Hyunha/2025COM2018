package labs.lab03;

import javax.swing.*;

public class CommandProcess {
    public static void main(String[] args) {
        String command = JOptionPane.showInputDialog("Input Command");
        command = command.toLowerCase();
        String status_log = "unknown";
        if ("start".equals(command)) {
            status_log = "Starting...";
        } else if ("stop".equals(command)) {
            status_log = "Stopping...";
        } else if ("pause".equals(command)) {
            status_log = "Pausing...";
        } else if ("resume".equals(command)) {
            status_log = "Resuming...";
        }

        System.out.println(status_log);
    }
}
