import java.util.Arrays;
import java.util.stream.Collectors;

class Acronym {
    String acronym;

    Acronym(String phrase) {
        String aux = phrase.replaceAll("[-_,]", " ");
        acronym = Arrays.stream(aux.split(" ")).filter(c -> !c.isEmpty()).map(w -> w.substring(0, 1).toUpperCase()).collect(Collectors.joining());
    }

    String get() {
        return acronym;
    }
}
