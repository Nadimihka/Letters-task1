import java.util.HashMap;
import java.util.Map;

public class Main {

    public static String text = "Lorem ipsum dolor sit amet, consectetur " +
            "adipiscing elit, sed do eiusmod tempor incididunt ut labore " +
            "et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud " +
            "exercitation ullamco laboris nisi ut aliquip ex ea commodo " +
            "consequat. Duis aute irure dolor in reprehenderit in voluptate " +
            "velit esse cillum dolore eu fugiat nulla pariatur. Excepteur " +
            "sint occaecat cupidatat non proident, sunt in culpa qui officia " +
            "deserunt mollit anim id est laborum.";

    public static Map.Entry<Character, Integer> max(Map<Character, Integer> letters) {
        Integer m = -1;
        Map.Entry<Character, Integer> maximum = null;
        for (Map.Entry<Character, Integer> entry : letters.entrySet()) {
            if (entry.getValue() > m) {
                m = entry.getValue();
                maximum = entry;
            }
        }
        return maximum;
    }

    public static Map.Entry<Character, Integer> min(Map<Character, Integer> letters) {
        Integer min = Integer.MAX_VALUE;
        Map.Entry<Character, Integer> minimum = null;

        for (Map.Entry<Character, Integer> entry : letters.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                minimum = entry;
            }
        }
        return minimum;
    }

    public static void main(String[] args) {

        Map<Character, Integer> letters = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            Character letter = Character.toLowerCase(text.charAt(i));
            if (Character.isLetter(letter)) {
                // if (!letter.equals(' ')) {
                if (letters.containsKey(letter)) {
                    letters.put(letter, letters.get(letter) + 1);
                } else {
                    letters.put(letter, 1);
                }
                //    System.out.println(letters.entrySet());
            }
        }
        Map.Entry<Character, Integer> maxLetter = max(letters);
        Map.Entry<Character, Integer> minLetter = min(letters);
        System.out.println("Чаще всего в тексте встречается буква " +
                maxLetter.getKey() + ", в количестве " + maxLetter.getValue() + " шт." +
                "\nРеже всего в тексте встречается буква " +
                minLetter.getKey() + ", в количестве " + minLetter.getValue() + " шт.");
    }
}
