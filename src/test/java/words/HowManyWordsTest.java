package words;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class Words {

    public static List<String> getUniqueWordsFromSentence(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return Collections.emptyList();
        }

        // Convert to lowercase and remove punctuation
        String normalizedSentence = sentence.toLowerCase().replaceAll("[^a-z\\s]", "");

        // Split the sentence into words
        String[] wordsArray = normalizedSentence.split("\\s+");

        // Use a Set to store unique words
        Set<String> uniqueWordsSet = new HashSet<>(Arrays.asList(wordsArray));

        // Convert Set to List and return
        return new ArrayList<>(uniqueWordsSet);
    }
}
public class HowManyWordsTest {
    @Test
    public void howManyWords() {
        List<String> uniqueWords =
                Words.getUniqueWordsFromSentence("A cat Sat on a mat; a Monkey sat on the Cat.");

        List<String> expectedResult = List.of("a", "cat", "sat", "on", "the", "mat", "monkey");

        Assert.assertEquals(7, uniqueWords.size());
        for (String word : expectedResult) {
            Assert.assertTrue(String.format("Word '%s' should be included", word), uniqueWords.contains(word));
        }
    }
}
