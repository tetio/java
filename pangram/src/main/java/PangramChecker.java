import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PangramChecker {

    public static final int TOTAL_DIFFERENT_LETTERS = 26;

    public boolean isPangram(String input) {
        return input.toLowerCase().chars()
                .filter(Character::isLetter)
                .distinct()
                .count() == TOTAL_DIFFERENT_LETTERS;
    }

}
