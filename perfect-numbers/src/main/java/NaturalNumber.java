import java.util.stream.IntStream;

class NaturalNumber {
    Classification classification;
    int number;

    NaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.number = number;
        Integer sum = IntStream.rangeClosed(1, (int) Math.sqrt(number))
                .filter(n -> n != number && number % n == 0)
                .flatMap(this::addComplement)
                .sum();
        classification = switch (sum) {
            case Integer ignored when sum == number -> Classification.PERFECT;
            case Integer ignored when sum < number -> Classification.DEFICIENT;
            default -> Classification.ABUNDANT;
        };
    }

    Classification getClassification() {
        return classification;
    }

    private IntStream addComplement(int i) {
        int complement = number / i;
        IntStream.Builder builder = IntStream.builder();
        builder.add(i);
        if (complement != i && complement != number) {
            builder.add(complement);
        }
        return builder.build();
    }
}
