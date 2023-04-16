package animals.ressource;

import animals.factories.RessourceFactory;

import java.util.ResourceBundle;

public class MessageRessource {

    private static final MessageRessource INSTANCE = new MessageRessource();

    private final ResourceBundle resourceBundle;

    {
        this.resourceBundle = RessourceFactory.of("messages");
    }

    public static MessageRessource getInstance() {
        return INSTANCE;
    }

    public String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
