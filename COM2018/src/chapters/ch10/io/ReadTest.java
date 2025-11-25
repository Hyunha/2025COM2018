package chapters.ch10.io;

import javax.swing.*;
import java.io.*;

public class ReadTest {
    static void main() throws IOException {
        String file_name = JOptionPane.showInputDialog("읽을 파일 이름을 쓰세요.");
        FileReader reader = new FileReader(file_name);          // 읽을 용도로 파일 열기
        BufferedReader infile = new BufferedReader(reader);
        FileWriter writer = new FileWriter(file_name + ".out"); // 쓸 용도로 파일 열기
        PrintWriter outfile = new PrintWriter(writer);
        while (infile.ready()) {
            String s = infile.readLine();
            outfile.println(s);
        }
        outfile.close();    // 파일 모두 닫기
        infile.close();
    }
}
