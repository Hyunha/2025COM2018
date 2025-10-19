package labs.lab05.simplealice;

public class Alice {
    public void eat(String food) {
        System.out.println("앨리스는 " + food + "을(를) 먹었습니다.");
    }

    public void drink(String beverage) {
        System.out.println("앨리스는 " + beverage + "을(를) 마셨습니다.");
    }

    public void enter(String door) {
        System.out.println("앨리스는 " + door + "에 들어갔습니다.");
    }

    public String getName() {
        return "앨리스";
    }

    public void growth(int height) {
        System.out.println("앨리스의 키가 " + height + "cm로 커졌습니다.");
    }

    public void shrink(int height) {
        System.out.println("앨리스의 키가 " + height + "cm로 작아졌습니다.");
    }
}
