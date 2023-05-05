package animals.factories;

import animals.command.*;
import animals.domain.MenuItem;
import animals.service.NodeService;

public class CommandFactory {

    private final NodeService nodeService;

    public CommandFactory(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    public Command from(MenuItem menuItem) {

        switch (menuItem) {
            case PLAY:
                return new PlayCommand(nodeService);
            case LIST:
                return new ListCommand(nodeService);
            case SEARCH:
                return new SearchCommand(nodeService);
//            case DELETE:
//                return new DeleteCommand(nodeService);
            case STATISTICS:
                return new StatisticCommand(nodeService);
            case PRINT:
                return new PrintCommand(nodeService);
            case EXIT:
                return new ExitCommand(nodeService);
            default:
                //throw new IllegalArgumentException("Unknown command");
        }

        return null;
    }
}
