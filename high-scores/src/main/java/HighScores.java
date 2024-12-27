import java.util.List;

class HighScores {
    List<Integer> highScores;

    public HighScores(List<Integer> highScores) {
        this.highScores = highScores;
    }

    List<Integer> scores() {
        return highScores;
    }

    Integer latest() {
        return highScores.getLast();
    }

    Integer personalBest() {
        return highScores.stream().max(Integer::compare).orElseThrow();
    }

    List<Integer> personalTopThree() {
        int maxLength = Math.min(highScores.size(), 3);
        return highScores.stream().sorted((a, b) -> b - a).toList().subList(0, maxLength);
    }

}
