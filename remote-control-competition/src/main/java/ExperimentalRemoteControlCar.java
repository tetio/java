public class ExperimentalRemoteControlCar implements RemoteControlCar {
    private int travelledUnits;
    public void drive() {
        this.travelledUnits += 20;
    }

    public int getDistanceTravelled() {
        return travelledUnits;
    }
}
