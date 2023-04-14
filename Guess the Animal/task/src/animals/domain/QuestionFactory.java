package animals.domain;

import animals.utils.MessageRessource;

public class QuestionFactory {

    private static final MessageRessource MESSAGE_RESSOURCE = MessageRessource.getInstance();

    /**
     * Transform fact about animal to a question
     * @param fact {@link String} - Known fact about animal
     * @return {@link String} - Question helping to distinguish an animal
     */
    public static String from(String fact) {

        if (!fact.matches("(It|it) (can|has|is).*")) {
            final String tmp = String.join(" ", MESSAGE_RESSOURCE.getProperty(Verb.IS.getInterrogation()), fact).replace(".", "?");
            return tmp.endsWith(".") ? tmp.replace(".", "?") : tmp.concat("?");
        }

        String question = fact.replaceFirst("It|it ", "").trim();

        for (Verb verb : Verb.values()) {
            if (question.contains(verb.name().toLowerCase())) {
                question = question.replace(verb.name().toLowerCase(), MESSAGE_RESSOURCE.getProperty(verb.getInterrogation()));
                break;
            }
        }

        return question.endsWith(".") ? question.replace(".", "?") : question.concat("?");
    }
}
