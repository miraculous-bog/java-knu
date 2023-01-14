import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static final String WORD = "чемпіонський";
    public static final char[] word = WORD.toCharArray();
    public static final Set<Character> VOWELS = Stream.of('а', 'о', 'у', 'е', 'и', 'і')
            .collect(Collectors.toSet());


    public static void main(String[] args) {

        int firstRule = firstRulePosNumber();
        int secondRule = secondRulePosNumber();
        int thirdRule = thirdRulePosNumber();
        if (firstRule != -1) {
            printResult(firstRule);
        }
        if (secondRule != -1) {
            printResult(secondRule);
        }
        if (thirdRule != -1) {
            printResult(thirdRule);
        }

    }

    static void printResult(int pos) {
        StringBuilder result = new StringBuilder();
        char[] res = new char[word.length + 1];
        for (int i = 0; i < word.length; i++) {
            if (i == pos)
                result.append('-');
            result.append(word[i]);
        }
        System.out.println(result);
    }

    static int firstRulePosNumber() {
        for (int i = 1; i < word.length - 2; i++) {
            if (VOWELS.contains(word[i]) && VOWELS.contains(word[i + 1])) {
                if (!VOWELS.contains(word[i - 1])) {
                    return i + 1;
                }
            }
        }
        return -1;
    }

    static int secondRulePosNumber() {
        for (int i = 1; i < word.length - 2; i++) {
            if (!VOWELS.contains(word[i]) && !VOWELS.contains(word[i + 1])) {
                if (VOWELS.contains(word[i - 1])) {
                    for (int j = i + 1; j < word.length; j++) {
                        if (VOWELS.contains(word[j]))
                            return i + 1;
                    }

                }
            }
        }
        return -1;
    }

    static int thirdRulePosNumber() {
        for (int i = 1; i < word.length - 2; i++) {
            if (VOWELS.contains(word[i])) {
                for (int j = i + 1; j < word.length - 1; j++) {
                    if (VOWELS.contains(word[j]))
                        return i + 1;
                }
            }
        }
        return -1;
    }
}