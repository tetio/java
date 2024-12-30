import java.util.stream.IntStream;

public class Hamming {
    int hammingDistance;

    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("strands must be of equal length");
        }
        hammingDistance = (int) IntStream.range(0, rightStrand.length())
                .filter(i -> rightStrand.charAt(i) != leftStrand.charAt(i))
                .count();
    }

    public int getHammingDistance() {
        return hammingDistance;
    }
}
