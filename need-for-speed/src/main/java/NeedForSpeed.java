class NeedForSpeed {
    int speed;
    int batteryDrain;
    int batteryStatus;
    int distanceDriven;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        this.batteryStatus = 100;
        this.distanceDriven = 0;
    }

    public boolean batteryDrained() {
        return batteryStatus - batteryDrain < 0;
    }

    public int distanceDriven() {
        return this.distanceDriven;
    }

    public void drive() {
        if (!batteryDrained()) {
            distanceDriven += speed;
            batteryStatus -= batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        return ((float) distance / car.speed) * car.batteryDrain <= car.batteryStatus;
    }
}
