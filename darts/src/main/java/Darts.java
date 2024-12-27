class Darts {
    private static final int INNER_RING = 1;
    private static final int MIDDLE_RING = 5;
    private static final int OUTTER_RING = 10;

    int score(double xOfDart, double yOfDart) {
        double distance = Math.sqrt(xOfDart * xOfDart + yOfDart * yOfDart);
        if (distance > OUTTER_RING)
            return 0;
        else if (distance > MIDDLE_RING)
            return 1;
        else if (distance > INNER_RING)
            return 5;
        else
            return 10;
    }
}
