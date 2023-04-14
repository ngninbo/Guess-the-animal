package animals.model;

import animals.domain.Verb;
import animals.utils.MessageRessource;

import java.util.Arrays;
import java.util.Objects;

public class Statement {

    private final String text;

    public Statement(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String negate() {
        return Arrays.stream(Verb.values())
                .filter(verb -> text.contains(verb.name().toLowerCase()))
                .map(verb -> text.replace(verb.name().toLowerCase(), MessageRessource.getInstance().getProperty(verb.getNegation())))
                .findFirst()
                .orElse(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Statement)) return false;
        Statement statement = (Statement) o;
        return Objects.equals(getText(), statement.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getText());
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "sentence='" + text + '\'' +
                '}';
    }
}
