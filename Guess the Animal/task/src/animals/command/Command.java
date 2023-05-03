package animals.command;

import animals.ressource.MessageFormatter;

public interface Command extends MessageFormatter {

    boolean execute();
}
