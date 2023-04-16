package animals.ressource;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class GuessGameRessource {

    private static final GuessGameRessource INSTANCE = new GuessGameRessource();

    private final ResourceBundle appResource = ResourceBundle.getBundle("App", Locale.getDefault());

    public static GuessGameRessource getInstance() {
        return INSTANCE;
    }



    public List<String> getByeOptions() {
        return Arrays.asList(appResource.getStringArray("game.bye"));
    }

    public List<String> getQuestions() {
        return Arrays.asList(appResource.getStringArray("game.questions"));
    }
}
