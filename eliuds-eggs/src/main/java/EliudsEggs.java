import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class EliudsEggs {
    public int eggCount(int number) {
        int result = 0;
        while (number > 0) {
            result += number & 1;
            number >>= 1;
        }
        return result;
    }
}
