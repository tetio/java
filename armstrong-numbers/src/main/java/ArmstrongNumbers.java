import java.util.ArrayList;
import java.util.List;

class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        List<Integer> digits = new ArrayList<>();
        int dummy = numberToCheck;
        int counter = 10;
        while (dummy > 0) {
            digits.add(dummy % counter);
            dummy /= 10;
        }
        int length = digits.size();
        return digits.stream().map(d -> (int)Math.pow(d, length)).reduce(0, (a, b) -> a + b) == numberToCheck;
    }

}
