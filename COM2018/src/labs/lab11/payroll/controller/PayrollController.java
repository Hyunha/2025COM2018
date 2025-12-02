package labs.lab11.payroll.controller;

import labs.lab11.payroll.view.DialogReader;
import labs.lab11.payroll.view.PayrollReader;
import labs.lab11.payroll.view.PayrollWriter;

import javax.swing.*;

public class PayrollController {
    private String[] names;
    private int[] hours;
    private int[] payrates;
    private final int MAX_NUM = 100;

    public void processPayroll(String in, String out) {
        PayrollReader reader = new PayrollReader(in);
        PayrollWriter writer = new PayrollWriter(out);
        while (reader.getNextRecord()) {
            int payment = reader.hoursOf() * reader.payrateOf();
            writer.printCheck(reader.nameOf(), payment);
        }
        writer.printCheck("!");
        reader.close();
        writer.close();
    }

    private void reset() {
    }

    private int loadData(String in) {
        reset();
        int i = 0;
        return i;
    }

    public void processAddEmployee(String in) {
        int numOfEmployees = loadData(in);
        boolean updated = false;
    }

    public void processAddWorkHour(String in) {
        int numOfEmployees = loadData(in);
    }
}
