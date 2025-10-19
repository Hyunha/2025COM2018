package labs.lab05.simplealice;

public class WonderLand {
    // First Scenario
//    public static void main(String[] args) {
//        Alice alice = new Alice();
//        Drink drink = new Drink();
//        alice.eat(drink.getName());
//        Cake cake = new Cake();
//        alice.eat(cake.getName());
//        Mushroom mushroom = new Mushroom();
//        alice.eat(mushroom.getName());
//        Door door = new Door();
//        alice.enter(door.getName());
//    }

    // Second Scenario
//    public static void main(String[] args) {
//        Alice alice = new Alice();
//        Drink drink = new Drink();
//        alice.eat(drink.getName());
//        Cake cake = new Cake();
//        alice.eat(cake.getName());
//        alice.growth(270);
//        Mushroom mushroom = new Mushroom();
//        alice.eat(mushroom.getName());
//        alice.shrink(40);
//        Door door = new Door();
//        alice.enter(door.getName());
//    }

    // Final Goal
    public static void main(String[] args) {
        Alice alice = new Alice();
        Drink drink = new Drink();
        alice.eat(drink.getTag() + "라고 쓰여진 " + drink.getName());
        alice.shrink(30);
        Cake cake = new Cake();
        alice.eat(cake.getTag() + "라고 쓰여진 " + cake.getName());
        alice.growth(270);
        Mushroom mushroom = new Mushroom();
        alice.eat(mushroom.getName(false));
        alice.shrink(40);
        Door door = new Door();
        alice.enter(door.getTag() + " " + door.getName());
    }
}
