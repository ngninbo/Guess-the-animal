package animals.command;

import animals.utils.MessageRessource;

public interface Command {

    boolean execute();

    default String getMessage(String key) {
        return MessageRessource.getInstance().getProperty(key);
    }
}
