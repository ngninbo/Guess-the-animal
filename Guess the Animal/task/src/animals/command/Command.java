package animals.command;

import animals.ressource.MessageRessource;

public interface Command {

    boolean execute();

    default String getMessage(String key) {
        return MessageRessource.getInstance().getProperty(key);
    }
}
