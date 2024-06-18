package words;

import java.util.*;

public class Words {
    public static List<String> getUniqueWordsFromSentence(String sentence) {
        String normalizedSentence = sentence.toLowerCase().replaceAll("[^a-z ]", " ");

// Split the sentence into words
        String[] wordsArray = normalizedSentence.split("\\s+");

// Convert the array to a set to remove duplicates
        Set<String> wordsSet = new HashSet<>(Arrays.asList(wordsArray));

// Convert the set back to a list and sort it
        List<String> uniqueWordsList = new ArrayList<>(wordsSet);
        Collections.sort(uniqueWordsList);
        System.out.printf("===" + uniqueWordsList);

        return uniqueWordsList;

    }
}
