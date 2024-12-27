import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class DnDCharacter {
    private final int constitution;
    private final int dexterity;
    private final int strength;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;

    public DnDCharacter() {
        this.strength = ability(rollDice());
        this.intelligence = ability(rollDice());
        this.dexterity = ability(rollDice());
        this.wisdom = ability(rollDice());
        this.constitution = ability(rollDice());
        this.charisma = ability(rollDice());
    }

    int ability(List<Integer> scores) {
        List<Integer> tmpScores = scores.stream().sorted().toList();
        return IntStream.range(1, 4).map(tmpScores::get).reduce(0, Integer::sum);
    }

    List<Integer> rollDice() {
        Random rnd = new Random();
        return IntStream.range(0, 4).boxed().map(c -> rnd.nextInt(6) + 1).collect(Collectors.toList());
    }

    int modifier(int input) {
        return (int) Math.floor((input - 10) / 2.0);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return 10 + modifier(getConstitution());
    }
}
