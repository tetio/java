import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class RnaTranscription {
    private static final Map<Character, Character> map = new HashMap<>();

    static {
        map.put('G', 'C');
        map.put('C', 'G');
        map.put('T', 'A');
        map.put('A', 'U');
    }

    String transcribe(String dnaStrand) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dnaStrand.length(); i++) {
            sb.append(map.get(dnaStrand.charAt(i)));
        }
        return sb.toString();
    }

}
