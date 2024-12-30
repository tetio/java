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
        return makeSlicesOfThree(rnaSequence).stream().map(codons::get).toList();
    }

    private List<String> makeSlicesOfThree(String rnaSequence) {
        int sliceSize = 3;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < rnaSequence.length(); i += sliceSize) {
            String nextCodon = rnaSequence.substring(i, i + sliceSize);
            if (isStopOrInvalid(nextCodon)) {
                break;
            }
            res.add(nextCodon);
            if (!(i + sliceSize == rnaSequence.length()) && (i + 2 * sliceSize > rnaSequence.length())) {
                throw new IllegalArgumentException("Invalid codon");
            }

        }
        return res;
    }

    private boolean isStopOrInvalid(String codeon) {
        String codon = codons.get(codeon);
        if (null == codon) {
            throw new IllegalArgumentException("Invalid codon");
        }
        return "STOP".equals(codon);
    }

}
