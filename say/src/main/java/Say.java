import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Say {
    private static final Map<Long, String> DIGITS = Map.of(1L, "one", 2L, "two", 3L, "three", 4L, "four", 5L, "five",
            6L, "six", 7L, "seven", 8L, "eight", 9L, "nine", 0L, "zero");

    public String say(long number) {
        if (number < 0 || number > 999_999_999_999L) {
            throw new IllegalArgumentException("Not a valid number");
        } else if (number == 0) {
            return "zero";
        }
        List<List<Long>> triplets = makeTriplets(number);
        List<String> listLiterals = IntStream.range(0, triplets.size())
                .mapToObj(index -> Say.transform(triplets.get(index), index)).toList();
        return listLiterals.reversed().stream().collect(Collectors.joining(" ")).trim();
    }

    private List<List<Long>> makeTriplets(long number) {
        List<List<Long>> triplets = new ArrayList<>();
        int totalDigits = String.valueOf(number).length();
        for (int i = 0; i < totalDigits; i += 3) {
            List<Long> triplet = new ArrayList<>();
            triplet.add(number % 10);
            if (i + 1 < totalDigits) {
                number /= 10;
                triplet.add(number % 10);
            } else {
                triplet.add(0L);
            }
            if (i + 2 < totalDigits) {
                number /= 10;
                triplet.add(number % 10);
            } else {
                triplet.add(0L);
            }
            number /= 10;
            triplets.add(triplet);
        }
        return triplets;
    }

    private static String transform(List<Long> digits, int index) {
        String literalU = "";
        String literalC = "";
        String literalDU = "";
        String literalM = "";
        Long number = digits.get(0) + digits.get(1) * 10 + digits.get(2) * 100;
        if (number < 10 && number > 0) {
            literalU = DIGITS.get(digits.get(0));
        }
        if (number > 99) {
            literalC = DIGITS.get(digits.get(2)) + " hundred";
        }
        if (number > 9) {
            Long aux = 10 * digits.get(1) + digits.get(0);
            literalDU = switch (aux) {
                case Long ignore when aux == 10 -> "ten";
                case Long ignore when aux == 11 -> "eleven";
                case Long ignore when aux == 12 -> "twelve";
                case Long ignore when aux > 12 && aux < 20 -> DIGITS.get(digits.get(0)) + "teen";
                case Long ignore when aux == 20 -> "twenty";
                case Long ignore when aux > 20 && aux < 30 -> "twenty-" + DIGITS.get(digits.get(0));
                case Long ignore when aux == 30 -> "thirty";
                case Long ignore when aux > 30 && aux < 40 -> "thirty-" + DIGITS.get(digits.get(0));
                case Long ignore when aux == 40 -> "forty";
                case Long ignore when aux > 40 && aux < 50 -> "forty-" + DIGITS.get(digits.get(0));
                case Long ignore when aux == 50 -> "fifty";
                case Long ignore when aux > 50 && aux < 60 -> "fifty-" + DIGITS.get(digits.get(0));
                case Long ignore when aux == 60 -> "sixty";
                case Long ignore when aux > 60 && aux < 70 -> "sixty-" + DIGITS.get(digits.get(0));
                case Long ignore when aux == 70 -> "seventy";
                case Long ignore when aux > 70 && aux < 80 -> "seventy-" + DIGITS.get(digits.get(0));
                case Long ignore when aux == 80 -> "eighty";
                case Long ignore when aux > 80 && aux < 90 -> "eighty-" + DIGITS.get(digits.get(0));
                case Long ignore when aux == 90 -> "ninety";
                case Long ignore when aux > 90 && aux < 100 -> "ninety-" + DIGITS.get(digits.get(0));
                default -> "";
            };
        }
        if (index == 0) {
            return (literalC + " " + literalDU + " " + literalU).trim();
        }
        if (index == 1 && (!literalC.isEmpty() || !literalDU.isEmpty() || !literalU.isEmpty())) {
            literalM = "thousand";
        }
        if (index == 2 && (!literalC.isEmpty() || !literalDU.isEmpty() || !literalU.isEmpty())) {
            literalM = "million";
        }
        if (index == 3 && (!literalC.isEmpty() || !literalDU.isEmpty() || !literalU.isEmpty())) {
            literalM = "billion";
        }

        literalU = (!literalU.isEmpty()) ? literalU + " " : "";
        return (literalC + " " + literalDU + " " + literalU + literalM).trim();
    }
}
