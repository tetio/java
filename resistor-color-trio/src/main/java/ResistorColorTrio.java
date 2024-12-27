import java.util.Arrays;
import java.util.List;

class ResistorColorTrio {
    String label(String[] colors) {
        final List<String> codes = Arrays.asList("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white");
        return toString(codes.indexOf(colors[0]) * 10 + codes.indexOf(colors[1]), (colors.length >= 3) ? codes.indexOf(colors[2]) : 0);
    }

    private String toString(Integer value, Integer magnitude) {
        if (magnitude == 9)
            return value + " gigaohms";
        Integer finalValue = value * (int)Math.pow(10, magnitude);
        return switch (finalValue) {
            case Integer i when i < 100 -> i + " ohms";
            case Integer i when i < 1000 -> i + " ohms";
            case Integer i when i < 1000000 -> i / 1000 + " kiloohms";
            case Integer i when i < 1000000000 -> i / 1000000 + " megaohms";
            default -> throw new IllegalArgumentException();
        };
    }
}
