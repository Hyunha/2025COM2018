package labs.lab11.payroll.view;

import java.io.FileWriter;
import java.io.PrintWriter;

public class PayrollWriter {
    private PrintWriter outfile;

    public PayrollWriter(String file_name) {
        try {
            outfile = new PrintWriter(new FileWriter(file_name));
        }
        catch (Exception e) {
            System.out.println("PayrollWriter Error: " + file_name);
            throw new RuntimeException(e.toString());
        }
    }

    public void close() {
        outfile.close();
    }

    public void printCheck(String name, int payment) {
        outfile.println(name + "," + payment);
    }

    public void printCheck(String s) {
        outfile.println(s);
    }

    public static void main(String[] args) {
//        String name_in = JOptionPane.showInputDialog("입력 파일명");
//        String name_out = JOptionPane.showInputDialog("출력 파일명");
//        if (name_in != null && name_out != null)
//            new PayrollController().processPayroll(name_in, name_out);

        PayrollWriter pw = new PayrollWriter("payroll.out.csv");
        String[] names = {"홍길동", "전우치", "임꺽정"};
        int[] hours = { 24,40,36 };
        int[] payrates = { 18000, 15000, 13000 };

        for(int i = 0; i < names.length; i++) {
            pw.printCheck(names[i], hours[i] * payrates[i]);
        }
        pw.printCheck("!");
        pw.close();
    }
}
