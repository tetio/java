import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Say {
    private static final Map<Integer, String> DIGITS = Map.of(1, "one", 2, "two", 3, "three", 4, "four", 5, "five", 6,
            "six", 7, "seven", 8, "eight", 9, "nine", 0, "zero");

    public String say(long number) {
        if (number < 0 || number > 999999999) {
            throw new IllegalArgumentException("Not a valid number");
        }
        //StringBuilder sb = new StringBuilder();
        List<Integer> digits = new ArrayList<>();
        List<String> literals = new ArrayList<>();
        while (number > 0) {
            digits.add(Integer.valueOf((int) number % 10));
            number /= 10;
        }
        if (digits.size() == 1) {
            //sb.append(DIGITS.get(digits.getFirst()));
            literals.add(DIGITS.get(digits.getFirst()));
        } else if (!digits.isEmpty()) {
            List<String> l = IntStream.range(1, digits.size()).mapToObj(i -> transform(digits.reversed(), i))); //.collect(Collectors.joining(" "));
            //sb.append(aux);
            literals.addLast(aux);
        }
        //return (sb.isEmpty()) ? "zero" : sb.toString().trim();
        return (literals.isEmpty()) ? "zero" : String.join(" ", literals).trim();
    }

    private static String transform(List<Integer> digits, int index) {
        if (index == 1) {
            Integer aux = 10 * digits.get(1) + digits.getFirst();
            return switch (aux) {
                case Integer ignore when aux == 10 -> "ten";
                case Integer ignore when aux == 11 -> "eleven";
                case Integer ignore when aux == 12 -> "twelve";
                case Integer ignore when aux > 12 && aux < 20 -> DIGITS.get(digits.getFirst()) + "teen";
                case Integer ignore when aux == 20 -> "twenty";
                case Integer ignore when aux > 20 && aux < 30 -> "twenty-" + DIGITS.get(digits.getFirst());
                case Integer ignore when aux == 30 -> "thirty";
                case Integer ignore when aux > 30 && aux < 40 -> "thirty-" + DIGITS.get(digits.getFirst());
                case Integer ignore when aux == 40 -> "forty";
                case Integer ignore when aux > 40 && aux < 50 -> "forty-" + DIGITS.get(digits.getFirst());
                case Integer ignore when aux == 50 -> "fifty";
                case Integer ignore when aux > 50 && aux < 60 -> "fifty-" + DIGITS.get(digits.getFirst());
                case Integer ignore when aux == 60 -> "sixty";
                case Integer ignore when aux > 60 && aux < 70 -> "sixty-" + DIGITS.get(digits.getFirst());
                case Integer ignore when aux == 70 -> "seventy";
                case Integer ignore when aux > 70 && aux < 80 -> "seventy-" + DIGITS.get(digits.getFirst());
                case Integer ignore when aux == 80 -> "eighty";
                case Integer ignore when aux > 80 && aux < 90 -> "eighty-" + DIGITS.get(digits.getFirst());
                case Integer ignore when aux == 90 -> "ninety";
                case Integer ignore when aux > 90 && aux < 100 -> "ninety-" + DIGITS.get(digits.getFirst());
                default -> "";
            };
        } else  if (index == 2) {
            return DIGITS.get(digits.get(index)) + " hundred";
        } else if (index == 3) {
            return DIGITS.get(digits.get(index)) + " thousand";
        }
        return "";
    }
}
