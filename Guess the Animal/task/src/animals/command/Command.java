package animals.command;

import animals.ressource.MessageFormatter;
import animals.service.NodeService;

public abstract class Command {

    protected GuessState state = GuessState.CONTINUE;

    public abstract GuessState execute();
    protected final NodeService nodeService;

    protected Command(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    public String format(String msgKey, Object... values) {
        return MessageFormatter.format(msgKey, values);
    }
}
