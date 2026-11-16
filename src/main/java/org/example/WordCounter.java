package org.example;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private static final String TEXT = "When the offensive resumed, the Turks received their first victory when the Greeks encountered stiff resistance in the battles of First and Second İnönü,";

    public static Map<String, Integer> calculatedWord() {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : TEXT.toLowerCase().split("[^a-z]+")) {
            if (!word.isEmpty()) {
                counts.merge(word, 1, Integer::sum);
            }
        }
        return counts;
    }
}
