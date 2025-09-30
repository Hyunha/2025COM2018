package labs.lab04.mvc;

public class Controller {
    public void control(Model m, View v) {
        int radius = v.getRadius();
        double area = m.area(radius);
        v.showArea(radius, area);
    }
}
