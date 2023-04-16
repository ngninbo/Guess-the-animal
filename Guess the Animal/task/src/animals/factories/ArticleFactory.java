package animals.factories;

import animals.domain.GuessGameValidator;
import animals.ressource.PatternRessource;

import java.text.MessageFormat;

public class ArticleFactory {

    private static final PatternRessource PATTERN_RESSOURCE = PatternRessource.getInstance();
    private static final GuessGameValidator VALIDATOR = GuessGameValidator.getInstance();

    public static boolean startsWithVowel(String word) {
        return word.matches(PATTERN_RESSOURCE.get("vowel.pattern"));
    }

    public static String withArticle(String word) {
        return MessageFormat.format(PATTERN_RESSOURCE.get(startsWithVowel(word) ? "animal.article_2_replace" : "animal.article_1_replace"), word);
    }

    /**
     * Determine determinant of given word/text
     * @param text {@link String}
     * @return {@link String} - word with determinant (a/an)
     */
    public static String addUndefinedArticle(String text) {


        if (VALIDATOR.matches().apply("undefined.article.pattern", text)) {
            return text;
        } else if (VALIDATOR.matches().apply("defined.article.pattern", text)){
            text = text.split(PATTERN_RESSOURCE.get("space.pattern"))[1];
            return withArticle(text);
        }

        return withArticle(text);
    }

    public static String removeAll(String text) {

        if (VALIDATOR.matches().apply("animal.article.pattern", text)) {
            return text.split(PATTERN_RESSOURCE.get("space.pattern"))[1];
        }

        return text;
    }
}
