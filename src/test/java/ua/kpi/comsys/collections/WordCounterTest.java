package ua.kpi.comsys.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

class WordCounterTest {

    private final WordCounter counter = new WordCounter();

    @Test
    void countWordsCountsOccurrences() {
        Map<String, Integer> result = counter.countWords(List.of("the cat", "The dog and the cat"));
        assertEquals(Map.of("the", 3, "cat", 2, "dog", 1, "and", 1), result);
    }

    @Test
    void countWordsIsCaseInsensitive() {
        assertEquals(Map.of("hello", 3), counter.countWords(List.of("Hello HELLO hello")));
    }

    @Test
    void countWordsSplitsOnPunctuationAndKeepsDigits() {
        Map<String, Integer> result = counter.countWords(List.of("Hi, hi! abc123 -- abc123."));
        assertEquals(Map.of("hi", 2, "abc123", 2), result);
    }

    @Test
    void countWordsIgnoresNonLatinLetters() {
        assertEquals(Map.of("a", 1, "b", 1), counter.countWords(List.of("a привіт b")));
    }

    @Test
    void countWordsIgnoresEmptyTokens() {
        assertTrue(counter.countWords(List.of("", "   ", "!!! ,,,")).isEmpty());
    }

    @Test
    void countWordsEmptyListGivesEmptyMap() {
        assertTrue(counter.countWords(List.of()).isEmpty());
    }

    @Test
    void countWordsSkipsNullLines() {
        assertEquals(Map.of("a", 1), counter.countWords(Arrays.asList("a", null)));
    }

    @Test
    void countWordsNullThrows() {
        assertThrows(IllegalArgumentException.class, () -> counter.countWords(null));
    }

    @Test
    void getUniqueWordsReturnsDistinctLowercaseWords() {
        Set<String> result = counter.getUniqueWords(List.of("Apple banana", "BANANA cherry, apple"));
        assertEquals(Set.of("apple", "banana", "cherry"), result);
    }

    @Test
    void getUniqueWordsIgnoresEmptyAndNullLines() {
        assertTrue(counter.getUniqueWords(Arrays.asList("", " ", "...", null)).isEmpty());
    }

    @Test
    void getUniqueWordsEmptyListGivesEmptySet() {
        assertTrue(counter.getUniqueWords(List.of()).isEmpty());
    }

    @Test
    void getUniqueWordsNullThrows() {
        assertThrows(IllegalArgumentException.class, () -> counter.getUniqueWords(null));
    }
}
