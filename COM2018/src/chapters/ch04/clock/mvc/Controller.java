package chapters.ch04.clock.mvc;

public class Controller {
    public void control(Model m, View v) {
        v.showSwing(m.whatTimeIsIt());
    }
}
