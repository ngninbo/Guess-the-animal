package animals.domain;

import animals.ressource.PatternRessource;
import lombok.NoArgsConstructor;

import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.regex.Pattern;

@NoArgsConstructor
public class GuessGameValidator {

    private static final GuessGameValidator INSTANCE = new GuessGameValidator();

    public static GuessGameValidator getInstance() {
        return INSTANCE;
    }

    public Predicate<String> isPositivResponse() {
        return answer -> matches("answer.positive", answer);
    }

    public Predicate<String> isNegativeResponse() {
        return answer -> matches("answer.negative", answer);
    }

    public Predicate<String> isPositivOrNegativeResponse() {
        return answer -> isPositivResponse().or(isNegativeResponse()).test(answer);
    }

    public boolean matches(String pattern, String text) {
        return pattern(pattern).matcher(text).matches();
    }

    public BiFunction<String, String, Boolean> matches() {
        return (pattern, text) -> pattern(pattern).matcher(text).matches();
    }

    public Pattern pattern(String pattern) {
        String regex = PatternRessource.getInstance().get(pattern);
        return Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    }
}
