package animals.domain;

public class ArticleFactory {

    public static final String VOWELS = "eaiouy";
    public static final String THE = "the";
    public static final String AN = "an";

    private static String of(String word) {
        return startsWithVowel(word) ? AN : "a";
    }

    public static boolean startsWithVowel(String word) {
        return VOWELS.indexOf(word.charAt(0)) >= 0;
    }

    public static String withArticle(String word) {
        return String.format("%s %s", ArticleFactory.of(word), word);
    }

    /**
     * Determine determinant of given word/text
     * @param text {@link String}
     * @return {@link String} - word with determinant (a/an)
     */
    public static String addUndefinedArticle(String text) {

        if (text.matches("^(" + AN + "?\\s)\\w+$")) {
            return text;
        } else if (text.matches("^(" + THE + "\\s)\\w+$")){
            text = text.split("\\s")[1];
            return withArticle(text);
        }

        return withArticle(text);
    }

    public static String removeAll(String text) {

        if (text.matches("^(" + THE + "|" + AN + "?\\s)\\w+$")) {
            return text.split("\\s")[1];
        }

        return text;
    }
}
