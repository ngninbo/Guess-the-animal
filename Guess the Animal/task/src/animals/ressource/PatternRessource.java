package animals.ressource;

import animals.factories.RessourceFactory;

import java.util.ResourceBundle;

public class PatternRessource {

    private static final PatternRessource INSTANCE = new PatternRessource();

    private final ResourceBundle resourceBundle;

    {
        this.resourceBundle = RessourceFactory.of("patterns");
    }

    public static PatternRessource getInstance() {
        return INSTANCE;
    }

    public String get(String key) {
        return resourceBundle.getString(key);
    }
}
