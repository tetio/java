public class ElonsToyCar {
    int distanceDriven;
    int bateryStatus;

    public ElonsToyCar() {
        distanceDriven = 0;
        bateryStatus = 100;
    }

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return "Driven " + distanceDriven + " meters";
    }

    public String batteryDisplay() {
        return (bateryStatus == 0) ? "Battery empty" : "Battery at " + bateryStatus + "%";
    }

    public void drive() {
        if (bateryStatus > 0) {
            bateryStatus -= 1;
            distanceDriven += 20;
        }
    }
}
