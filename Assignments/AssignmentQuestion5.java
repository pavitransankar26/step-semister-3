import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AssignmentQuestion5 {

    public static void printFilteredWordFrequency(String feedback) {

        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        feedback = feedback.toLowerCase();
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        String[] words = feedback.split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {

                if (frequency.containsKey(word)) {
                    frequency.put(word, frequency.get(word) + 1);
                } else {
                    frequency.put(word, 1);
                }
            }
        }

        ArrayList<String> wordList = new ArrayList<>(frequency.keySet());

        Collections.sort(wordList, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return frequency.get(word2) - frequency.get(word1);
            }
        });

        for (String word : wordList) {
            System.out.println(word + ": " + frequency.get(word));
        }
    }

    public static void main(String[] args) {

        String feedback =
                "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}
