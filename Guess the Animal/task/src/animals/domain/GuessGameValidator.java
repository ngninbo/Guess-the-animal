package animals.domain;

import animals.utils.GuessingData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Predicate;

public class GuessGameValidator {

    private static final GuessGameValidator INSTANCE = new GuessGameValidator();

    private GuessingData data;

    private GuessGameValidator() {
        loadData();
    }

    public static GuessGameValidator getInstance() {
        return INSTANCE;
    }

    public GuessingData getData() {
        return data;
    }

    public Predicate<String> isPositivResponse() {
        return data.getPositivesResponses()::contains;
    }

    public Predicate<String> isPositivOrNegativeResponse() {
        return answer -> isPositivResponse().or(isNegativResponse()).test(answer);
    }

    public Predicate<String> isNegativResponse() {
        return data.getNegativesResponses()::contains;
    }

    private void loadData() {
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("guessing.data.json")) {
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readValue(inputStream, GuessingData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
