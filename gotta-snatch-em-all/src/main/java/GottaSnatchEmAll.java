import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return Set.copyOf(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        return !myCollection.isEmpty() && !theirCollection.isEmpty()
                && myCollection.stream().anyMatch(b -> !theirCollection.contains(b))
                && !theirCollection.stream().allMatch(b -> myCollection.contains(b));
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> reference = collections.getFirst();
        Set<String> result = new HashSet<>(reference);
        for (Set<String> collection : collections.subList(1, collections.size())) {
            Set<String> tmpSet = reference.stream().filter(c -> collection.contains(c)).collect(Collectors.toSet());
            result = result.stream().filter(c -> tmpSet.contains(c)).collect(Collectors.toSet());
        }
        return result;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        return collections.stream().flatMap(Set::stream).collect(Collectors.toSet());
    }
}
