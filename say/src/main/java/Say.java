import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Say {
    private static final Map<Long, String> DIGITS = Map.of(1L, "one", 2L, "two", 3L, "three", 4L, "four", 5L, "five", 6L,
            "six", 7L, "seven", 8L, "eight", 9L, "nine", 0L, "zero");

    public String say(long number) {
        if (number < 0 || number > 999_999_999_999L) {
            throw new IllegalArgumentException("Not a valid number");
        }
        String literals = "";
        List<List<Long>> triplets = new ArrayList<>();
        int totalDigits = String.valueOf(number).length();
        for (int i = 0; i < totalDigits; i += 3) {
            List<Long> triplet = new ArrayList<>();
            triplet.add(number % 10);
            if (i+1 < totalDigits) {
                number /= 10;
                triplet.add(number % 10);
            }
            if (i+2 < totalDigits) {
                number /= 10;
                triplet.add(number % 10);
            }
            number /= 10;
            triplets.add(triplet);
        }


        if (triplets.size() == 1) {
            literals = DIGITS.get(digits.getFirst());
        } else if (!digits.isEmpty()) {
//            List<String> list = IntStream.range(1, digits.size()).mapToObj(i -> transform(digits, i)).filter(c -> !c.isEmpty()).toList();
//            literals = String.join(" ", list.reversed()).trim();
        } else {
            literals = "zero";
        }
        return literals;
    }

    private static String transform(List<Long> digits, int index) {
        if (index == 1 || index == 4 || index == 7 || index == 10) {
            Long aux = 10 * digits.get(index) + digits.get(index - 1);
            return switch (aux) {
                case Long ignore when aux == 10 -> "ten";
                case Long ignore when aux == 11 -> "eleven";
                case Long ignore when aux == 12 -> "twelve";
                case Long ignore when aux > 12 && aux < 20 -> DIGITS.get(digits.get(index - 1)) + "teen";
                case Long ignore when aux == 20 -> "twenty";
                case Long ignore when aux > 20 && aux < 30 -> "twenty-" + DIGITS.get(digits.get(index - 1));
                case Long ignore when aux == 30 -> "thirty";
                case Long ignore when aux > 30 && aux < 40 -> "thirty-" + DIGITS.get(digits.get(index - 1));
                case Long ignore when aux == 40 -> "forty";
                case Long ignore when aux > 40 && aux < 50 -> "forty-" + DIGITS.get(digits.get(index - 1));
                case Long ignore when aux == 50 -> "fifty";
                case Long ignore when aux > 50 && aux < 60 -> "fifty-" + DIGITS.get(digits.get(index - 1));
                case Long ignore when aux == 60 -> "sixty";
                case Long ignore when aux > 60 && aux < 70 -> "sixty-" + DIGITS.get(digits.get(index - 1));
                case Long ignore when aux == 70 -> "seventy";
                case Long ignore when aux > 70 && aux < 80 -> "seventy-" + DIGITS.get(digits.get(index - 1));
                case Long ignore when aux == 80 -> "eighty";
                case Long ignore when aux > 80 && aux < 90 -> "eighty-" + DIGITS.get(digits.get(index - 1));
                case Long ignore when aux == 90 -> "ninety";
                case Long ignore when aux > 90 && aux < 100 -> "ninety-" + DIGITS.get(digits.get(index - 1));
                default -> "";
            };
        } else if (index == 2 || index == 5 || index == 8 || index == 11) {
            return (digits.get(index) > 0) ? DIGITS.get(digits.get(index)) + " hundred" : "";
        } else if (index == 3) {
            return (digits.get(index) > 0) ? DIGITS.get(digits.get(index)) + " thousand": "";
        } else if (index == 6) {
            return (digits.get(index) > 0) ? DIGITS.get(digits.get(index)) + " million": "";
        } else if (index == 9) {
            return (digits.get(index) > 0) ? DIGITS.get(digits.get(index)) + " billion": "";
        }
        return "";
    }
}
