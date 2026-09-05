public class AssignmentQuestion2 {

    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversed = new StringBuilder(words[i]);
            result += reversed.reverse().toString();

            if (i < words.length - 1) {
                result += " ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String sentence = "hello club";

        System.out.println(reverseEachWord(sentence));
    }
}
