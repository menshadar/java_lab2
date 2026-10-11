package ua.kpi.comsys.collections;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Frequency analyzer for text. A word is a sequence of Latin letters and digits;
 * all words are lower-cased, empty tokens are ignored.
 */
public class WordCounter {

    private static final String NON_WORD = "[^a-zA-Z0-9]+";

    public Map<String, Integer> countWords(List<String> textLines) {
        requireNotNull(textLines);
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String line : textLines) {
            for (String word : split(line)) {
                counts.merge(word, 1, Integer::sum);
            }
        }
        return counts;
    }

    public Set<String> getUniqueWords(List<String> textLines) {
        requireNotNull(textLines);
        Set<String> words = new LinkedHashSet<>();
        for (String line : textLines) {
            words.addAll(split(line));
        }
        return words;
    }

    private static void requireNotNull(List<String> textLines) {
        if (textLines == null) {
            throw new IllegalArgumentException("textLines cannot be null");
        }
    }

    private static List<String> split(String line) {
        if (line == null) {
            return List.of();
        }
        return Arrays.stream(line.toLowerCase().split(NON_WORD))
                .filter(w -> !w.isEmpty())
                .toList();
    }
}
