class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    private int travelledUnits;
    private int numberOfVictories;

    public void drive() {
        this.travelledUnits += 10;
    }

    public int getDistanceTravelled() {
        return travelledUnits;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar o) {
        return o.getNumberOfVictories() - this.getNumberOfVictories();
    }
}
