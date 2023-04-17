package animals.command;

import animals.ressource.MessageRessource;

public interface Command {

    boolean execute();

    default String format(String msgKey, Object... values) {
        return MessageRessource.getInstance().format(msgKey, values).concat("\n");
    }
}
