package chapters.ch10.io;

import java.io.FileWriter;
import java.io.PrintWriter;

public class WriteTest {
    static void main() throws Exception {
        // 쓸 용도로 파일 만들고 열기
        FileWriter writer = new FileWriter("poem.txt");
        PrintWriter outfile = new PrintWriter(writer);
        outfile.println("가을이 오면...");
        outfile.println("학기가 저물고,");
        outfile.println("시험이 끝나면서");
        outfile.println("겨울이 온다.");
        outfile.close();                // 파일 닫기

        // 이어 쓸 용도로 파일 열기
        writer = new FileWriter("poem.txt", true);
        outfile = new PrintWriter(writer);
        outfile.println("방학이 되면...");
        outfile.println("뭘 할까?");
        outfile.close();                // 파일 닫기

    }
}
