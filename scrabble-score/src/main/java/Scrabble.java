import static java.util.Map.entry;

import java.util.Map;
import java.util.stream.IntStream;

class Scrabble {
    int score;

    Scrabble(String word) {
        this.score = word.toUpperCase().chars().map(Scrabble::score).sum();
    }

    int getScore() {
        return score;
    }

    private static int score(int c) {
        String s = Character.toString(c);
        if ("AEIOULNRST".contains(s)) {
            return 1;
        } else if ("DG".contains(s)) {
            return 2;
        } else if ("BCMP".contains(s)) {
            return 3;
        } else if ("FHVWY".contains(s)) {
            return 4;
        } else if ('K' == c) {
            return 5;
        } else if ("XJ".contains(s)) {
            return 8;
        } else if ("QZ".contains(s)) {
            return 10;
        }
        throw new IllegalArgumentException();
    }
}