public class CarsAssemble {

    public double productionRatePerHour(Integer speed) {
        int rawProduction = speed * 221;
        return switch (speed) {
            case Integer i when i <= 4 -> rawProduction;
            case Integer i when i <= 8 -> rawProduction * 0.9;
            case Integer i when i <= 9 -> rawProduction * 0.8;
            default -> rawProduction * 0.77;
        };
    }

    public int workingItemsPerMinute(int speed) {
        return (int) productionRatePerHour(speed) / 60;
    }
}
