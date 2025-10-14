package chapters.ch06;

public class Scope {

    private int n = 3;

    public Scope() {
        System.out.println(n);

        int n = 333;

        System.out.println(n);
    }

    public static void main(String[] args) {
        new Scope();
    }
}