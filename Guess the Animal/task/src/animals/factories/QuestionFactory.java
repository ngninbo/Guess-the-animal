package animals.factories;

import animals.domain.Verb;
import animals.ressource.MessageRessource;
import animals.ressource.PatternRessource;

import java.text.MessageFormat;
import java.util.Locale;

public class QuestionFactory {

    private static final PatternRessource PATTERN_RESSOURCE = PatternRessource.getInstance();

    /**
     * Transform fact about animal to a question
     * @param fact {@link String} - Known fact about animal
     * @return {@link String} - Question helping to distinguish an animal
     */
    public static String from(String fact) {

        if (!fact.matches(PATTERN_RESSOURCE.get("animals.facts.correct.pattern"))) {
            final String tmp = String.join(" ", PATTERN_RESSOURCE.get(Verb.TO_BE.getInterrogation()), fact).replace(".", "?");
            return tmp.endsWith(".") ? tmp.replace(".", "?") : tmp.concat("?");
        }

        String question = fact.replaceFirst(PATTERN_RESSOURCE.get("statement_replace.pattern"), "").trim();

        for (Verb verb : Verb.values()) {
            if (question.contains(PATTERN_RESSOURCE.get(verb.getValue()))) {
                question = question.replace(PATTERN_RESSOURCE.get(verb.getValue()), PATTERN_RESSOURCE.get(verb.getInterrogation()));
                break;
            }
        }

        return question.endsWith(".") ? question.replace(".", "?") : question.concat("?");
    }

    public static String verify(String animal) {

        if ("eo".equals(Locale.getDefault().getLanguage())) {
            animal = MessageFormat.format(PATTERN_RESSOURCE.get("animal.article_3_replace"), animal);
        }


        return MessageFormat.format(MessageRessource.getInstance().getProperty("guess.game.session.statement.verification.text"), animal);
    }
}
