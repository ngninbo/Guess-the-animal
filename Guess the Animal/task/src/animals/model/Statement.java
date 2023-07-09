package animals.model;

import animals.domain.Verb;
import animals.ressource.PatternRessource;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@EqualsAndHashCode
@ToString
public class Statement {

    private static final PatternRessource patternRessource = PatternRessource.getInstance();

    @Getter
    private final String text;

    public Statement(String text) {
        this.text = text;
    }

    public String negate() {
        return Arrays.stream(Verb.values())
                .filter(verb -> text.contains(patternRessource.get(verb.getValue())))
                .map(verb -> text.replace(patternRessource.get(verb.getValue()), patternRessource.get(verb.getNegation())))
                .findFirst()
                .orElse(text);
    }
}
