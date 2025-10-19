package labs.lab05.simplealice;

public class Mushroom {
    public String getName(boolean isGrowthSide) {
        if (isGrowthSide) {
            return "키가 커지는 버섯";
        } else {
            return "키가 작아지는 버섯";
        }
    }

    public String getName() {
        return "버섯";
    }
}
