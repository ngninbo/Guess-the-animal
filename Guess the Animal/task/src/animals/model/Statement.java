package animals.model;

import animals.domain.Verb;
import animals.ressource.PatternRessource;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Arrays;
import java.util.Objects;

public class Statement {

    private final String text;

    @JsonIgnore
    private static final PatternRessource patternRessource = PatternRessource.getInstance();

    public Statement(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String negate() {
        return Arrays.stream(Verb.values())
                .filter(verb -> text.contains(patternRessource.get(verb.getValue())))
                .map(verb -> text.replace(patternRessource.get(verb.getValue()), patternRessource.get(verb.getNegation())))
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
