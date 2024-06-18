package words;

import java.util.List;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Words {
    public static List<String> getUniqueWordsFromSentence(String sentence) {
        try {
            return Arrays.stream(sentence.toLowerCase()
                            .split("[\\s;.,:\\!\\?]+"))
                    .distinct()
                    .collect(Collectors.toList());
        } catch (UnsupportedOperationException e) {
            throw e;
        }
    }
}
