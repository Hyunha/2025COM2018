package chapters.ch10;

public class StringCompareTest {
    static void main() {
        String s = "abc";
        String t = new String("ab") + "c";
//        s = t;
        System.out.println(s == t);
        System.out.println(s.equals(t));
    }
}
