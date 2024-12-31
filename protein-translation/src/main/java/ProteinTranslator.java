import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

class ProteinTranslator {

    Map<String, String> codons = Map.ofEntries(
            entry("AUG", "Methionine"),
            entry("UUU", "Phenylalanine"),
            entry("UUC", "Phenylalanine"),
            entry("UUA", "Leucine"),
            entry("UUG", "Leucine"),
            entry("UCU", "Serine"),
            entry("UCC", "Serine"),
            entry("UCA", "Serine"),
            entry("UCG", "Serine"),
            entry("UAU", "Tyrosine"),
            entry("UAC", "Tyrosine"),
            entry("UGU", "Cysteine"),
            entry("UGC", "Cysteine"),
            entry("UGG", "Tryptophan"),
            entry("UAA", "STOP"),
            entry("UAG", "STOP"),
            entry("UGA", "STOP")
    );

    List<String> translate(String rnaSequence) {
        int sliceSize = 3;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < rnaSequence.length(); i += sliceSize) {
            if (i + 3 <= rnaSequence.length()) {
                String protein = codons.get(rnaSequence.substring(i, i + sliceSize));
                if (protein == null) {
                    throw new IllegalArgumentException("Invalid codon");
                }
                if ("STOP".equals(protein)) {
                    break;
                }
                res.add(protein);
            } else {
                throw new IllegalArgumentException("Invalid codon");
            }
        }
        return res;
    }

}
